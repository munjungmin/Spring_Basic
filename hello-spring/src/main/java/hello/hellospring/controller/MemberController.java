package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 필드 주입 - 중간에 바꿀 수 있는 방법이 없어서 안좋음
    // @Autowired private MemberService memberService;

    // setter 주입 - 생성은 생성자로 되고, set 메소드를 나중에 호출해 주입
    // public으로 돼있어서 위험

//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // 생성자 주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
