package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Admin on 4/6/2017.
 */
@Entity
@Table(name = "user")
public class ListenGuideline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuidelineId;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "content")
    private String content;

    @Column(name = "createddate")
    private Timestamp createdDate;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @OneToMany(mappedBy = "listenGuideline", fetch = FetchType.LAZY)
    private List<Comment> commentList;

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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
