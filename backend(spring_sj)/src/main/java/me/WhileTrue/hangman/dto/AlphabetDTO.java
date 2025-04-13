package me.WhileTrue.hangman.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@NoArgsConstructor
public class AlphabetDTO {
    private char alphabet;

    public char getAlphabet() {
        return alphabet;
    }
}
