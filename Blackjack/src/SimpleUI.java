/**
 *
 * @author r37shah
 */

import java.util.Scanner;

public class SimpleUI implements UserInterface
{
    private BlackjackGame game;
    private final Scanner user = new Scanner(System.in);

    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    public void display()
    {
        System.out.println("House Cards: " + game.getHouseCards()+ '\n'+ "Your cards: " + game.getYourCards());        
    }

    public boolean hitMe() {
        
           String hit = new String();

    boolean inputIsInvalid = true;
    while (inputIsInvalid) {
      System.out.print("Please enter either n or y: ");

        hit = user.next();
    
      if ("y".equalsIgnoreCase(hit) || "n".equalsIgnoreCase(hit)) {
          inputIsInvalid = false;
      }
    }
        return (hit.toLowerCase()).equals("y");
    }
       
    

    public void gameOver() {
        int home, plyr;
        display();
        home = game.score(game.getHouseCards());
        plyr = game.score(game.getYourCards());
        if((home>21)&&(plyr>21))
        {
            System.out.println("Both Lose");
        }

        else if (home > 21)
            System.out.println("You win");
        else if (plyr > 21)
            System.out.println("You Lose");
        else if ((21 - home) < (21 - plyr))
            System.out.println("House wins!");
        else
            System.out.println("You win!");

        System.out.println("Game over.");
    }
}

