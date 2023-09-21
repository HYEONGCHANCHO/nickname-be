package com.uniquenick.oldfile;//package com.uniquenick.controller;
//
//import com.uniquenick.dto.UserDemandDto;
//import com.uniquenick.dto.UserResultDto;
//import com.uniquenick.dto.UsersDto;
//import com.uniquenick.entity.UserDemand;
//import com.uniquenick.entity.UserNickname;
//import com.uniquenick.entity.Users;
//import com.uniquenick.repository.UserDemandRepository;
//import com.uniquenick.repository.UserNicknameRepository;
//import com.uniquenick.repository.UsersRepository;
//import lombok.Builder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//@RestController
//public class UsersController {
//
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private UserDemandRepository userDemandRepository;
//  @Autowired
//    private UserNicknameRepository userNicknameRepository;
//
//
//    @GetMapping("/usercount")
//    public ResponseEntity<Map<String, Long>> getUserCount() {
//        long userCount = usersRepository.count();
//        Map<String, Long> response = new HashMap<>();
//        response.put("userCount", userCount);
//        return ResponseEntity.ok(response);
//    }
//    @PostMapping("/nickname-request")
//    public ResponseEntity<Map<String, String>> handleusersRequest(@RequestBody UserDemandDto userDemandDto) {
//
//        String myKey = UUID.randomUUID().toString();
//        String otherKey = UUID.randomUUID().toString();
//        Users user = Users.builder()
//                .mykey(myKey)
//                        .otherkey(otherKey)
//                                .build();
//        usersRepository.save(user);
//        Map<String, String> response = new HashMap<>();
//        response.put("mykey", myKey); // 내 식별자 값
//
//        UserDemand userDemand = new UserDemand();
//        userDemand.setTags(userDemandDto.getTags());
//        userDemand.setCategory(userDemandDto.getCategory());
//        userDemand.setTitle(userDemandDto.getTitle());
//        userDemand.setUsernum(user.getUsernum());
//        userDemandRepository.save(userDemand);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/key")
//    public ResponseEntity<Map<String, String>> getOtherKey(@RequestParam("mykey") String mykey) {
//        String otherkey = usersRepository.findOtherkeyByMykey(mykey);
//        if (otherkey == null) {
//            throw new EntityNotFoundException("Other key not found for myKey: " + mykey);
//        }
//
//        Map<String, String> response = new HashMap<>();
//        response.put("otherkey", otherkey);
//
//        return ResponseEntity.ok(response);
//    }
//
//
//    @PostMapping("/nickname/{otherkey}/nickname-request")
//    public ResponseEntity<String> handleNicknameRequest(
//            @PathVariable("otherkey") String otherKey,
//            @RequestBody Map<String, String> nicknameData
//    ) {
//        String nickname = nicknameData.get("nickname");
//
//        Long usernum = usersRepository.findUsernumByOtherkey(otherKey);
//        System.out.println("usernum: " + usernum); // Add this line to print the value of usernum
//        System.out.println("otherKey: " + otherKey); // Add this line to print the value of usernum
//
//        if (usernum == null) {
//            throw new EntityNotFoundException("User not found with otherKey: " + otherKey);
//        }
//        UserNickname userNickname = new UserNickname();
//        userNickname.setNickname(nickname);
//        userNickname.setUsernum(usernum);
//        userNickname.setNicknamestatus("Y");
//        userNicknameRepository.save(userNickname);
//
//        return ResponseEntity.ok("Nickname request submitted successfully.");
//    }
//
//    @GetMapping("/nickname/{mykey}/nickname-received")
//    public ResponseEntity<UserResultDto> getNicknameReceived(@PathVariable("mykey") String mykey) {
//        Long usernum = usersRepository.findUsernumByMykey(mykey);
//        if (usernum == null) {
//            throw new EntityNotFoundException("User not found with myKey: " + mykey);
//        }
//
//        UserDemand userDemand = userDemandRepository.findByUsernum(usernum);
//        if (userDemand == null) {
//            throw new EntityNotFoundException("User demand not found with myKey: " + mykey);
//        }
//
//        System.out.println("usernum: " + usernum); // Add this line to print the value of usernum
//        System.out.println("mykey: " + mykey); // Add this line to print the value of usernum
//
//        UserResultDto userResultDto = new UserResultDto();
//        userResultDto.setTitle(userDemand.getTitle());
//        userResultDto.setTags(userDemand.getTags());
//        userResultDto.setCategory(userDemand.getCategory());
//        userResultDto.setNicknames(userNicknameRepository.findNicknames(usernum));
//
//        return ResponseEntity.ok(userResultDto);
//    }
//
//    @GetMapping("/nickname/{otherkey}/nickname-userdemand")
//    public ResponseEntity<UserDemandDto> getdemandReceived(@PathVariable("otherkey") String otherkey) {
//        Long usernum = usersRepository.findUsernumByOtherkey(otherkey);
//        if (usernum == null) {
//            throw new EntityNotFoundException("User not found with otherkey: " + otherkey);
//        }
//
//        UserDemand userDemand = userDemandRepository.findByUsernum(usernum);
//        if (userDemand == null) {
//            throw new EntityNotFoundException("User demand not found with otherkey: " + otherkey);
//        }
//
//        System.out.println("usernum: " + usernum); // Add this line to print the value of usernum
//        System.out.println("otherkey: " + otherkey); // Add this line to print the value of usernum
//
//        UserDemandDto userDemandDto = new UserDemandDto();
//        userDemandDto.setTitle(userDemand.getTitle());
//        userDemandDto.setTags(userDemand.getTags());
//        userDemandDto.setCategory(userDemand.getCategory());
//
//        return ResponseEntity.ok(userDemandDto);
//    }
//
//    @DeleteMapping("/nickname/{mykey}/nickname-received")
//    public ResponseEntity<String> deleteNicknameReceived(
//            @PathVariable("mykey") String mykey,
//            @RequestParam("nickname") String nickname
//    ) {
//        Long usernum = usersRepository.findUsernumByMykey(mykey);
//
//        Long usernickname = userNicknameRepository.findByMyKeyAndNickname(usernum, nickname);
//
//        if (usernickname == null) {
//            throw new EntityNotFoundException("User nickname not found for myKey: " + mykey + " and nickname: " + nickname);
//        }
//        UserNickname userNickname = new UserNickname();
//
//        userNicknameRepository.updateNicknameStatusToN(usernum,nickname);
////        userNicknameRepository.save(userNickname);
//
//        return ResponseEntity.ok("Deletion completed.");
//    }
//
//}
