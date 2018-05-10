package vn.myclass.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Admin on 16/7/2017.
 */
public class ListenGuidelineDTO implements Serializable {
    private Integer listenGuidelineId;
    private String title;
    private String image;
    private String content;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

    public Integer getListenGuidelineId() {
        return listenGuidelineId;
    }

    public void setListenGuidelineId(Integer listenGuidelineId) {
        this.listenGuidelineId = listenGuidelineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
