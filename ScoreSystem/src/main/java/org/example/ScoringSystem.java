package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoringSystem {

    int score = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @GetMapping("/score")
    public int scorePoint() {
        score++;
        return score;
    }

    @GetMapping("/getScore")
    public int getScore() {
        return score;
    }

    @GetMapping("/resetScore")
    public int resetScore() {
        score = 0;
        return score;
    }
}