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

    public boolean isSoft()
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
                return false;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    
    public void firstDealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
    }

    public void secondDealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
        System.out.println("The dealer has an unkown card and " + newCard);
    }

    public void dealerHit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.dealerHand.add(newCard);
        System.out.println(dealerHand);
    }

    public void dealerTurn(Deck deck)
    {
        while (getDealerHandValue() < 17 || getDealerHandValue() == 17 && isSoft() == true)
        {
            dealerHit(deck);
        }
    }
}