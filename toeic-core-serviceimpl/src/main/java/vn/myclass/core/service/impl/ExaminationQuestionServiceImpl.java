package vn.myclass.core.service.impl;

import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.dto.ExaminationQuestionImportDTO;
import vn.myclass.core.persistence.entity.ExaminationQuestionEntity;
import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.utils.SingletonDaoUtil;
import vn.myclass.core.utils.ExaminationQuestionBeanUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {

    public void save(ExaminationQuestionDTO userDTO) {
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        userDTO.setCreatedDate(createdDate);
        ExaminationQuestionEntity entity = ExaminationQuestionBeanUtil.dto2Entity(userDTO);
        SingletonDaoUtil.getExaminationQuestionDaoInstance().save(entity);
    }

    public Object[] findByProperty(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
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

    public void saveImport(List<ExaminationQuestionImportDTO> examinationQuestionImportDTOS) {
        for (ExaminationQuestionImportDTO dto : examinationQuestionImportDTOS) {
            if (dto.isValid()) {
                ExaminationQuestionEntity entity = new ExaminationQuestionEntity();
                entity.setAudio(dto.getAudio());
                entity.setImage(dto.getImage());
                entity.setCorrectAnswer(dto.getCorrectAnswer());
                entity.setQuestion(dto.getQuestion());
                entity.setOption1(dto.getOption1());
                entity.setOption2(dto.getOption2());
                entity.setOption3(dto.getOption3());
                entity.setOption4(dto.getOption4());
                entity.setCreatedDate(dto.getCreatedDate());
                entity.setModifiedDate(dto.getModifiedDate());
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                entity.setCreatedDate(timestamp);
                SingletonDaoUtil.getExaminationQuestionDaoInstance().save(entity);
            }
        }
    }

    public List<ExaminationQuestionEntity> findByExamination(List<String> names) {
        return null;
    }

    public Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
        return new Object[0];
    }

    public ExaminationQuestionDTO findById(Integer userId) {
        ExaminationQuestionEntity entity = SingletonDaoUtil.getExaminationQuestionDaoInstance().findById(userId);
        ExaminationQuestionDTO dto = ExaminationQuestionBeanUtil.entity2Dto(entity);
        return dto;
    }

    public void validateImportExamination(List<ExaminationQuestionImportDTO> userImportDTOS) {

    }
}
