package com.uniquenick.oldfile;//package com.uniquenick.repository;
//
//import com.uniquenick.entity.Users;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Optional;
//
//public interface UsersRepository extends JpaRepository<Users,Long> {
//    @Query("select u from Users u")
//    Optional<Users> usersset();
//
//    @Query("select usernum from Users where otherkey = :otherkey")
//    Long findUsernumByOtherkey(@Param("otherkey") String otherkey);
//
//    @Query("select usernum from Users where mykey = :mykey")
//    Long findUsernumByMykey(@Param("mykey") String mykey);
//
//    @Query("select otherkey from Users where mykey = :mykey")
//    String findOtherkeyByMykey(@Param("mykey") String mykey);
//
//
//
//}
