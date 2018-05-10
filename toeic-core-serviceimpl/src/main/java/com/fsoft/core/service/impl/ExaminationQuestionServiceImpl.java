package vn.myclass.core.service.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fsoft.core.dao.ExaminationDao;
import com.fsoft.core.dao.ExaminationQuestionDao;
import com.fsoft.core.daoimpl.ExaminationDaoImpl;
import com.fsoft.core.daoimpl.ExaminationQuestionDaoImpl;
import com.fsoft.core.dto.ExaminationQuestionDTO;
import com.fsoft.core.dto.ExaminationQuestionImportDTO;
import com.fsoft.core.persistence.entity.ExaminationEntity;
import com.fsoft.core.persistence.entity.ExaminationQuestionEntity;
import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;
import vn.myclass.core.utils.ExaminationQuestionBeanUtil;

public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {

	private ExaminationQuestionDao examinationQuestionDao;
	private ExaminationDao examinationDao;

	public ExaminationQuestionServiceImpl() {
		examinationQuestionDao = new ExaminationQuestionDaoImpl();
		examinationDao = new ExaminationDaoImpl();
	}

	public void save(ExaminationQuestionDTO userDTO) {
		Timestamp createdDate = new Timestamp(System.currentTimeMillis());
		userDTO.setCreatedDate(createdDate);
		ExaminationQuestionEntity entity = ExaminationQuestionBeanUtil.dto2Entity(userDTO);
		SingletonDaoUtil.getExaminationQuestionDaoInstance().save(entity);
	}

	public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
		Integer id = (Integer) property.get("examinationId");
		property = new HashMap<>();
		property.put("examination", examinationDao.findById(id));
		Object[] objects = SingletonDaoUtil.getExaminationQuestionDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, "");
		List<ExaminationQuestionDTO> examinationQuestionDTOS = new ArrayList<ExaminationQuestionDTO>();
		for (ExaminationQuestionEntity item : (List<ExaminationQuestionEntity>) objects[1]) {
			ExaminationQuestionDTO examinationQuestionDTO = ExaminationQuestionBeanUtil.entity2Dto(item);
			examinationQuestionDTOS.add(examinationQuestionDTO);
		}
		objects[1] = examinationQuestionDTOS;
		return objects;
	}


	public ExaminationQuestionDTO update(ExaminationQuestionDTO userDTO) {
		ExaminationQuestionEntity entity = ExaminationQuestionBeanUtil.dto2Entity(userDTO);
		entity = SingletonDaoUtil.getExaminationQuestionDaoInstance().update(entity);
		userDTO = ExaminationQuestionBeanUtil.entity2Dto(entity);
		return userDTO;
	}

	public void saveImport(List<ExaminationQuestionDTO> examinationQuestionDTOS, Integer examinationId) {
		for (ExaminationQuestionDTO dto : examinationQuestionDTOS) {
			ExaminationQuestionEntity entity = new ExaminationQuestionEntity();
			entity.setAudio(dto.getAudio());
			entity.setImage(dto.getImage());
			entity.setCorrectAnswer(dto.getCorrectAnswer());
			entity.setQuestion(dto.getQuestion());
			entity.setOption1(dto.getOption1());
			entity.setOption2(dto.getOption2());
			entity.setOption3(dto.getOption3());
			entity.setOption4(dto.getOption4());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			entity.setCreatedDate(timestamp);
			entity.setType(dto.getType());
			ExaminationEntity examination = examinationDao.findById(examinationId);
			entity.setExamination(examination);
			SingletonDaoUtil.getExaminationQuestionDaoInstance().save(entity);
		}
	}

	public List<ExaminationQuestionEntity> findByExamination(List<String> names) {
		return null;
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

	public ExaminationQuestionDTO findById(Integer userId) {
		ExaminationQuestionEntity entity = SingletonDaoUtil.getExaminationQuestionDaoInstance().findById(userId);
		ExaminationQuestionDTO dto = ExaminationQuestionBeanUtil.entity2Dto(entity);
		return dto;
	}

	public void validateImportExamination(List<ExaminationQuestionImportDTO> userImportDTOS) {

	}

	@Override
	public void saveExaminationQuestionRandoms(Integer examinationId, int numberOfExaminationQuestion) {
		List<BigInteger> examinationQuestionIds = examinationQuestionDao.getAllExaminationQuestionIds();
		Collections.shuffle(examinationQuestionIds);
		List<BigInteger> examinationQuestionIdRandoms = examinationQuestionIds.subList(0, numberOfExaminationQuestion);
		for (BigInteger item : examinationQuestionIdRandoms) {
			Integer itemInteger = item.intValue();
			ExaminationQuestionEntity examinationQuestion = examinationQuestionDao.findById(itemInteger);
			examinationQuestion.setExaminationQuestionId(null);
			examinationQuestion.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			ExaminationEntity examination = examinationDao.findById(examinationId);
			examinationQuestion.setExamination(examination);
			examinationQuestion = examinationQuestionDao.save(examinationQuestion);
		}
	}
}
