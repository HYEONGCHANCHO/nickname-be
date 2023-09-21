package com.uniquenick.service;

import com.uniquenick.dto.*;

import java.util.List;

public interface PostService {
    Integer countPosts();
    PostsCreateResponseDTO createPost(PostsCreateRequestDTO request);
    String[] getTrendingComments();
    void deleteALl();
    void clearAndCreateTrendingComments();
    CommentCreateResponseDTO createComments(Integer postId, String comment);
    Long commentLikeCountUp(Integer postId, Long commentId);
    Long commentLikeCountDown(Integer postId, Long commentId);
    PostsDetailResponseDTO postDetail(Integer postId);
    PostsDetailBestCommentDTO postDetailBestComment(Integer postId);
    PostsDetailCommentDTO postDetailComment(Integer postId);

    public List<NicknamePostDTO> getLatestPublicPosts(int n);
}
