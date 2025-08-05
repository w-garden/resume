package com.resume.controller;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Controller
public class ResumeController {

    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();

//    @GetMapping("/resume/html")
//    public String getResumeHtml() throws Exception {
//        String markdown = Files.readString(Path.of("login.html"));
//        Node document = parser.parse(markdown);
//        return renderer.render(document);
//    }


    @GetMapping("/resume/html")
    public String getResume(Model model) {
        model.addAttribute("name", "신호철");
        model.addAttribute("title", "Java 백엔드 개발자");
        model.addAttribute("summary", "REST API와 DB설계에 강점이 있는 백엔드 개발자입니다.");
        model.addAttribute("email", "you@example.com");
        model.addAttribute("phone", "010-1234-5678");
        model.addAttribute("github", "https://github.com/w-garden");
        model.addAttribute("skills", List.of("Java", "Spring Boot", "MySQL", "JPA", "Thymeleaf"));

        model.addAttribute("projects", List.of(
                Map.of(
                        "name", "이커머스 플랫폼",
                        "period", "2023.01 ~ 2023.06",
                        "description", "쇼핑몰 백엔드 API 및 관리자 페이지 개발",
                        "tasks", List.of("상품 CRUD API 개발", "결제 연동", "Spring Security 로그인 구현"),
                        "stack", "Spring Boot, MySQL, Redis"
                ),
                Map.of(
                        "name", "포트폴리오 웹사이트",
                        "period", "2024.01 ~ 2024.02",
                        "description", "이력서 기반 포트폴리오 자동 생성기",
                        "tasks", List.of("Markdown to HTML 변환", "GitHub Actions 자동 배포"),
                        "stack", "Spring Boot, Thymeleaf, GitHub Actions"
                )
        ));

        model.addAttribute("education", List.of(
                Map.of("school", "서울대학교", "degree", "컴퓨터공학과", "period", "2017 ~ 2021")
        ));

        model.addAttribute("experiences", List.of(
                Map.of("company", "카카오", "role", "백엔드 개발자", "period", "2022 ~ 현재")
        ));

        model.addAttribute("awards", List.of(
                "정보처리기사 자격증",
                "2023 국민취업지원 우수상 수상"
        ));

        return "resume";
    }

}
