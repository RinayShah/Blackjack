import java.util.ArrayList;
/**
 *
 * @author r37shah
 */
public class CardPile
{
private Card c;
    private final ArrayList<Card> cards;
    public CardPile()
    {
     cards = new ArrayList();

    }

    public void add(Card card) {
           cards.add(card);
    }

    public Card removeRandom() {
        
     int x = (int)(Math.random()*(cards.size()));

     return cards.remove (x);

    }

    @Override
    public String toString()
    {
        int i = 0;
        String content= "Card list:";
         while (i < cards.size())
        {   content += (cards.get(i)).toString() + " ";
            i=i+1;
        }
    return content;
    }

    public static void main(String[] args)
    {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println(p.removeRandom());
        System.out.println(p.removeRandom());
        System.out.println(p.removeRandom());
        System.out.println(p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i< 15; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++)
        {
            System.out.println((i+1) + ": " + deck.removeRandom());
        }
    }
    public ArrayList <Card> getCards()
    {
        return cards;
    }
}
