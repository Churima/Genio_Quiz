package com.genioquiz.quiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TriviaService {
    private final RestTemplate restTemplate;
    private List<Map<String, Object>> perguntaAtual;

    public TriviaService() {
        this.restTemplate = new RestTemplate();
        this.perguntaAtual = new ArrayList<>();
    }

    // Obtem as perguntas
    public Map<String, Object> getPergunta(int amount, String category, String difficulty) {
        String url = "https://opentdb.com/api.php?amount=" + amount + "&category=" + category + "&difficulty=" + difficulty + "&type=boolean";

        // Requisição do Trivia
        Map<String, Object> resposta = restTemplate.getForObject(url, Map.class);

        // Atualiza as perguntas
        perguntaAtual = (List<Map<String, Object>>) resposta.get("results");

        //Salva e remove para o usuario não saber as respostas
        List<Map<String, Object>> listaDePerguntas = new ArrayList<>();
        for (Map<String, Object> atualPergunta  : perguntaAtual) {
            Map<String, Object> copiaPergunta = new HashMap<>(atualPergunta);
            copiaPergunta.remove("correct_answer");
            copiaPergunta.remove("incorrect_answers");
            listaDePerguntas.add(copiaPergunta);
        }

        // Faz o formato com um novo map a partir da lista para assim conseguir mais para baixo calcular os pontos
        Map<String, Object> formatacaoResposta = new HashMap<>();
        formatacaoResposta.put("response_code", resposta.get("response_code"));
        formatacaoResposta.put("results", listaDePerguntas);

        return formatacaoResposta;
    }

    // Vai verificar as respostas e validar quantas o usuário acertou
    public Map<String, Object> validaResposta(Map<String, String> vResposta) {
        int pontos = 0;

        for (Map<String, Object> resultado : perguntaAtual) {
            String questao = (String) resultado.get("question");
            String respostaCorreta = (String) resultado.get("correct_answer");
            String repostaDoUsuario = vResposta.get(questao);

            if (repostaDoUsuario != null && repostaDoUsuario.equals(respostaCorreta)) {
                pontos++;
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("Pontos:", pontos);
        result.put("Total:", perguntaAtual.size());
        if (pontos < Math.ceil(perguntaAtual.size() / 2.0)) {
            result.put("Resultado:", "Reprovado");
        }else{result.put("Resultado", "Aprovado");}
        return result;
    }
}
