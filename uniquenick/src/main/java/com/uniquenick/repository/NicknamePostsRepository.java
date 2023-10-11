package com.uniquenick.repository;

import com.uniquenick.entity.NicknamePosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NicknamePostsRepository extends JpaRepository<NicknamePosts,Integer> {
    NicknamePosts findByPostId(Integer postId);

//    List<NicknamePosts> findTopNByPostPublicTrueAndPostStatusTrueOrderByDateUpdatedDesc(Integer n);

}
