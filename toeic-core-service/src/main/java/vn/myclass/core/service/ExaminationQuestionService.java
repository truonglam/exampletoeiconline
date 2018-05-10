package vn.myclass.core.service;

import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.dto.ExaminationQuestionImportDTO;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;

import java.util.List;
import java.util.Map;

public interface ExaminationQuestionService {
	void save(ExaminationQuestionDTO userDTO);

	Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

	ExaminationQuestionDTO update(ExaminationQuestionDTO userDTO);

	void saveImport(List<ExaminationQuestionImportDTO> examinationQuestionImportDTOS);

	List<ExaminationQuestionEntity> findByExamination(List<String> names);

	Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId);

	void saveExaminationQuestionRandoms(Integer examinationId, int numberOfExaminationQuestion);

	void validateImportExamination(List<ExaminationQuestionImportDTO> userImportDTOS);
}
