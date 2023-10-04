package com.uniquenick.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder //    10.4. 수정사항 - 필요한 코드 추가.
//@Setter //    10.4. 수정사항 - 불필요한 코드 주석처리.
//@NoArgsConstructor //    10.4. 수정사항 - 불필요한 코드 주석처리.
//@AllArgsConstructor //    10.4. 수정사항 - 불필요한 코드 주석처리.
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


//    10.4. 수정사항 - 불필요한 코드 주석처리.

//    public NicknamePosts(String postWhere, String postTags, String postDetails, boolean postPublic, boolean postStatus, Long commentCount) {
//        this.postWhere = postWhere;
//        this.postTags = postTags;
//        this.postDetails = postDetails;
//        this.postPublic = postPublic;
//        this.postStatus = postStatus;
//        this.commentCount = commentCount;
//    }
}