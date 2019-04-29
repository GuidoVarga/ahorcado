package utn.guido;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Alphabet {

    private List<Character> alphabet;
    private boolean available;

    public Alphabet (){
        this.alphabet = new ArrayList<>();
        this.init();
    }

    public void init (){
        this.setAvailable(true);

        for(char c = 'a'; c <= 'z'; c++){
            this.alphabet.add(c);
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public synchronized Character getLetter() throws InterruptedException{
        while (!available){
            wait();
        }

        available = false;

        int size = this.getAvailableLetters();
        Character letter;
        if(size>1) {
             Random rand = new Random(System.currentTimeMillis());
             letter = alphabet.remove(rand.nextInt(size - 1) + 0);
        }
        else {
            letter = alphabet.remove(0);
        }
        available = true;
        notifyAll();

        return letter;
    }

    public int getAvailableLetters(){
        return this.alphabet.size();
    }
}
