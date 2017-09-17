package vn.myclass.core.service;

import vn.myclass.core.dto.ListenGuidelineDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 16/7/2017.
 */
public interface ListenGuidelineService {
    Object[] findListenGuidelineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit);
    ListenGuidelineDTO findByListenGuidelineId(String property, Integer listenGuideLineId);
    void saveListenGuideline(ListenGuidelineDTO dto);
}
