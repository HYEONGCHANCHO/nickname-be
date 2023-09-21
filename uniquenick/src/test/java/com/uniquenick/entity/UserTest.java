//package com.uniquenick.entity;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//@SpringBootTest
//
//public class UserTest {
//    @Autowired
//    private UserTB userTB;
//
//    @Test
//    void testUserTest() {
//        String[] userid = {"aa", "bb", "cc", "dd"};
//
//        for (int i = 0; i < userid.length; i++) {
//            UserTB userTB = UserTB.builder()
//                    .userid(userid[i])
//                    .build();
//
//            // 저장
//            UserTB.save(userTB);
//
//        }
//
//    }
//
//}
