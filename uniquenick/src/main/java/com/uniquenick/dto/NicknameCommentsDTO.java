package com.uniquenick.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class NicknameCommentsDTO {
    private Long commentId;
    private Integer postId;
    private String commentContent;
    private Long commentLikeCount;
    private boolean commentStatus;
    private Timestamp dateCreated;
    private Timestamp dateUpdated;

}
