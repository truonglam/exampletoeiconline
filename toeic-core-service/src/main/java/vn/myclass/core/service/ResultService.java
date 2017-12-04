package vn.myclass.core.service;

import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.dto.ResultDTO;

import java.util.List;

/**
 * Created by Admin on 3/12/2017.
 */
public interface ResultService {
	ResultDTO saveResult(String userName, Integer examinationId, List<ExaminationQuestionDTO> examinationQuestions);
}
