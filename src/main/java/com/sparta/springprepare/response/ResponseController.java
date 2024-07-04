package com.sparta.springprepare.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/response")
public class ResponseController {

  @GetMapping("/json/string")
  @ResponseBody
  // Content-Type: text/html
  // 클라이언트에 반환 모습: {"name" : "Jun", "age" : "27"}
  public String helloStringJson() {
    return "{\"name\":\"Jun\",\"age\":27}";
  }

  @GetMapping("/json/class")
  @ResponseBody
  // ConTent-Type: application/json
  // 클라이언트에 반환 모습: {"name" : "Jun", "age" : "27"}
  public Star helloClassJson(){
    // 객체를 반환할 경우: Spring내부에서 Json형태로 변환하여 반환한다
    return new Star("Jun", 27);
  }

}
