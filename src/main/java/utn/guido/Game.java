package utn.guido;
import utn.guido.model.Player;
import utn.guido.model.Word;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Date;

import utn.guido.dao.Dao;
import utn.guido.utils.Utils;

public class Game {


    private Word word;
    private String maskedWord;
    private boolean finished;
    private boolean available;
    private static final int MAX_ERRORS = 5;

    public Game (){
        this.init();
    }

    public void init(){
        Word word = Dao.getRandomWord();
        this.setWord(word);
        this.setAvailable(true);
        this.setFinished(false);
        int len = word.getWord().length();
        String wp = IntStream.range(0, len).mapToObj(i -> "*").collect(Collectors.joining());
        setMaskedWord(wp);
    }

    public synchronized void play(Player player, Character letter) throws InterruptedException{

        while (!available && !finished){
            wait();
        }
        available = false;


        if(!finished) {

            System.out.println("-------------------------------");
            System.out.println("\nTurno de " + player.getPlayerName() + " - Errores: " + player.getErrors() + "\n");
            System.out.println("Letra elegida: " + letter);

            int index = word.getWord().indexOf(letter);
            if (index == -1) {
                System.out.println("La letra no se encuentra");
                player.addError();
            } else {
                System.out.println("La letra se encuentra");
                while (index != -1) {
                    String wd = Utils.addChar(this.maskedWord, index, letter);
                    this.setMaskedWord(wd);
                    index = this.word.getWord().indexOf(letter, index + 1);
                }
            }
            System.out.println("\nPalabra: " + this.maskedWord);
            if (!this.maskedWord.contains("*")) {
                System.out.println("Ganador: " + player.getPlayerName());
                finished = true;
                Dao.insertWinner(player, this.word, new Date());
            }else if(player.getErrors() >= MAX_ERRORS ){
                System.out.println("\n"+ player.getPlayerName() + " ha perdido");
                System.out.println("\nLa palabra era: " + this.word.getWord());
            }

            available = true;
            notifyAll();
        }
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getMaskedWord() {
        return maskedWord;
    }

    public void setMaskedWord(String maskedWord) {
        this.maskedWord = maskedWord;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public static int getMaxErrors() {
        return MAX_ERRORS;
    }

}
