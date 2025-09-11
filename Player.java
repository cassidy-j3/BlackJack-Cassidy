import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn()
    {
        Scanner hitOrStay = new Scanner("Do you want to hit (h) or stay (s)? To hit type h, to stay type s.");
        String userInput = hitOrStay.nextLine();
        userInput.toLowerCase();

    }

    public void hit(Deck deck)
    {
       Card newCard = deck.getTopCard();
       this.hand.add(newCard);
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
}