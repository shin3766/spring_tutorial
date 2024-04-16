package com.example.spring_tutorial.domain;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
    정적 웹사이트 :: html 문서로 연결
     */
    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    }

    /*
    정적 웹사이트 :: html 문서로 리다이렉트
     */
    @GetMapping("/html/redirect")
    public String htmlStatic() {
        return "redirect:/hello.html";
    }

    /*
    정적 웹사이트 :: html 문서로 연결
     */
    @GetMapping("html/templates")
    public String htmlTemplates() {
        return "hello";
    }

    /*
    동적 웹사이트 ::
     */
    private static long visitCount = 0;
    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";
    }

    @GetMapping("/response/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    @GetMapping("/response/json/class")
    @ResponseBody
    public Star helloClassJson() {
        return new Star("ys", 10);
    }
}
