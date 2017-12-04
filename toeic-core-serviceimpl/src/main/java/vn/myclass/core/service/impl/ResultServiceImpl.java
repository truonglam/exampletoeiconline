package vn.myclass.core.service.impl;

import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.dto.ResultDTO;
import vn.myclass.core.persistence.entity.ExaminationEntity;
import vn.myclass.core.persistence.entity.ResultEntity;
import vn.myclass.core.persistence.entity.UserEntity;
import vn.myclass.core.service.ResultService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ResultBeanUtil;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public class ResultServiceImpl implements ResultService {
	public ResultDTO saveResult(String userName, Integer examinationId, List<ExaminationQuestionDTO> examinationQuestions) {
		ResultDTO result = new ResultDTO();
		if (userName != null && examinationId != null && examinationQuestions != null) {
			UserEntity user = SingletonDaoUtil.getUserDaoInstance().findEqualUnique("name", userName);
			ExaminationEntity examination = SingletonDaoUtil.getExaminationDaoInstance().findById(examinationId);
			ResultEntity resultEntity = new ResultEntity();
			calculateListenAndReadScore(resultEntity, examinationQuestions);
			initDataToResultEntity(resultEntity, user, examination);
			resultEntity = SingletonDaoUtil.getResultDaoInstance().save(resultEntity);
			result = ResultBeanUtil.entity2Dto(resultEntity);
		}
		return result;
	}

	private void initDataToResultEntity(ResultEntity resultEntity, UserEntity user, ExaminationEntity examination) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		resultEntity.setExamination(examination);
		resultEntity.setUser(user);
		resultEntity.setCreatedDate(timestamp);
	}

	private void calculateListenAndReadScore(ResultEntity resultEntity, List<ExaminationQuestionDTO> examinationQuestions) {
		int listenScore = 0;
		int readingScore = 0;
		for (ExaminationQuestionDTO item: examinationQuestions) {
			if (item.getAnswerUser() != null) {
				if (item.getAnswerUser().equals(item.getCorrectAnswer())) {
					if (item.getNumber() <= 4) {
						listenScore++;
					} else {
						readingScore++;
					}
				}
			}
		}
		resultEntity.setListenScore(listenScore);
		resultEntity.setReadingScore(readingScore);
	}
}
