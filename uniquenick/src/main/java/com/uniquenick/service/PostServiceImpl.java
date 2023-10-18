package com.uniquenick.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniquenick.dto.*;
import com.uniquenick.entity.NicknameComments;
import com.uniquenick.entity.NicknamePosts;
import com.uniquenick.entity.TrendingComments;
import com.uniquenick.repository.NicknameCommentsRepository;
import com.uniquenick.repository.NicknamePostsRepository;
import com.uniquenick.repository.TrendingCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private final NicknamePostsRepository nicknamePostsRepository;
    @Autowired
    private final TrendingCommentsRepository trendingCommentsRepository;
    @Autowired
    private final NicknameCommentsRepository nicknameCommentsRepository;
    @Autowired
    JavaObjectService javaObjectService;

    public PostServiceImpl(NicknamePostsRepository nicknamePostsRepository, TrendingCommentsRepository trendingCommentsRepository, NicknameCommentsRepository nicknameCommentsRepository) {
        this.nicknamePostsRepository = nicknamePostsRepository;
        this.trendingCommentsRepository = trendingCommentsRepository;
        this.nicknameCommentsRepository = nicknameCommentsRepository;
    }

    @Override
    public Long countPosts() {
        return nicknamePostsRepository.count();
    }

    @Override
    public String[] getTrendingComments() {
        clearAndCreateTrendingComments();

        Optional<TrendingComments> trendingCommentsOptional = trendingCommentsRepository.findById(1); //1번 재밌는 말뭉치
        if (trendingCommentsOptional.isPresent()) {
            TrendingComments trendingComments = trendingCommentsOptional.get();
            String[] trendingCommentsList = trendingComments.getTrendingComments();
            return trendingCommentsList;
        }
        return null;
    }

    @Override
    @Transactional
    public PostsCreateResponseDTO createPost(PostsCreateRequestDTO request) {

        String postTagsJson = javaObjectService.convertJavaObjectToJson(request.getPostTags());
        String postDetailsJson = javaObjectService.convertJavaObjectToJson(request.getPostDetails());
        NicknamePosts nicknamePosts = NicknamePosts.builder().postWhere(request.getPostWhere()).postTags(postTagsJson).postDetails(postDetailsJson).postPublic(request.isPostPublic()).postStatus(request.isPostStatus()).commentCount(0L).build(); //10.14 수정

//        NicknamePosts nicknamePosts = new NicknamePosts(request.getPostWhere(), postTagsJson, postDetailsJson, request.isPostPublic(), request.isPostStatus(),0L); 10.14 수정
        nicknamePostsRepository.save(nicknamePosts);
        PostsCreateResponseDTO response = new PostsCreateResponseDTO();
        response.setPostId(nicknamePosts.getPostId());
        response.setDateCreated(nicknamePosts.getDateCreated());
        return response;
    }

    @Override
    public void clearAndCreateTrendingComments() {
        trendingCommentsRepository.deleteAll();
        String[] testTrendData = {"TrendingComment1", "TrendingComment2", "TrendingComment3"};

        TrendingComments trendingComments = TrendingComments.builder().build(); //재밌는 말뭉치 임의로 생성
        trendingComments.setTrendingComments(testTrendData);


//        TrendingComments trendingComments1 = new TrendingComments();
//        trendingComments1.setTrendingCommentsId(1);
//        trendingComments1.setTrendingComments(new String[]{"test1", "test2", "test3", "test4", "test5"}); //재밌는 말뭉치 임의로 생성
        trendingCommentsRepository.save(trendingComments);
    }

    @Override
    @Transactional
    public CommentCreateResponseDTO createComments(Integer postId, String comment) {
        long firstLikeCount = 0L;//일단 초기 좋아요
        boolean firstCommentStatus = true;
        NicknameComments nicknameComments = NicknameComments.builder().commentContent(comment).commentLikeCount(firstLikeCount).commentStatus(firstCommentStatus).build();
        // 게시물 아이디를 이용하여 게시물 객체를 조회하여 설정
        NicknamePosts post = nicknamePostsRepository.findByPostId(postId);
        if (post != null) {
            NicknameComments.builder().nicknamePosts(post).build();
//            nicknameComments.
//                    setNicknamePosts(post);
        }


//        NicknameComments nicknameComments = new NicknameComments();
//        nicknameComments.setCommentContent(comment);
//        nicknameComments.setCommentLikeCount(0L); //일단 초기 좋아요 0
//        nicknameComments.setCommentStatus(true); //일단 무조건 true로
//        // 게시물 아이디를 이용하여 게시물 객체를 조회하여 설정
//        NicknamePosts post = nicknamePostsRepository.findByPostId(postId);
//        if (post != null) {
//            nicknameComments.setNicknamePosts(post);
//        }

        nicknameCommentsRepository.save(nicknameComments);
        CommentCreateResponseDTO response = new CommentCreateResponseDTO();
        response.setCommentId(nicknameComments.getNicknameCommentsId());
        response.setCommentLikeCount(nicknameComments.getCommentLikeCount());
        response.setDateCommentCreated(nicknameComments.getDateCreated());
        return response;
    }

    @Override
    public Long commentLikeCountUp(Integer postId, Long commentId) {
        Optional<NicknameComments> nicknameComments = nicknameCommentsRepository.findByNicknamePostsPostIdAndNicknameCommentsId(postId, commentId);
        if (nicknameComments.isPresent()) {
            NicknameComments nicknameComment = nicknameComments.get();  //optional값이 존재할 경우 값 호출
            Long ChangedCount = nicknameComment.getCommentLikeCount() + 1;
            NicknameComments updateNicknameComment = NicknameComments.builder().commentLikeCount(ChangedCount).build();

            nicknameCommentsRepository.save(updateNicknameComment);
            return ChangedCount;
        }
        return null;
    }

    @Override
    public Long commentLikeCountDown(Integer postId, Long commentId) {
        Optional<NicknameComments> nicknameComments = nicknameCommentsRepository.findByNicknamePostsPostIdAndNicknameCommentsId(postId, commentId);
        if (nicknameComments.isPresent()) {
            NicknameComments nicknameComment = nicknameComments.get();
            Long presentCount = nicknameComment.getCommentLikeCount();
            if (presentCount > 0) {
                Long ChangedCount = presentCount - 1;
                NicknameComments updateNicknameComment = NicknameComments.builder().commentLikeCount(ChangedCount).build();

                nicknameCommentsRepository.save(updateNicknameComment);
                return ChangedCount;
            }
            return presentCount;
        }
        return null;
    }

    @Override
    public PostsDetailResponseDTO postDetail(Integer postId) {
        NicknamePosts post = nicknamePostsRepository.findByPostId(postId);
        if (post != null) {
            PostsDetailResponseDTO response = new PostsDetailResponseDTO();
            response.setPostId(post.getPostId());
            response.setPostWhere(post.getPostWhere());
            response.setPostTags(javaObjectService.convertJsonToJavaObject(post.getPostTags()));
            response.setPostDetail(javaObjectService.convertJsonToJavaObject(post.getPostDetails()));
            response.setDatePostCreated(post.getDateCreated());
            return response;
        }
        return null;
    }

    @Override
    public PostsDetailBestCommentDTO postDetailBestComment(Integer postId) {
        List<PostsDetailBestCommentDTO> postsDetailBestCommentDTOS = new ArrayList<>();
        List<NicknameComments> nicknameComments = nicknameCommentsRepository.findByNicknamePostsPostId(postId);

        nicknameComments.sort(Comparator.comparing(NicknameComments::getCommentLikeCount).reversed().thenComparing(NicknameComments::getDateCreated).reversed());
        List<NicknameComments> bestComments = nicknameComments.stream().limit(2).collect(Collectors.toList());

        // 선택된 댓글들을 PostsDetailCommentDTO로 변환하여 commentDTOs 리스트에 담습니다.
        PostsDetailBestCommentDTO bestCommentDTO = null;
        for (NicknameComments comment : bestComments) {
            bestCommentDTO = new PostsDetailBestCommentDTO();
            bestCommentDTO.setCommentId(comment.getNicknameCommentsId());
            bestCommentDTO.setCommentContents(comment.getCommentContent());
            bestCommentDTO.setCommentLikeCount(comment.getCommentLikeCount());
            bestCommentDTO.setDateCreated(comment.getDateCreated());
            postsDetailBestCommentDTOS.add(bestCommentDTO);
        }
        return bestCommentDTO;
    }

    @Override
    public PostsDetailCommentDTO postDetailComment(Integer postId) {
        List<PostsDetailCommentDTO> PostsDetailCommentDTOs = new ArrayList<>();
        List<NicknameComments> nicknameComments = nicknameCommentsRepository.findByNicknamePostsPostId(postId);

        // 댓글들을 commentLikeCount가 높은 순서로 정렬합니다.
        nicknameComments.sort(Comparator.comparing(NicknameComments::getCommentLikeCount).reversed());

        // 상위 2개 댓글을 선택합니다.
        List<NicknameComments> bestComments = nicknameComments.stream().limit(2).collect(Collectors.toList());

        // 나머지 댓글들은 상위 2개를 제외한 댓글들입니다.
        List<NicknameComments> otherComments = nicknameComments.stream().skip(2).collect(Collectors.toList());

        // 나머지 댓글들은 dateCommentCreated가 최근 순서로 정렬합니다.
        otherComments.sort(Comparator.comparing(NicknameComments::getDateCreated));

        // 선택된 댓글들을 PostsDetailCommentDTO로 변환하여 commentDTOs 리스트에 담습니다.
        PostsDetailCommentDTO CommentDTO = null;
        for (NicknameComments comment : bestComments) {
            CommentDTO = new PostsDetailCommentDTO();
            CommentDTO.setCommentId(comment.getNicknameCommentsId());
            CommentDTO.setCommentContents(comment.getCommentContent());
            CommentDTO.setCommentLikeCount(comment.getCommentLikeCount());
            CommentDTO.setDateCreated(comment.getDateCreated());
            PostsDetailCommentDTOs.add(CommentDTO);
        }
        return CommentDTO;

    }


    @Override
    public void deleteALl() {
        nicknamePostsRepository.deleteAll();
    }



//    public List<NicknamePostDTO> getLatestPublicPosts(int n) {
//        List<NicknamePosts> posts = nicknamePostsRepository.findTopNByPostPublicTrueAndPostStatusTrueOrderByDateUpdatedDesc(n);
//        return convertToDTOs(posts);
//    }

    // 다른 메서드들...

    private List<NicknamePostDTO> convertToDTOs(List<NicknamePosts> posts) {
        List<NicknamePostDTO> dtos = new ArrayList<>();

        for (NicknamePosts post : posts) {
            NicknamePostDTO dto = new NicknamePostDTO();
            dto.setPostId(post.getPostId());
            dto.setPostWhere(post.getPostWhere());
            dto.setPostTags(post.getPostTags());
            dto.setPostDetails(post.getPostDetails());
            dto.setPostPublic(post.isPostPublic());
            dto.setPostStatus(post.isPostStatus());
            dto.setCommentCount(post.getCommentCount());
            dtos.add(dto);

            PostsDetailBestCommentDTO postsDetailBestCommentDTO = postDetailBestComment(post.getPostId());
            PostsDetailCommentDTO postsDetailCommentDTO =postDetailComment(post.getPostId());
        }
        return dtos;
    }
}



