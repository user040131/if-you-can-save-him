package me.WhileTrue.hangman.service;

import lombok.Getter;
import lombok.Setter;
import me.WhileTrue.hangman.domain.Game;
import me.WhileTrue.hangman.dto.AnswerDTO;
import me.WhileTrue.hangman.dto.CheckResultDTO;
import me.WhileTrue.hangman.repository.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Service
public class GameService {

    private Game game;//그 game을 저장할 장소

    public void setGame(Game game){
        this.game = game;
    }//hangcontroller에서 넘겨준 game을 받기 위함
    public AnswerDTO startGame(String topic, String answer) {
        game.setAnswer(topic, answer); //게임 시작과 동시에 초기화
        return new AnswerDTO(game.getTopic(), game.getAnswer());
    }
    public CheckResultDTO checkAnswer(char input){
        boolean isCorrect = false;

        for(char c: game.getAnswerCharArray()){
            if(c == input){
                isCorrect = true;
            }
        }

        if(!isCorrect){
            game.setLife(game.getLife() - 1);
        }
        if(game.getLife()==0){
            game.setGameOver(true);
        }
        return new CheckResultDTO(game.isGameOver(), isCorrect);
    }

}
