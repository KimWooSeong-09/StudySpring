package com.spring.e0723.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller_01 {

    @GetMapping("/exam01")
    public String method_01(Model model) {
        model.addAttribute("textArr", "문장형");
        return "ee01"; // templates 패키지 안에 있는 파일(확장자 무시)을 화면에 보이게 함
    }

    @GetMapping("/exam02")
    public String method_02(Model model,
                            @RequestParam String num01,
                            @RequestParam String num02) {
        int sum = Integer.parseInt(num01) + Integer.parseInt(num02);
        model.addAttribute("numValue", ""+sum);
        return "ee02";
    }

}
