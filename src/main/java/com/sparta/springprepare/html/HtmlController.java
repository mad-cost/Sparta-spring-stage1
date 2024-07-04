package com.sparta.springprepare.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

  private static long visitCount = 0;

//  @@ static
  @GetMapping("/static-hello")
  public void hello(){
    // static 정적 웹 페이지는 URL에서 바로 찾으면 된다
    // url: http://localhost:8080/hello.html
    // return "hello.html";
  }

  @GetMapping("/html/static-redirect")
  public String htmlStatic(){
    // static에 있는 html을  @GetMapping통해서 찾기: redirect사용
    return "redirect:/hello.html";
  }

// @@ template
  @GetMapping("/html/templates")
  public String htmlTemplates(){
    return "hello";
  }

  // 동적 웹 페이지
  @GetMapping("/html/dynamic")
  public String htmlDynamic(
          Model model
  ){
    // 페이지로 들어오는 방문자 수 카운트
    visitCount ++;
    model.addAttribute("visits",visitCount);
    return "hello-visit";
  }



}
