package com.uniquenick.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder  //    10.4. 수정사항 - 필요한 코드 추가.
//@Setter //    10.4. 수정사항 - 불필요한 코드 주석처리.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TrendingComments")
public class TrendingComments extends BaseTimeEntity {

    @Id
    @Column(name = "trendingCommentsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trendingCommentsId;

    @Column(name = "trendingComments", columnDefinition = "JSON")
    private String trendingComments;

    // JSON 직렬화 메소드
    public void setTrendingComments(String[] trendingComments) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.trendingComments = objectMapper.writeValueAsString(trendingComments);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // JSON 역직렬화 메소드
    public String[] getTrendingComments() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(trendingComments, String[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }    // JSON 직렬화 메소드



}