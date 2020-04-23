/**
 *
 * @author r37shah
 */
public class Card
{
    public  static final int CLUB = 0,DIAMOND = 1,HEART = 2, SPADE = 3;
    //private int rnk1,sut1;
    //private boolean fup1;
    private final int cRank;
    private final int cSuit;
    private boolean cFace;
    public Card(int rank, int suit, boolean faceUp)
    {
    
    cRank = rank;
    cSuit = suit;
    cFace = faceUp;
    }

    public boolean isFaceUp()
    {
        return cFace;
    }

    public void setFaceUp(boolean faceUp)
    {
     cFace=faceUp;
    }

    public int getRank() {
    return cRank; 
  }

  public int getSuit() {
    return cSuit;
  }

    @Override
    public boolean equals(Object ob)
    {
        if (!(ob instanceof Card))
        {
            return false;
        }
        Card c = (Card) ob;
       if (this.cRank == c.cRank && this.cSuit == c.cSuit)
        return true; 
    else
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + this.getRank();
        hash = 31 * hash + this.getSuit();
        return hash;
    }

    public int compareTo(Object obj)
    {
        return compareTo((Card) obj);
    }

    public int compareTo(Card c)
    {
       if ((this.getRank()== c.getRank())&&(this.getSuit()==c.getSuit()))
            return 0;

                if (this.getRank()> c.getRank())
                return 1;

                        if (this.getRank()< c.getRank())
                         return -1;

                if ((this.getRank()== c.getRank())&&(this.getSuit()>c.getSuit()))
                return 1;
       
       if ((this.getRank()== c.getRank())&&(this.getSuit()<c.getSuit()))
         return -1;

       return 0;
    }

   public String getRankString()
   {
       if (this.cRank>= 2 && cRank <= 10)
            return (String.valueOf(cRank));

             else if (this.cRank == 11)
             return ("Jack");

                  else if (this.cRank == 12)
                  return ("Queen");

                       else if (this.cRank== 13)
                       return ("King");

                            else if (this.cRank == 14)
                            return "Ace";
                            return null;
    }

    public String getSuitString()
    {
                            if (this.getSuit()==1)
                            return "DIAMOND";

                     if (this.getSuit()==0)
                     return "CLUB";

            if (this.getSuit()==2)
            return "HEARTS";

        return "SPADE";
    }

    @Override
    public String toString() {
        if (cFace==false)
            return "?";
        else
        return (getRankString()+ " of " + getSuitString());
    }

    public static void main(String[] args) {

        Card club5 = new Card(5, 0, true);
        System.out.println(club5);
        Card spadeAce = new Card(14, SPADE, true);
        System.out.println(spadeAce);
        System.out.println("club5 compare To spadeAce: " +
                club5.compareTo(spadeAce));
        System.out.println("club5 compare To club5: " +
                club5.compareTo(club5));
        System.out.println("club5 equals spadeAce: " +
                club5.equals(spadeAce));
        System.out.println("club5 equals club5: " +
                club5.equals(club5));
    }

}
