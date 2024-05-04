package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // controller가 정적 파일보다 우선순위가 높음
    @GetMapping("/")
    public String home() {
        return "home";

    }
}
