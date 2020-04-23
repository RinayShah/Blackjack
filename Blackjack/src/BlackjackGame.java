/**
 *
 * @author r37shah
 */

public class BlackjackGame {

    private final CardPile deck;
    private final CardPile houseCards;
    private final CardPile yourCards;
    private boolean houseDone;
    private boolean playerDone;
    private final UserInterface ui;

    public BlackjackGame(UserInterface ui) {
        this.ui = ui;
        ui.setGame(this);
        deck = new CardPile();
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }

        houseCards = new CardPile();
        yourCards = new CardPile();
        houseDone = false;
        playerDone = false;
    }

    public void start() {
        Card c;
        c = deck.removeRandom();
        c.setFaceUp(false);
        getHouseCards().add(c);
        getHouseCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        getYourCards().add(deck.removeRandom());
        ui.display();
    }

    public void play() {
        while (!houseDone || !playerDone) {
            if (!houseDone) {
                if (score(getHouseCards()) <= 17) {
                    getHouseCards().add(deck.removeRandom());
                    ui.display();
                } else {
                    houseDone = true;
                }
            }
            if (!playerDone) {
                if (ui.hitMe()) {
                    getYourCards().add(deck.removeRandom());
                    ui.display();
                } else {
                    playerDone = true;
                }
            }
        }
    }

    public void end() {
        getHouseCards().getCards().get(0).setFaceUp(true);
        ui.gameOver();
    }

    public int score(CardPile p) {
         int score = 0;
        for (Card c: p.getCards())
            if (c.getRank() >= 2 && c.getRank() <= 10)
                score += c.getRank();
            else if (c.getRank() >= 11 && c.getRank() <= 13)
                score += 10;
            else
                score += 11;

        return score;
    }

    public CardPile getHouseCards() {
        return houseCards;
    }

    public CardPile getYourCards() {
        return yourCards;
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame( new SimpleUI());
        game.start();
        game.play();
        game.end();
    }
}

