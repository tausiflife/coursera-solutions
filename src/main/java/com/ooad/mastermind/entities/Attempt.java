package com.ooad.mastermind.entities;

import java.util.Arrays;

public class Attempt {
    private CodePeg[] guess;
    private KeyPeg[] feedback;

    public Attempt(CodePeg[] guess) {
        this.guess = guess;
        this.feedback = new KeyPeg[4];
    }

    public CodePeg[] getGuess() {
        return guess;
    }

    public KeyPeg[] getFeedback() {
        return feedback;
    }

    public void setFeedback(KeyPeg[] feedback) {
        this.feedback = feedback;
    }

    public boolean wasLastGuessCorrect() {
        return Arrays.stream(this.feedback).allMatch(keypeg-> keypeg.getColor().equals(KeyPegColor.RED));
    }
}
