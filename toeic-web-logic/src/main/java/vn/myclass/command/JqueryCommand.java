package vn.myclass.command;

import vn.myclass.core.dto.JqueryDTO;
import vn.myclass.core.web.command.AbstractCommand;

/**
 * Created by Admin on 19/8/2017.
 */
public class JqueryCommand extends AbstractCommand<JqueryDTO> {
    public JqueryCommand() {
        this.pojo = new JqueryDTO();
    }
    private String urlType;

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }
}
