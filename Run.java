import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        Scanner numScanner = new Scanner(System.in);
        System.out.println("How many players? ");
        int numOfPlayers = numScanner.nextInt();

        ArrayList<Player> playerList = new ArrayList<>();

        for(int i = 1; i <= numOfPlayers; i++)
        {
            Scanner nameScanner = new Scanner(System.in);
            System.out.println("What is " + i + "'s name?");
            String playerName = nameScanner.nextLine();

            Player player = new Player(playerName);
            playerList.add(player);

            player.hit(deck);
            player.hit(deck);
        }

        for (int i = 0; i <= playerList.size(); i++)
        {
            Player currentPlayer = playerList.get(i);
            currentPlayer.playTurn(deck);
            if(currentPlayer.getHandValue() > 21)
            {
                System.out.println("You lost");
                // subtract their bet
            }
            else if (currentPlayer.getHandValue() == 21)
            {
                System.out.println("You win");
                // gets 1.5x bet
            }
            //else if (players hand == dealers hand){
            // player gets no money, but doesn't lose money
            //}
            else
            {
                System.out.println("You win!!");
                //player gets their bet back
            }
        }


        // for(Card card : deck.getCards())
        // {
        //     System.out.println(card);
        // }
    }
}
