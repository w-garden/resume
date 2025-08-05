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



    @GetMapping("/resume/html")
    public String getResume(Model model) {

        model.addAttribute("name", "신호철");
        model.addAttribute("title", "Java 백엔드 개발자");
        model.addAttribute("email", "w.garden316@gmail.com");
        model.addAttribute("github", "https://github.com/w-garden");
        model.addAttribute("notion", "https://www.notion.so/DevNote-7864e5a4c87642dca6926b12a5f99e8f?pvs=21");
        model.addAttribute("summary", "현재 3년차 백엔드 개발자로 PG사에서 결제 및 카드사 매입 시스템의 API와 배치 개발, 장애 대응, 성능 개선을 중심으로 실무를 다루고 있습니다. 주로 Java, Spring Framework, Oracle 등의 기술을 사용하였으며 객체지향 설계 및 데이터 처리 최적화에 관심을 갖고 공부하고 있습니다.");

        model.addAttribute("skills", Map.of(
                "Back-End", List.of("Java", "Spring Framework", "Spring MVC", "Spring Boot", "JPA", "MyBatis", "Maven", "Gradle"),
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
                        "description", List.of("### 대규모 백엔드 시스템 개발 및 운영"

                                        ,"- 일 거래 150만건 / 1,000억 규모**의 신용카드 결제 및 매입 시스템의 백엔드 개발 및 유지보수"
                                        ,"- Java 기반의 Batch Scheduler 및 **REST API**를 통한 가맹점 ↔ PG ↔ VAN ↔ 카드사 간 거래 흐름 관리"
                                        ,"- Spring Framework 기반의 API 서버 및 배치 시스템 설계 및 운영"
                                        ,"- Oracle PL/SQL 및 MyBatis 기반 대용량 데이터 처리, 복잡한 로직의 분석 및 구현"
                                        ,""
                                        , "### 문제 상황에 대한 개선 및 해결"

                                        ,"- 80만 건 이상 카드사 결과 파일 생성 시 발생한 OutOfMemoryError를 MyBatis `ResultHandler` 적용으로 해결"
                                        ,"- 슬로우 쿼리로 인한 약 20만 건 배치 처리 소요 시간을 8시간 → 20분 이내로 개선 (SQL 튜닝, 병렬 처리 적용)"
                                        ,"- 타임아웃 이슈, PK 충돌, 트랜잭션 분리로 인한 정합성 오류 등 주요 장애에 대한 원인 분석 및 개선 경험"
                                        ,"- 애플리케이션 에러 분석 및 기능 개선 요청 대응(한달 평균 15개)을 통한 운영 안정성 확보"
                                        ,""
                                        , "### 인프라 및 시스템 환경 이해"
                                        ,"- 이중화된 IDC 센터 기반의 AP 서버 및 DB 서버 구조 이해 및 운영 경험"
                                        ,"- Crontab 및 Shell Script를 활용한 SFTP 파일 송수신 자동화"
                                        ,"- Apache Tomcat, Tmax Jeus 환경의 서버 모니터링 및 설정 변경을 통한 장애 대응"
                                        ,"- L4 로드 밸런서 기반 트래픽 분산 구조 이해 및 적용"
                                        ,""
                                        , "### 주도적인 업무 수행 및 협업 역량"
                                        ,"- 2023년 6월부터 신용카드 매입 담당자의 공백을 단독으로 인수/운영, 업무 공백 없이 안정적으로 처리"
                                        ,"- Eclipse에서 IntelliJ로의 프로젝트 전체 소스 이관 주도"
                                        ,"- Slack, Mattermost 를 활용한 개발 협업 및 이슈 관리 경험"

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
