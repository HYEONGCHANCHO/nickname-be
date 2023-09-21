package com.uniquenick.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostsDetailResponseDTO { //게시물 상세내용

    private Integer postId;
    private String postWhere;
    private List<String> postTags;
    private List<String> postDetail;
    private LocalDateTime datePostCreated;

}
