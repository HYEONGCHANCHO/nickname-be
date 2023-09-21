package com.uniquenick.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostsCreateRequestDTO { //게시글 생성할때 프론트에서 요청하는 dto

    private String postWhere;
    private List<String> postTags;
    private List<String>  postDetails;
    private boolean postPublic;
    private boolean postStatus;

    public PostsCreateRequestDTO(String postWhere, List<String>  postTags, List<String>  postDetails, boolean postPublic, boolean postStatus) {
        this.postWhere = postWhere;
//        this.postTags = String.join(",", postTags);
//        this.postDetails = String.join(",", postDetails);
        this.postTags = postTags;
        this.postDetails = postDetails;
        this.postPublic = postPublic;
        this.postStatus = postStatus;
    }
}

    //    public String getPostWhere() {
//        return postWhere;
//    }
//
//    public void setPostWhere(String postWhere) {
//        this.postWhere = postWhere;
//    }

//    public String[] getPostTags() {
//        return postTags;
//    }
//
//    public void setPostTags(String[] postTags) {
//        this.postTags = postTags;
//    }

//public String getPostTags() {
//    return postTags;
//}
//
//    public void setPostTags(String[] tags) {
//        this.postTags = String.join(",", tags);
//    }

//    // JSON 직렬화 메소드
//    public void setPostTags(String[] tags) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            this.postTags = objectMapper.writeValueAsString(tags);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//    public String[] getPostTags() {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.readValue(postTags, String[].class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }    // JSON 직렬화 메소드
//    public void setPostDetails(String[] tags) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            this.postDetails = objectMapper.writeValueAsString(tags);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//


//    public String[] getPostDetails() {
//        return postDetails;
//    }
//
//    public void setPostDetails(String[] postDetails) {
//        this.postDetails = postDetails;
//    }
//
//    public boolean isPostPublic() {
//        return postPublic;
//    }
//
//    public void setPostPublic(boolean postPublic) {
//        this.postPublic = postPublic;
//    }
//
//    public boolean isPostStatus() {
//        return postStatus;
//    }
//
//    public void setPostStatus(boolean postStatus) {
//        this.postStatus = postStatus;
//    }

//}
