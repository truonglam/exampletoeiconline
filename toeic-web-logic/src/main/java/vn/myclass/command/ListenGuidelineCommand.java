package vn.myclass.command;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 16/7/2017.
 */
public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
