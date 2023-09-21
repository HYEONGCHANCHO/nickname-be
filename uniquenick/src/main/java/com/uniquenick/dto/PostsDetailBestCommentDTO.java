package com.uniquenick.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostsDetailBestCommentDTO { //게시물 상세내용안에 들어갈 댓글 dto
        private Long commentId;
        private String commentContents;
        private Long commentLikeCount;
        private LocalDateTime dateCreated;
}
