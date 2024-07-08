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

  // [@RequestParam sample]
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

// 차이점: [위에] payload에 "param"으로 데이터를 담는다 / [아래] payload에 "model"로 데이터를 담는다

  // [@ModelAttribute sample] / @ModelAttribute사용할 경우 객체로 매핑해서 처리 가능
  // @NoArgsConstructor & @AllArgsConstructor 필요
  // @Setter를 사용하지 않으면 view의 body에는 (naem = null, age = 0)로 나온다
// [POST] http://localhost:8080/hello/request/form/model
/* Body
   name=Jun&age=27 */

  @PostMapping("/form/model")
  @ResponseBody
  public String helloRequestBodyForm(
          @ModelAttribute
          Star star
  ) {
    return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
  }

  // [@ModelAttribute sample]
// [GET] http://localhost:8080/hello/request/form/param/model?name=Jun&age=27
  // @Setter를 사용하지 않으면 url에는 값이 들어오지만 view의 body에는 (naem = null, age = 0)로 나온다
  @GetMapping("/form/param/model")
  @ResponseBody
  public String helloRequestParam(
          // @ModelAttribute는 생략 가능
          Star star
  ) {
    return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
  }


  // [@RequestBody sample]
// [POST] http://localhost:8080/hello/request/form/json
/* Body에 Json형식으로 요청이 들어오는 경우
  {"name":"Robbie","age":"95"} */
  @PostMapping("/form/json")
  @ResponseBody
  public String helloPostRequestJson(
          // @RequestBody: HTTP 요청의 본문을 자바 객체로 변환하는 데 사용되는 어노테이션
          // 즉, Json 데이터를 -> 자바 객체로 (역직렬화를 해주는데 사용)
          @RequestBody
          Star star
  ) {
    return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
  }


}

