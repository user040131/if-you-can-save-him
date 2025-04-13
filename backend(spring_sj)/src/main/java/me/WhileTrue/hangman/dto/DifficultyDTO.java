package me.WhileTrue.hangman.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@NoArgsConstructor
public class DifficultyDTO {

    @Min(value = 0, message = "난이도는 0 이상, 2이하이어야 합니다.")
    @Max(value = 2, message = "난이도는 0 이상, 2이하이어야 합니다.")
    private int difficulty;

    public int getDifficulty() {
        return difficulty;
    }
}