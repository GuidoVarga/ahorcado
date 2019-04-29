package utn.guido.model;

import utn.guido.Alphabet;
import utn.guido.Game;

public class Player extends Thread{

    private String playerName;
    private int errors;
    private Game game;
    private Alphabet alphabet;

    public Player(){

    }

    public Player (String name,Game game, Alphabet alphabet){
        this.playerName = name;
        this.errors = 0;
        this.game = game;
        this.alphabet = alphabet;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public void addError(){
        this.errors+=1;
    }

    @Override
    public void run() {

        try {
            while (errors < this.game.getMaxErrors() && alphabet.getAvailableLetters() > 0 && !game.isFinished()){
                game.play(this,alphabet.getLetter());
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
