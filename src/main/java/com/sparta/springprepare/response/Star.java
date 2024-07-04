package com.sparta.springprepare.response;

import lombok.Getter;

@Getter
public class Star {
  private String name;
  private int age;

  // @AllArgsConstructor
  public Star(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // @NoArgsConstructor
  public Star() {}
}