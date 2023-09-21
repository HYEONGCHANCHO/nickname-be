package com.uniquenick.oldfile;//package com.uniquenick.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//@Table(name = "USERNICKNAME")
//public class UserNickname {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "num")
//    private Long num;
//
//    @Column(name = "NICKNAME")
//    private String nickname;
//
//    @Column(name = "NICKNAMESTATUS")
//    private String nicknamestatus;
//
//    @Column(name = "USERNUM")
//    private Long usernum;
//
//    public UserNickname(String nickname, Long usernum, String nicknamestatus) {
//        this.nickname = nickname;
//        this.usernum = usernum;
//        this.nicknamestatus = nicknamestatus;
//    }
//
//}