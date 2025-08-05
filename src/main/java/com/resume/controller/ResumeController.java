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
        model.addAttribute("email", "w.garden316@gmail.com");
        model.addAttribute("github", "https://github.com/w-garden");
        model.addAttribute("notion", "https://www.notion.so/DevNote-7864e5a4c87642dca6926b12a5f99e8f?pvs=21");
        model.addAttribute("summary", "현재 3년차 백엔드 개발자로 PG사에서 실무 경험을 쌓고 있으며...");

        model.addAttribute("skills", Map.of(
                "Back-End", List.of("Java", "Spring Framework", "JPA", "MyBatis", "Maven", "Gradle"),
                "Front-End", List.of("JavaScript(ES6)", "HTML5", "CSS3", "Nexacro"),
                "Database", List.of("Oracle", "MySQL"),
                "DevOps", List.of("Linux", "Tomcat", "Jeus", "Wildfly"),
                "Tools", List.of("Git", "SVN", "IntelliJ", "Eclipse", "Slack", "Mattermost", "Notion")
        ));

        model.addAttribute("experiences", List.of(
                Map.of(
                        "company", "KG이니시스",
                        "role", "Java & Spring 백엔드 개발자",
                        "period", "2023.01 ~ 현재",
                        "description", List.of(
                                "대규모 트래픽 환경에서의 API / Batch 개발",
                                "사내 백오피스, 가맹점 관리자 페이지 개발 및 운영",
                                "IDC 인프라 기반 시스템 운영 경험 등"
                        )
                )
        ));

        model.addAttribute("projects", List.of(
                Map.of(
                        "title", "배달의민족 차액정산 백엔드 시스템 고도화",
                        "period", "2024.12 ~ 2025.05",
                        "stack", "Java, Spring, MyBatis, Oracle, Linux, REST API",
                        "details", List.of(
                                "SFTP 자동화 배치 모듈 개발",
                                "OutOfMemoryError 해결 – MyBatis ResultHandler 적용",
                                "Slack 기반 협업 및 모니터링"
                        )
                ),
                Map.of(
                        "title", "신용카드 365 매입 프로세스 구축",
                        "period", "2024.04 ~ 2024.08",
                        "stack", "Java, Spring, MyBatis, Oracle",
                        "details", List.of(
                                "매입 검증 로직 분석 및 Java 이관",
                                "복잡한 PL/SQL → Java 코드로 재설계"
                        )
                )
                // ...다른 프로젝트 추가 가능
        ));

        model.addAttribute("education", List.of(
                Map.of("school", "KGITBANK 부트캠프", "period", "2022.06 ~ 2022.11"),
                Map.of("school", "KGITBANK 단과 수업", "period", "2022.01 ~ 2022.04")
        ));

        model.addAttribute("certificates", List.of(
                "정보처리기사 (2022.09.02 취득)"
        ));

        return "resume";
    }




}
