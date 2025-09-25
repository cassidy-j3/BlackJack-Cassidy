import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        Scanner numScanner = new Scanner(System.in);
        System.out.println("How many players? ");
        int numOfPlayers = numScanner.nextInt();
        numScanner.nextLine();

        ArrayList<Player> playerList = new ArrayList<>();

        for(int i = 1; i <= numOfPlayers; i++)
        {
            Scanner nameScanner = new Scanner(System.in);
            System.out.println("What is " + i + "'s name?");
            String playerName = nameScanner.nextLine();

            Player player = new Player(playerName);
            playerList.add(player);
        }

        Dealer dealer = new Dealer();

        boolean gameGoing = true;
        while (gameGoing == true)
        {
            dealer.firstDealerHit(deck);
            dealer.secondDealerHit(deck);

            for (Player player : playerList)
            {
                player.setBet();

                System.out.println(player.getName() + " has");

                player.hit(deck);

                player.hit(deck);
            }

            for(Player player : playerList)
            {
                player.playTurn(deck);
            }


            dealer.dealerTurn(deck);

            for (Player player : playerList)
            {
                player.handleBet(dealer.getDealerHandValue());
                if (player.getMoney() == 0.0)
                {
                    break;
                }
            }
            Scanner keepPlayingScanner = new Scanner(System.in);
            System.out.println("Do you want to keep playing? (y or n)");
            String keepPlaying = keepPlayingScanner.nextLine();
            keepPlaying.toLowerCase();
            if (keepPlaying.equals("n"))
            {
                break;
            }
        }

    }
}
