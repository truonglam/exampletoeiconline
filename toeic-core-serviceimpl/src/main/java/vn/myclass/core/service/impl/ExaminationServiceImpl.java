package vn.myclass.core.service.impl;

import org.hibernate.exception.ConstraintViolationException;
import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.persistence.entity.ExaminationEntity;
import vn.myclass.core.persistence.entity.ExaminationEntity;
import vn.myclass.core.service.ExaminationService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ExaminationServiceImpl implements ExaminationService {
	public List<ExaminationDTO> findAll() {
		List<ExaminationEntity> entities = SingletonDaoUtil.getExaminationDaoInstance().findAll();
		List<ExaminationDTO> dtos = new ArrayList<ExaminationDTO>();
		for (ExaminationEntity item: entities) {
			ExaminationDTO dto = ExaminationBeanUtil.entity2Dto(item);
			dtos.add(dto);
		}
		return dtos;
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

	public ExaminationDTO findById(String property, Integer id) {
		ExaminationEntity entity = SingletonDaoUtil.getExaminationDaoInstance().findEqualUnique(property, id);
		ExaminationDTO dto = ExaminationBeanUtil.entity2Dto(entity);
		return dto;
	}

	public void save(ExaminationDTO dto) throws ConstraintViolationException {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dto.setCreatedDate(timestamp);
		ExaminationEntity entity = ExaminationBeanUtil.dto2Entity(dto);
		SingletonDaoUtil.getExaminationDaoInstance().save(entity);
	}

	public ExaminationDTO update(ExaminationDTO dto) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		dto.setModifiedDate(timestamp);
		ExaminationEntity entity = ExaminationBeanUtil.dto2Entity(dto);
		entity = SingletonDaoUtil.getExaminationDaoInstance().update(entity);
		dto = ExaminationBeanUtil.entity2Dto(entity);
		return dto;
	}

	public Integer delete(List<Integer> ids) {
		Integer result = SingletonDaoUtil.getExaminationDaoInstance().delete(ids);
		return result;
	}
}
