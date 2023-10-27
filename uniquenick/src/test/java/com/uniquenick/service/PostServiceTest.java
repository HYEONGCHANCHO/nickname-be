//package com.uniquenick.service;
//
//import com.uniquenick.dto.PostsCreateRequestDTO;
//import com.uniquenick.dto.PostsCreateResponseDTO;
//import com.uniquenick.entity.NicknamePosts;
//import com.uniquenick.repository.NicknameCommentsRepository;
//import com.uniquenick.repository.NicknamePostsRepository;
//import com.uniquenick.repository.TrendingCommentsRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//public class PostServiceTest {
//
//    @Autowired
//    private NicknamePostsRepository nicknamePostsRepository;
////    @Autowired
////    private final TrendingCommentsRepository trendingCommentsRepository;
////    @Autowired
////    private final NicknameCommentsRepository nicknameCommentsRepository;
//    @Autowired
//    JavaObjectService javaObjectService;
//
////    public PostServiceTest(NicknamePostsRepository nicknamePostsRepository) {
////        this.nicknamePostsRepository = nicknamePostsRepository;
////
////}
////    public PostServiceTest(NicknamePostsRepository nicknamePostsRepository, TrendingCommentsRepository trendingCommentsRepository, NicknameCommentsRepository nicknameCommentsRepository) {
////        this.nicknamePostsRepository = nicknamePostsRepository;
////        this.trendingCommentsRepository = trendingCommentsRepository;
////        this.nicknameCommentsRepository = nicknameCommentsRepository;
////    }
//
//
//    @Test
//    @Transactional
//    void countPostsTest(){
//
//        boolean defaultPublic = true;
//        boolean defaultStatus = true;
//        Long defaultCommentCount = 0L;
//        List<String> testTagList1 = List.of("test tag1","test tag2");
//        List<String> testDetailList1 = List.of("test detail1","test detail2");
//
//        String postTagsJson1 = javaObjectService.convertJavaObjectToJson(testTagList1);
//        String postDetailsJson1 = javaObjectService.convertJavaObjectToJson(testDetailList1);
//        NicknamePosts nicknamePosts1 = NicknamePosts.builder().postWhere("test postwhere").postTags(postTagsJson1).postDetails(postDetailsJson1).postPublic(defaultPublic).postStatus(defaultStatus).commentCount(defaultCommentCount).build();
//
//        nicknamePostsRepository.save(nicknamePosts1);
//
//        long countPost = nicknamePostsRepository.count();
//
//        List<String> testTagList2 = List.of("test tag1","test tag2");
//        List<String> testDetailList2 = List.of("test detail1","test detail2");
//
//        String postTagsJson2 = javaObjectService.convertJavaObjectToJson(testTagList2);
//        String postDetailsJson2 = javaObjectService.convertJavaObjectToJson(testDetailList2);
//        NicknamePosts nicknamePosts2 = NicknamePosts.builder().postWhere("test postwhere").postTags(postTagsJson2).postDetails(postDetailsJson2).postPublic(defaultPublic).postStatus(defaultStatus).commentCount(defaultCommentCount).build();
//
//        nicknamePostsRepository.save(nicknamePosts2);
//
//        long AfterCountPost = nicknamePostsRepository.count();
//
//        Assertions.assertEquals(AfterCountPost, countPost+1);
//
//        nicknamePostsRepository.deleteById(nicknamePosts1.getPostId());
//        nicknamePostsRepository.deleteById(nicknamePosts2.getPostId());
//
//        long DeleteCountPost = nicknamePostsRepository.count();
//
//        Assertions.assertEquals(0, DeleteCountPost);
//
//    }
//
//    @Test
//    @Transactional
//
//    void createPostTest(){
//
//        boolean defaultPublic = true;
//        boolean defaultStatus = true;
//        Long defaultCommentCount = 0L;
//        List<String> testTagList = List.of("test tag1","test tag2");
//        List<String> testDetailList = List.of("test detail1","test detail2");
//
//        String postTagsJson = javaObjectService.convertJavaObjectToJson(testTagList);
//        String postDetailsJson = javaObjectService.convertJavaObjectToJson(testDetailList);
//        NicknamePosts nicknamePosts = NicknamePosts.builder().postWhere("test postwhere").postTags(postTagsJson).postDetails(postDetailsJson).postPublic(defaultPublic).postStatus(defaultStatus).commentCount(defaultCommentCount).build();
//
//        nicknamePostsRepository.save(nicknamePosts);
//
//        PostsCreateResponseDTO response = new PostsCreateResponseDTO();
//        response.setPostId(nicknamePosts.getPostId());
//        response.setDateCreated(nicknamePosts.getDateCreated());
//
//        nicknamePostsRepository.deleteById(nicknamePosts.getPostId());
//    }
//
//
//}
