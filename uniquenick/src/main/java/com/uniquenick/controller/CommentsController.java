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
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    PostService postService;

    @GetMapping("/trendingComments")

    public ResponseEntity<Map<String, String[]>> getTrendingComments() {
        String[] trendingComments = postService.getTrendingComments();
        Map<String, String[]> response = new HashMap<>();
        response.put("trendingComments", trendingComments);
        return ResponseEntity.ok(response);
    }



}