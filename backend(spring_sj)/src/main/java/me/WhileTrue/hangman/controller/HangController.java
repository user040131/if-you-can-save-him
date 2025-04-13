package me.WhileTrue.hangman.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.WhileTrue.hangman.domain.Game;
import me.WhileTrue.hangman.dto.AlphabetDTO;
import me.WhileTrue.hangman.dto.AnswerDTO;
import me.WhileTrue.hangman.dto.CheckResultDTO;
import me.WhileTrue.hangman.dto.DifficultyDTO;
import me.WhileTrue.hangman.repository.WordService;
import me.WhileTrue.hangman.service.GameService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "http://localhost:3000",
        allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.OPTIONS}
)
@RequiredArgsConstructor
@RestController//프론트와의 개찰구 역할, 해당 어노테이션이 붙은 클래스의 모든 메서드는 프론트로 연결될 수 있다
public class HangController {

    private final GameService gameService;
    private final WordService wordService;
    private AnswerDTO answerDTO;

    @PostMapping("/game/start")
    public AnswerDTO startGame(@RequestBody @Valid DifficultyDTO difficulty){
        int level = difficulty.getDifficulty(); //DTO로 레벨 처리
        String word = wordService.getRandomWord(level); //받은 레벨로 랜덤 단어 선택
        String topic = wordService.getRandomTopic();
        Game game = new Game();
        gameService.setGame(game); //hangcontroller의 game과 gameservice의 game이 동일하도록 setGame으로 넘겨줌
        return gameService.startGame(topic, word);
    }

    @PostMapping("/game/result")
    public CheckResultDTO inputWord(@RequestBody AlphabetDTO alphabet){
        char alpha = alphabet.getAlphabet();
        return gameService.checkAnswer(alpha);
    }
}
