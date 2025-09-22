import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    private double bet;

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
        this.bet = 0;

    }

    public void playTurn(Deck deck)
    {
        Scanner playTurnScanner = new Scanner(System.in);
        System.out.println("Do you want to hit (h) or stay (s) type h or s");
        String hitOrStay = playTurnScanner.nextLine();
        hitOrStay.toLowerCase();

        if(hitOrStay == "h")
        {
            this.hit(deck);
            if (this.getHandValue() > 21)
            {
                return;
            }
        }
        else
        {
            return;
        }
        
    }

    public void hit(Deck deck)
    {
       Card newCard = deck.getTopCard();
       this.hand.add(newCard);
       for (Card card : hand)
       {
        System.out.println(card);
       }
        System.out.println("Your total hand value is " + getHandValue());
    }

    public int getHandValue()
    {
        int totalVal = 0;
        int aces = 0;
        for (Card card : hand)
        {
            int cardValue = card.getCardValue();
            totalVal = totalVal + cardValue;
            if (cardValue == 11)
            {
                aces ++;
            }
        }
        while (aces > 0)
        {
            if (totalVal > 21)
            {
                totalVal = totalVal - 10;
                aces --;
            }
            else
            {
                aces = 0;
            }
        }

        return totalVal;
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }

    public void setBet()
    {
        boolean validBet = false;
        while (validBet = false)
        {
            Scanner bettingScanner = new Scanner(System.in);
            System.out.println("How much money do you want to bet? you have " + money + " dollars.");
            Double setPlayerBet = bettingScanner.nextDouble();
            bettingScanner.nextLine();
            if (setPlayerBet <= this.money)
            {
                this.bet = setPlayerBet;
                validBet = true;
            }
            else
            {
                System.out.println("Invalid bet try again but better :(");
                System.out.println("Hit enter to continue...");
                bettingScanner.nextLine();
            }
            
        }
       
    }

    public void handleBet(int dealerHandValue)
    {
        if(getHandValue() > 21)
        {
            System.out.println("You lose");
            this.money = money-bet;
        }
        else if (getHandValue() == dealerHandValue)
        {
            System.out.println("You tied, you don't win or lose money.");
        }
        else if (getHandValue() == 21)
        {
            System.out.println("You win!!");
            this.bet = bet*1.5;
            this.money = bet + money;
        }
        else if (dealerHandValue > getHandValue())
        {
            System.out.println("You lose");
            this.money = money-bet;
        }
        else
        {
            System.out.println("You win");
            this.money = bet + money;
        }
    }

}