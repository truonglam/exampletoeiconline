package vn.myclass.core.service.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import vn.myclass.core.dao.ExaminationDao;
import vn.myclass.core.dao.ExaminationQuestionDao;
import vn.myclass.core.dao.ResultDao;
import vn.myclass.core.daoimpl.ExaminationDaoImpl;
import vn.myclass.core.daoimpl.ExaminationQuestionDaoImpl;
import vn.myclass.core.daoimpl.ResultDaoImpl;
import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.persistence.entity.ExaminationEntity;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;
import vn.myclass.core.persistence.entity.ResultEntity;
import vn.myclass.core.service.ExaminationService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 24/11/2017.
 */
public class ExaminationServiceImpl implements ExaminationService {

	private ExaminationDao examinationDao;
	private ExaminationQuestionDao examinationQuestionDao;
	private ResultDao resultDao;

	public ExaminationServiceImpl() {
		examinationDao = new ExaminationDaoImpl();
		examinationQuestionDao = new ExaminationQuestionDaoImpl();
		resultDao = new ResultDaoImpl();
	}

	public Object[] findExaminationByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
		List<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
		Object[] objects = SingletonDaoUtil.getExaminationDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit, null);
		for (ExaminationEntity item: (List<ExaminationEntity>)objects[1]) {
			ExaminationDTO dto = ExaminationBeanUtil.entity2Dto(item);
			result.add(dto);
		}
		objects[1] = result;
		return objects;
	}

	@Override
	public ExaminationDTO findById(String property, Integer id) {
		ExaminationEntity entity = SingletonDaoUtil.getExaminationDaoInstance().findEqualUnique(property, id);
		ExaminationDTO dto = ExaminationBeanUtil.entity2Dto(entity);
		return dto;
	}

	@Override
	public void save(ExaminationDTO dto) throws ConstraintViolationException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dto.setCreatedDate(timestamp);
		ExaminationEntity entity = ExaminationBeanUtil.dto2Entity(dto);
		SingletonDaoUtil.getExaminationDaoInstance().save(entity);
	}

	@Override
	public ExaminationDTO update(ExaminationDTO dto) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dto.setModifiedDate(timestamp);
		ExaminationEntity entity = ExaminationBeanUtil.dto2Entity(dto);
		entity = SingletonDaoUtil.getExaminationDaoInstance().update(entity);
		dto = ExaminationBeanUtil.entity2Dto(entity);
		return dto;
	}

	@Override
	public void delete(Integer id) {
		ExaminationEntity examination = examinationDao.findById(id);
		if (examination.getExaminationQuestions().size() > 0) {
			for (ExaminationQuestionEntity item: examination.getExaminationQuestions()) {
				examinationQuestionDao.delete(item.getExaminationQuestionId());
			}
		}
		if (examination.getResults().size() > 0) {
			for (ResultEntity item: examination.getResults()) {
				resultDao.delete(item.getResultId());
			}
		}
		examinationDao.delete(id);
	}

	@Override
	public List<ExaminationDTO> findAll() {
		List<ExaminationDTO> examinationDTOS = new ArrayList<>();
		List<ExaminationEntity> examinationEntities = examinationDao.findAll();
		examinationEntities.forEach(item -> {
			examinationDTOS.add(ExaminationBeanUtil.entity2Dto(item));
		});
		return examinationDTOS;
	}
}
