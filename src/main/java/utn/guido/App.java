package utn.guido;
import utn.guido.model.Player;
import utn.guido.Alphabet;
import utn.guido.Game;


public class App 
{
    public static void main( String[] args )
    {

        String palabra = "palabra";
        Game game = new Game();
        Alphabet alphabet = new Alphabet();

        Thread player = new Player("player 1",game,alphabet);
        Thread player2 = new Player("player 2",game,alphabet);
        Thread player3 = new Player("player 3",game,alphabet);

        player.start();
        player2.start();
        player3.start();

    }
}
