package vn.myclass.core.service;

import com.fsoft.core.dto.ExaminationQuestionDTO;
import com.fsoft.core.dto.ExaminationQuestionImportDTO;
import com.fsoft.core.persistence.entity.ExaminationQuestionEntity;

import java.util.List;
import java.util.Map;

public interface ExaminationQuestionService {
	void save(ExaminationQuestionDTO userDTO);

	Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);

	ExaminationQuestionDTO update(ExaminationQuestionDTO userDTO);

	void saveImport(List<ExaminationQuestionDTO> examinationQuestionDTOS, Integer examinationId);

	List<ExaminationQuestionEntity> findByExamination(List<String> names);

	Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId);

	void saveExaminationQuestionRandoms(Integer examinationId, int numberOfExaminationQuestion);

	void validateImportExamination(List<ExaminationQuestionImportDTO> userImportDTOS);
}
