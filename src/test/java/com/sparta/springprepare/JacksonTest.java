package com.sparta.springprepare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springprepare.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {

  @Test
  @DisplayName("Object To JSON : 변환하는 Class(Star)에 @Getter 필요")
  void test1() throws JsonProcessingException {
    Star star = new Star("Jun", 27);
    // Jackson: Java JSON 프로세싱 라이브러리
    // Jackson 라이브러리에서 제공하고 있는 Class: ObjectMapper
    // ObjectMapper: 자바 객체(Object)와 JSON 데이터 간의 변환을 처리
    ObjectMapper objectMapper = new ObjectMapper();
    // 자바 객체(Object) -> Json: 직렬화
    String json = objectMapper.writeValueAsString(star);

    System.out.println("json = " + json);
  }

  @Test
  @DisplayName("JSON To Object : 기본 생성자 & (@Getter OR @Setter) 필요")
  void test2() throws JsonProcessingException {
    String json = "{\"name\":\"Jun\",\"age\":27}"; // JSON 타입의 String

    // Jackson 라이브러리에서 제공하고 있는 Class: ObjectMapper
    ObjectMapper objectMapper = new ObjectMapper();

    // readValue(json Type, 어떤 객체로 매핑할껀지)
    Star star = objectMapper.readValue(json, Star.class);
    // Json -> 자바 객체(Object): 역직렬화
    System.out.println("star.getName() = " + star.getName());
    System.out.println("star.getAge() = " + star.getAge());
  }


}
