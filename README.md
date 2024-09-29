# Genio_Quiz

## Ideia
Utilizar uma API gratuita da Open Trivia Database, para gerar perguntas na qual o usuário deve responder e assim formar ponto na qual o mesmo pode está ou não sendo aprovado.

## Technologies
- Spring WebFlux
- Java
- Spring Boot

## Endpoints

* **GET** `http://localhost:8080/trivia/perguntas?amount=1&category=11&difficulty=easy`  
O usuário vai definir três parâmetros(Amount, Category e Difficulty)
Amount: O total de perguntas que vai ser gerado, na documentação da API diz que por chamada consegue gerar no máximo 50 perguntas.
Category: Categorias das perguntas onde voce vai informar o código dos mesmos(General Knowledge: 9
                                                                              Entertainment: Books: 10
                                                                              Entertainment: Film: 11
                                                                              Entertainment: Music: 12
                                                                              Entertainment: Music & Theatres: 13
                                                                              Entertainment: Television: 14
                                                                              Entertainment: Video Games: 15
                                                                              Entertainment: Board Games: 16
                                                                              Science & Nature: 17
                                                                              Science: Computers: 18
                                                                              Science: Mathematics: 19
                                                                              Mythology: 20
                                                                              Sports: 21
                                                                              Geography: 22
                                                                              History: 23
                                                                              Politics: 24
                                                                              Art: 25
                                                                              Celebrities: 26
                                                                              Animals: 27
                                                                              Vehicles: 28
                                                                              Entertainment: Comics: 29
                                                                              Science: Gadgets: 30
                                                                              Entertainment: Japanese Anime & Manga: 31
                                                                              Entertainment: Cartoon & Animations: 32)
Difficulty: O usuário vai definir o nível de dificuldade das perguntas dividas em 3 tipos (Easy, Medium, Hard)  

#### **OK 200**
```json
{
    "response_code": 0,
    "results": [
        {
            "difficulty": "easy",
            "type": "boolean",
            "category": "Entertainment: Film",
            "question": "&quot;Minions&quot; was released on the June 10th, 2015."
        }
    ]
}
```

* **GET** do Sobre `http://localhost:8080/sobre`  
Mostrar os dados do trabalho

### **OK 200**
```json
{
    "projeto": "GenioQuiz",
    "estudante": "João Carlos Rodrigues Martins"
}
```

* **POST** `http://localhost:8080/trivia/respostas`  
O usuário vai está montando o corpo da resposta e ir de acordo com as perguntas geradas no GET anteriormente.

### Requisição raw

```json
{
    "&quot;Minions&quot; was released on the June 10th, 2015.": "False"
} 
```
Passando a pergunta juntamente da resposta.

### **OK 200**
```json
{
    "Pontos:": 1,
    "Resultado": "Aprovado",
    "Total:": 1
}
```

Sendo os pontos que fez, resultado final e o total de perguntas.

## Como rodar

* Clonar o repositório: 
```bash
git clone 
```
