package com.uniquenick.dto;

import java.time.LocalDateTime;


public class CommentCreateResponseDTO { //댓글 생성 정보를 보이는 dto

    private Long commentId;
    private Long commentLikeCount;
    private LocalDateTime dateCommentCreated;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(Long commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public LocalDateTime getDateCommentCreated() {
        return dateCommentCreated;
    }

    public void setDateCommentCreated(LocalDateTime dateCommentCreated) {
        this.dateCommentCreated = dateCommentCreated;
    }
}
