package vn.myclass.core.service.impl;

import vn.myclass.core.dao.ExaminationDao;
import vn.myclass.core.dao.ExaminationQuestionDao;
import vn.myclass.core.daoimpl.ExaminationDaoImpl;
import vn.myclass.core.daoimpl.ExaminationQuestionDaoImpl;
import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.persistence.entity.ExaminationEntity;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;
import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;
import vn.myclass.core.utils.ExaminationQuestionBeanUtil;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {

	private ExaminationQuestionDao examinationQuestionDao;
	private ExaminationDao examinationDao;

	public ExaminationQuestionServiceImpl() {
		examinationQuestionDao = new ExaminationQuestionDaoImpl();
		examinationDao = new ExaminationDaoImpl();
	}

	public Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
		List<ExaminationQuestionDTO> result = new ArrayList<ExaminationQuestionDTO>();
		Object[] objects = SingletonDaoUtil.getExaminationQuestionDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, examinationId);
		int count = 1;
		for (ExaminationQuestionEntity item: (List<ExaminationQuestionEntity>)objects[1]) {
			ExaminationQuestionDTO dto = ExaminationQuestionBeanUtil.entity2Dto(item);
			if (item.getParagraph() == null) {
				dto.setNumber(count);
				count++;
			}
			dto.setExamination(ExaminationBeanUtil.entity2Dto(item.getExamination()));
			result.add(dto);
		}
		objects[1] = result;
		return objects;
	}

	@Override
	public void randomExaminationQuestion(Integer examinationId) {
		List<BigInteger> examinationQuestionIds = examinationQuestionDao.getAllExaminationQuestionIds();
		Collections.shuffle(examinationQuestionIds);
		int numberOfExaminationQuestion = 4;
		List<BigInteger> examinationQuestionIdRandoms = examinationQuestionIds.subList(0, numberOfExaminationQuestion);
		for (BigInteger item: examinationQuestionIdRandoms) {
			Integer itemInteger = item.intValue();
			ExaminationQuestionEntity examinationQuestion = examinationQuestionDao.findById(itemInteger);
			examinationQuestion.setExaminationQuestionId(null);
			examinationQuestion.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			ExaminationEntity examination = examinationDao.findById(examinationId);
			examinationQuestion.setExamination(examination);
			examinationQuestionDao.save(examinationQuestion);
		}
	}
}
