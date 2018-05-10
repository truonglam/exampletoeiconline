package vn.myclass.core.service;

import com.fsoft.core.dto.ExaminationQuestionDTO;
import com.fsoft.core.dto.ResultDTO;

import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public interface ResultService {
	ResultDTO saveResult(String userName, Integer examinationId, List<ExaminationQuestionDTO> examinationQuestions);
	List<ResultDTO> getResultsByUser(String userName, String examinationCode);
}
