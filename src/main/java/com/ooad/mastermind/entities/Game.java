package com.ooad.mastermind.entities;

import lombok.Getter;

import java.util.*;

@Getter
public class Game {
    private Player player1;
    private Player player2;
    private Set<String> allowedColors;
    private String id;
    private int currentRoundNumber;
    private int numberOfRounds;
    private Round[] rounds;
    private Map<String, Integer> playerPoints;
    private String currentCodeMakerId;
    private int numberOfAttemptsInEachRound;

    public Game(String codeMakerName, String codeBreakerName, int numberOfRounds,
                int numberOfAttemptsInEachRound, Set<String> colors) {
        this.player1 = new Player(codeMakerName);
        this.player2 = new Player(codeBreakerName);
        this.allowedColors = new HashSet<>(colors);
        this.id = UUID.randomUUID().toString();
        this.numberOfRounds = numberOfRounds;
        this.rounds = new Round[numberOfRounds];
        this.playerPoints = new HashMap<>();
        this.numberOfAttemptsInEachRound =numberOfAttemptsInEachRound;
    }

    public void startRound(List<String> pattern) {
        if(!allowedColors.containsAll(pattern))
            throw new IllegalArgumentException("Not allowed color pattern.");
        if(pattern.size() > 4)
            throw new IllegalArgumentException("Allowed size of patter is 4.");
        Round currentRound = this.currentRoundNumber == 0 ? this.rounds[this.currentRoundNumber] :
                this.rounds[this.currentRoundNumber - 1];
        if(currentRound == null || currentRound.isRoundOver()) {
            CodePeg[] codeMakerPattern = new CodePeg[4];
            for (int i =0; i<pattern.size(); i++){
                codeMakerPattern[i] = new CodePeg(pattern.get(i));
            }
            this.currentCodeMakerId = getNextCodeMaker();
            this.rounds[this.currentRoundNumber] = new Round(currentCodeMakerId, getNextCodeBreaker(), currentRoundNumber,
                    numberOfAttemptsInEachRound, codeMakerPattern);
            this.currentRoundNumber++;
        } else
            throw new IllegalArgumentException("Running round : "+ this.currentRoundNumber);
    }

    private String getNextCodeMaker() {
        return this.currentCodeMakerId == null || this.currentCodeMakerId.equals(this.player2.getId()) ?
                this.player1.getId() : this.player2.getId();
    }

    private String getNextCodeBreaker() {
        return getNextCodeMaker().equals(this.player1.getId()) ? this.player2.getId() : this.player1.getId();
    }

    public void addGuess(List<String> pattern) {
        if(this.currentRoundNumber > 0) {
            CodePeg[] guess = new CodePeg[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = new CodePeg(pattern.get(i));
            }
            this.rounds[this.currentRoundNumber - 1].addGuess(guess);
        }
    }

    public String getId() {
        return this.id;
    }

    public void addFeedback(List<KeyPegColor> feedbacks) {
        if(this.currentRoundNumber > 0) {
            KeyPeg[] feedback = new KeyPeg[4];
            for (int i = 0; i < 4; i++) {
                feedback[i] = new KeyPeg(feedbacks.get(i));
            }
            this.rounds[this.currentRoundNumber - 1].addFeedback(feedback);
        }
    }

    public Player winner() {
        if(this.currentRoundNumber == this.numberOfRounds && this.rounds[this.currentRoundNumber - 1].isRoundOver()) {
            Integer player1Points = playerPoints.get(this.player1.getId());
            Integer player2Points = playerPoints.get(this.player2.getId());
            return player1Points > player2Points ? this.player1 : this.player2;
        } else {
            throw new IllegalArgumentException("There are pending rounds!");
        }
    }

    public void getOverview() {
        System.out.println("Running round : "+ this.currentRoundNumber);
        System.out.println("Code maker is : " + this.currentCodeMakerId);
        System.out.println("Player 1 points : "+ playerPoints.get(this.player1.getId()));
        System.out.println("Player 2 points : "+ playerPoints.get(this.player2.getId()));
    }

}
