package com.uniquenick.repository;

import com.uniquenick.entity.NicknameComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NicknameCommentsRepository extends JpaRepository<NicknameComments,Long> {
    Optional<NicknameComments> findByNicknamePostsPostIdAndNicknameCommentsId(Integer postId, Long nicknameCommentId);
    List<NicknameComments> findByNicknamePostsPostId(Integer postId);

}
