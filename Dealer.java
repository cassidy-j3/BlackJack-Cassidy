import java.util.ArrayList;

public class Dealer extends Player
{
    private ArrayList<Card> dealerHand = new ArrayList<>();
    public Dealer()
    {
        super("Robert");
    }

    public int getDealerHandValue()
    {
        int totalVal = 0;
        int aces = 0;
        for (Card card : dealerHand)
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

    public void dealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
        for (int i = 1; i <= dealerHand.size(); i++)
        {
            System.out.println(dealerHand.get(i));
        }
        System.out.println("The dealer's total hand value is " + getDealerHandValue());

    }
}