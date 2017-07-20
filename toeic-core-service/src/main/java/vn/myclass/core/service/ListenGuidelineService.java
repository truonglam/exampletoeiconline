package vn.myclass.core.service;

import vn.myclass.core.dto.ListenGuidelineDTO;

import java.util.List;

/**
 * Created by Admin on 16/7/2017.
 */
public interface ListenGuidelineService {
    Object[] findListenGuidelineByProperties(String property, Object value, String sortExpression, String sortDirection, Integer offset, Integer limit);
}
