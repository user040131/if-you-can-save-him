package me.WhileTrue.hangman.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Game {
    List<Character> rightAlphabet = new ArrayList<>();
    List<Character> wrongAlphabet = new ArrayList<>();
    String answer;
    String topic;
    char[] answerCharArray;

    boolean gameOver = false;
    int life = 5; //목숨이 몇 개였더라

    public void setAnswer(String topic, String answer){
        this.topic = topic;
        this.answer = answer;
        this.answerCharArray = answer.toCharArray();
        this.life = 5;
        this.gameOver = false;
    }

    public String getAnswer(){
        return answer;
    }
    public String getTopic(){
        return topic;
    }
}
