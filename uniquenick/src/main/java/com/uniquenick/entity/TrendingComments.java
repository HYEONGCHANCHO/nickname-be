package com.uniquenick.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrendingComments")
public class TrendingComments extends BaseTimeEntity {

    @Id
    @Column(name = "trendingCommentsId")
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