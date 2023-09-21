package com.uniquenick.oldfile;//package com.uniquenick.repository;
//
//import com.uniquenick.entity.UserNickname;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//public interface UserNicknameRepository extends JpaRepository<UserNickname,Long> {
//
//
//    @Query("select nickname from UserNickname where nicknamestatus = 'Y' and usernum = :usernum")
//    String[] findNicknames(@Param("usernum") Long usernum);
//
//    @Query("select usernum from UserNickname where nicknamestatus = 'Y' and usernum = :usernum and nickname = :nickname")
//    Long findByMyKeyAndNickname(@Param("usernum") Long usernum,@Param("nickname") String nickname);
//
//    @Modifying
//    @Transactional
//    @Query("update UserNickname set nicknamestatus = 'N' where usernum = :usernum and nickname = :nickname and nicknamestatus = 'Y'")
//    void updateNicknameStatusToN(@Param("usernum") Long usernum, @Param("nickname") String nickname);
//
//
//}
