package me.WhileTrue.hangman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Getter
@AllArgsConstructor
public class AnswerDTO {
    private String topic;
    private String answer;
}
