package vn.myclass.core.web.utils;

import vn.myclass.core.service.impl.*;

/**
 * Created by Admin on 2/9/2017.
 */
public class SingletonServiceUtil {
    private static UserServiceImpl userServiceImpl = null;
    private static RoleServiceImpl roleServiceImpl = null;
    private static ListenGuidelineServiceImpl listenGuidelineServiceImpl = null;
    private static CommentServiceImpl commentServiceImpl = null;
    private static ExaminationQuestionServiceImpl examinationQuestionServiceImpl = null;
    private static ExaminationServiceImpl examinationServiceImpl = null;
    private static ExerciseQuestionServiceImpl exerciseQuestionServiceImpl = null;
    private static ExerciseServiceImpl exerciseServiceImpl = null;
    private static ResultServiceImpl resultServiceImpl = null;

    public static UserServiceImpl getUserServiceInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    public static RoleServiceImpl getRoleServiceInstance() {
        if (roleServiceImpl == null) {
            roleServiceImpl = new RoleServiceImpl();
        }
        return roleServiceImpl;
    }

    public static ListenGuidelineServiceImpl getListenGuidelineServiceInstance() {
        if (listenGuidelineServiceImpl == null) {
            listenGuidelineServiceImpl = new ListenGuidelineServiceImpl();
        }
        return listenGuidelineServiceImpl;
    }

    public static CommentServiceImpl getCommentServiceInstance() {
        if (commentServiceImpl == null) {
            commentServiceImpl = new CommentServiceImpl();
        }
        return commentServiceImpl;
    }

    public static ExaminationQuestionServiceImpl getExaminationQuestionServiceInstance() {
        if (examinationQuestionServiceImpl == null) {
            examinationQuestionServiceImpl = new ExaminationQuestionServiceImpl();
        }
        return examinationQuestionServiceImpl;
    }

    public static ExaminationServiceImpl getExaminationServiceInstance() {
        if (examinationServiceImpl == null) {
            examinationServiceImpl = new ExaminationServiceImpl();
        }
        return examinationServiceImpl;
    }

    public static ExerciseQuestionServiceImpl getExerciseQuestionServiceInstance() {
        if (exerciseQuestionServiceImpl == null) {
            exerciseQuestionServiceImpl = new ExerciseQuestionServiceImpl();
        }
        return exerciseQuestionServiceImpl;
    }

    public static ExerciseServiceImpl getExerciseServiceInstance() {
        if (exerciseServiceImpl == null) {
            exerciseServiceImpl = new ExerciseServiceImpl();
        }
        return exerciseServiceImpl;
    }

    public static ResultServiceImpl getResultServiceInstance() {
        if (resultServiceImpl == null) {
            resultServiceImpl = new ResultServiceImpl();
        }
        return resultServiceImpl;
    }
}
