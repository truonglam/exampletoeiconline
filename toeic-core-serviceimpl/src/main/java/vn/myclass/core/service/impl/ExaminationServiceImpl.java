package vn.myclass.core.service.impl;

import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.persistence.entity.ExaminationEntity;
import vn.myclass.core.service.ExaminationService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 24/11/2017.
 */
public class ExaminationServiceImpl implements ExaminationService {
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
}
