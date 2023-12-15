package com.ooad.mastermind.entities;

import java.util.Map;

public class Round {
    private Board board;
    private String codeBreaker;
    private String codeMaker;
    private int roundNumber;
    private int codeMakerPoints;

    public Round(String codeBreaker, String codeMaker, int roundNumber,
                 int numberOfAttemptsInEachRound, CodePeg[] pattern) {
        this.codeBreaker = codeBreaker;
        this.codeMaker = codeMaker;
        this.roundNumber = roundNumber;
        this.board = new Board(pattern, numberOfAttemptsInEachRound);
    }

    public boolean isRoundOver() {
        return this.board.isRoundOver();
    }

    public String getCodeBreaker() {
        return codeBreaker;
    }

    public String getCodeMaker() {
        return codeMaker;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getCodeMakerPoints() {
        return codeMakerPoints;
    }

    public void addGuess(CodePeg[] guess) {
        this.board.addGuess(guess);
    }

    public boolean addFeedback(KeyPeg[] feedbacks) {
        boolean wasLastGuessCorrect = this.board.addFeedback(feedbacks);
        if (!wasLastGuessCorrect) {
            //get code maker points
            if (isLastTryOfRound())
                this.codeMakerPoints += 2;
            else
                this.codeMakerPoints += 1;
        }
        return wasLastGuessCorrect;
    }


    private boolean isLastTryOfRound() {
        return this.board.isLastTryOfRound();
    }
    
    @Override
    public String toString() {
        return "Round{" +
                " codeBreaker='" + codeBreaker + '\'' +
                ", codeMaker='" + codeMaker + '\'' +
                ", roundNumber=" + roundNumber +
                '}';
    }
}
