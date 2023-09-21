package com.uniquenick.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NicknamePostDTO {

        private Integer postId;
        private String postWhere;
        private String postTags;
        private String postDetails;
        private boolean postPublic;
        private boolean postStatus;
        private Long commentCount;

        // 생성자, Getter/Setter 등...
}
