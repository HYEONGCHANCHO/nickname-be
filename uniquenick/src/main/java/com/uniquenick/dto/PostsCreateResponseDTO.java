package com.uniquenick.dto;

import java.time.LocalDateTime;

public class PostsCreateResponseDTO {//게시글 생성할때 프론트에 반환하는 dto


    private Integer postId;
    private LocalDateTime dateCreated;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }


    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

}
