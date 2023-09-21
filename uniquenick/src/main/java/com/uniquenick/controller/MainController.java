package com.uniquenick.controller;


import com.uniquenick.dto.*;
import com.uniquenick.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    PostService postService;
    @GetMapping("/postCount")
    public ResponseEntity<Map<String, Long>> getPostCount() {
        long postCount = postService.countPosts();
        Map<String, Long> response = new HashMap<>();
        response.put("postCount", postCount);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/comments/trendingComments")
    public ResponseEntity<Map<String, String[]>> getTrendingComments() {
        String[] trendingComments = postService.getTrendingComments();
        Map<String, String[]> response = new HashMap<>();
        response.put("trendingComments", trendingComments);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/posts")
    public ResponseEntity<PostsCreateResponseDTO> createPost(@RequestBody PostsCreateRequestDTO request) {
        PostsCreateResponseDTO response = postService.createPost(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentCreateResponseDTO> createPostComment(@PathVariable("postId") Integer postId, @RequestParam String comment) {
        CommentCreateResponseDTO response = postService.createComments(postId, comment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/posts/{postId}/comments/likeUp/{commentId}")
    public ResponseEntity<Map<String, Long>> postCommentLikeCountUp(@PathVariable("postId") Integer postId,@PathVariable("commentId") Long commentId) {

       long commentLikeCount = postService.commentLikeCountUp(postId, commentId);
       Map<String, Long> response = new HashMap<>();
       response.put("commentLikeCount", commentLikeCount);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/posts/{postId}/comments/likeDown/{commentId}")
    public ResponseEntity<Map<String, Long>> postCommentLikeCountDown(@PathVariable("postId") Integer postId,@PathVariable("commentId") Long commentId) {

       long commentLikeCount = postService.commentLikeCountDown(postId, commentId);
       Map<String, Long> response = new HashMap<>();
       response.put("commentLikeCount", commentLikeCount);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<Map<String, Object>> getPostDetail(@PathVariable("postId") Integer postId){

        PostsDetailResponseDTO postDetails=postService.postDetail(postId);
        PostsDetailBestCommentDTO postsDetailBestCommentDTO = postService.postDetailBestComment(postId);
        PostsDetailCommentDTO postsDetailCommentDTO = postService.postDetailComment(postId);

        Map<String, Object> response = new HashMap<>();
        response.put("postDetails", postDetails);
        response.put("bestCommentDTO", postsDetailBestCommentDTO);
        response.put("postsDetailCommentDTO", postsDetailCommentDTO);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/recentPosts")
    public ResponseEntity<List<Map<String, Object>>> getRecentPost(){

        List<Map<String, Object>> responseList = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            PostsDetailResponseDTO postDetails = postService.postDetail(i);
            PostsDetailBestCommentDTO postsDetailBestCommentDTO = postService.postDetailBestComment(i);
            PostsDetailCommentDTO postsDetailCommentDTO = postService.postDetailComment(i);

            Map<String, Object> response = new HashMap<>();
            response.put("postId", i);
            response.put("postDetails", postDetails);
            response.put("bestCommentDTO", postsDetailBestCommentDTO);
            response.put("postsDetailCommentDTO", postsDetailCommentDTO);

            responseList.add(response);
        }

        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/posts/{postId}/nextPosts")
    public ResponseEntity<List<Map<String, Object>>> getNextRecentPost(@PathVariable("postId") Integer postId){

        List<Map<String, Object>> responseList = new ArrayList<>();

        for (int i = postId+1; i <= postId+5; i++) {
            PostsDetailResponseDTO postDetails = postService.postDetail(i);
            PostsDetailBestCommentDTO postsDetailBestCommentDTO = postService.postDetailBestComment(i);
            PostsDetailCommentDTO postsDetailCommentDTO = postService.postDetailComment(i);

            Map<String, Object> response = new HashMap<>();
            response.put("postId", i); // postId를 포함한 정보를 담을 수도 있습니다.
            response.put("postDetails", postDetails);
            response.put("bestCommentDTO", postsDetailBestCommentDTO);
            response.put("postsDetailCommentDTO", postsDetailCommentDTO);

            responseList.add(response);
        }

        return ResponseEntity.ok(responseList);
    }



}