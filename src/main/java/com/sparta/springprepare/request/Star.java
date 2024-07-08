package com.sparta.springprepare.request;

import lombok.Setter;

@Setter
public class Star {
  String name;
  int age;

  public Star(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Star(){}
}