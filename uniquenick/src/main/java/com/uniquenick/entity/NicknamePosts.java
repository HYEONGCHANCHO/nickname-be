package com.uniquenick.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
//@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "NicknamePosts")
public class NicknamePosts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Integer postId;

    @Column(name = "postWhere")
    private String postWhere;

    @Column(name = "postTags")
    private String postTags;

    @Column(name = "postDetails")
    private String postDetails;

    @Column(name = "postPublic")
    private boolean postPublic;

    @Column(name = "postStatus")
    private boolean postStatus;

    @Column(name = "commentCount")
    private Long commentCount;

    @OneToMany(mappedBy = "NicknamePosts")
    private List<NicknameComments> nicknameCommentsList;



    public NicknamePosts(String postWhere, String postTags, String postDetails, boolean postPublic, boolean postStatus, Long commentCount) {
        this.postWhere = postWhere;
        this.postTags = postTags;
        this.postDetails = postDetails;
        this.postPublic = postPublic;
        this.postStatus = postStatus;
        this.commentCount = commentCount;
    }
}