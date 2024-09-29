package com.genioquiz.quiz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class SobreController {
    @RequestMapping("/sobre")
    public Map<String, String> sobre() {
        return Map.of(
                "estudante", "João Carlos Rodrigues Martins",
                "projeto", "GenioQuiz"
        );
    }
}
