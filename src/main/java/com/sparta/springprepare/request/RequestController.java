package com.sparta.springprepare.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/hello/request")
public class RequestController {
  @GetMapping("/form/html")
  public String helloForm() {
    return "hello-request-form";
  }


  // [@PathVariable sample]
// [GET] localhost:8080/hello/request/star/Jun/age/27
  @GetMapping("/star/{name}/age/{age}")
  @ResponseBody
  public String helloRequestPath(
          // @PathVariable: 보내려는 하는 데이터를 브라우저의 경로에 넣어준다
          @PathVariable("name")
          String name,
          @PathVariable("age")
          int age
  ) {
    return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
  }


  // [@RequestParam  sample]
// [GET] http://localhost:8080/hello/request/form/param?name=Jun&age=27
  @GetMapping("/form/param")
  @ResponseBody
  public String helloGetRequestParam(
          // @RequestParam: '?'뒤쪽으로 key:value 형식으로 데이터를 받고 '&'를 사용하여 구분
          @RequestParam(value = "name", required = false)
          String name,
          @RequestParam("age")
          int age
  ) {
    return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
  }

// 차이점: [Get] url에 데이터를 담는다 / [Post] payload에 데이터를 담는다

  // [@RequestParam  sample]
// [POST] http://localhost:8080/hello/request/form/param
/* Body에 담기는 데이터
   name=Jun&age=27 */
  @PostMapping("/form/param")
  @ResponseBody
  public String helloPostRequestParam(
          @RequestParam("name")
          String name,
          @RequestParam("age")
          int age
  ) {
    return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
  }

}

