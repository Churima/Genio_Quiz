package com.genioquiz.quiz.controller;

import com.genioquiz.quiz.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/trivia")
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    //GET com as perguntas
    @GetMapping("/perguntas")
    public Map<String, Object> getPergunta(@RequestParam int amount, @RequestParam String category, @RequestParam String difficulty) {
        return triviaService.getPergunta(amount, category, difficulty);
    }

    //POST para responder as perguntas do GET
    @PostMapping("/respostas")
    public Map<String, Object> postAnswers(@RequestBody Map<String, String> respostasquiz) {
        return triviaService.validaResposta(respostasquiz);
    }
}
