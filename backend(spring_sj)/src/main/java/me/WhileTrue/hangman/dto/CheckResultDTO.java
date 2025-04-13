package me.WhileTrue.hangman.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@AllArgsConstructor
public class CheckResultDTO {
    private boolean gameOver;
    private boolean isCorrect;
}
