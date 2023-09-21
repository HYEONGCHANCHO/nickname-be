package com.uniquenick.oldfile;//package com.uniquenick.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Set;
//
//@Entity
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@ToString
//@Table(name = "USERS")
//public class Users {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USERNUM")
//    private Long usernum;
//
//    @Column(name = "MYKEY")
//    private String mykey;
//
//    @Column(name = "OTHERKEY")
//    private String otherkey;
//
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "USERNUM")
//    public Set<UserNickname> nicknames;
//
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "USERNUM")
//    public Collection<UserDemand> userDemands;
//
//    public Users(String mykey, String otherkey) {
//        this.mykey = mykey;
//        this.otherkey = otherkey;
//    }
//}
