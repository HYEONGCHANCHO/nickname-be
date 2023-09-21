package com.uniquenick.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}