package com.ooad.mastermind.entities;

import lombok.Getter;

@Getter
public class Board {
    private Attempt[] attempts;
    private CodePeg[] pattern;
    private int currentAttemptNumber;
    private int numberOfAttemptsInEachRound;
    public Board(CodePeg[] pattern, int numberOfAttemptsInEachRound) {
        this.attempts = new Attempt[numberOfAttemptsInEachRound];
        this.numberOfAttemptsInEachRound = numberOfAttemptsInEachRound;
        this.pattern = pattern;
    }


    private void incrementAttempt() {
        if(this.currentAttemptNumber + 1 < attempts.length)
            this.currentAttemptNumber++;
    }

    public void addGuess(CodePeg[] guess) {
        if (this.currentAttemptNumber + 1 < this.numberOfAttemptsInEachRound) {
            this.attempts[currentAttemptNumber] = new Attempt(guess);
            this.incrementAttempt();
        } else
            throw new IllegalArgumentException("Start a new round!");
    }

    public boolean addFeedback(KeyPeg[] feedbacks) {
        if (this.currentAttemptNumber + 1 < this.numberOfAttemptsInEachRound) {
            Attempt lastAttempt = this.attempts[currentAttemptNumber - 1];
            lastAttempt.setFeedback(feedbacks);
            return lastAttempt.wasLastGuessCorrect();
        } else
            throw new IllegalArgumentException("Change users to start next feedback.");
    }

    public boolean isLastTryOfRound() {
        return this.currentAttemptNumber == this.numberOfAttemptsInEachRound;
    }

    public boolean isRoundOver() {
        if(this.currentAttemptNumber > 0) {
            Attempt attempt = this.attempts[this.numberOfAttemptsInEachRound - 1];
            return attempt != null && attempt.getFeedback()[0] != null;
        }
        return false;
    }
}
