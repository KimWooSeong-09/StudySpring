package com.spring.e0723.controller;


import com.spring.e0723.dto.MemberForm;
import com.spring.e0723.entity.Member;
import com.spring.e0723.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MemberController {

    private final MemberRepository memberRepository;
    MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/signup")
    public String input(Model model) {
        // 작성 코드
        return "signup";
    }

    @PostMapping("/mainpage")
    public String createMember(MemberForm form) {
        log.info("사용자 정보 출력" + form);
        //1. 사용자 정보가 저장된 DTO를 ENTITY로 변경.
        Member entity = form.toEntity();
        System.out.println(entity);
        log.info("entity" + entity);

        //2. DB에 추가하기
        Member save = memberRepository.save(entity);
        System.out.println(entity);
        return "";
    }

    /** localhost:8080//3 show
     insert into article values(1, '112', '가나다라')
     insert into article values(2, '113', '가나다라')
     insert into article values(3, '114', '가나다라')
     /** localhost:8080/show/3*/
    @GetMapping("/show/{id}")
    public String show(
            @PathVariable Long id
    ) {
        log.info("show() / id : " + id);

        Member article = memberRepository.findById(id).orElse(null);
        log.info("show() / article : " + article);
        return "/show";
    }
}
