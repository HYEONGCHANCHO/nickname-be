package com.uniquenick.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder //    10.4. 수정사항 - 필요한 코드 추가.
//@Setter //    10.4. 수정사항 - 불필요한 코드 주석처리.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "NicknameComments")
public class NicknameComments extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nicknameCommentsId")
    private Long nicknameCommentsId;

    @Column(name = "commentContent")
    private String commentContent;

    @Column(name = "commentLikeCount")
    private Long commentLikeCount;

    @Column(name = "commentStatus")
    private boolean commentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private NicknamePosts nicknamePosts;

    //    10.4. 수정사항 - 불필요한 코드 주석처리.
//    public NicknameComments(String CommentContent, Long commentLikeCount, boolean commentStatus, NicknamePosts nicknamePosts){
//        this.commentContent = CommentContent;
//        this.commentLikeCount = commentLikeCount;
//        this.commentStatus = commentStatus;
//        this.nicknamePosts = nicknamePosts;
//    }

}