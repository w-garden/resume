package com.resume.controller;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class ResumeController {

    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();

    @GetMapping("/resume/html")
    public String getResumeHtml() throws Exception {
        String markdown = Files.readString(Path.of("index.html"));
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }
}
