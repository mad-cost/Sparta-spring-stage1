package com.sparta.springprepare.lombok;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @RequiredArgsConstructor
public class Memo {
  private String username;
  private String contents;

  /* @RequiredArgsConstructor: final이 있는 필드를 가지는 생성자를 만들어준다
  private final String phone; */


  /* @AllArgsConstructor: 매개변수(필드)를 모두 가는 생성자
  public Memo(String username, String contents) {
    this.username = username;
    this.contents = contents;
  } */

  /* @NoArgsConstructor: 기본 생성자
  JPA와 같은 일부 라이브러리 및 프레임 워크는 기본 생성자를 필요로 하는데,
  매개변수(필드)가 있는 다른 생성자를 선언하면 기본 생성자가 자동으로 생성되지 않는다.
  public Memo() { } */


  /* @Getter
  public String getUsername() {
    return this.username;
  } */

  /* @Setter
  public void setUsername(String username) {
    this.username = username;
  } */

}

class Main {
  public static void main(String[] args) {
    Memo memo = new Memo();
    memo.setUsername("Jun");
    System.out.println(memo.getUsername());
  }
}
