import java.util.ArrayList;

public class WarGame {
    private DeckOfCards box, player1Deck, player2Deck;

    public void playGame() {
        initializeGame();
        while (!isGameOver()) {
            oneTurn();
        }

        if (player1Deck.isEmpty())
            System.out.println("Player 2 wins the game!");
        else
            System.out.println("Player 1 wins the game!");
    }
    private void initializeGame(){
        box = new DeckOfCards();
        for(int i=1;i<=13;i++){
            box.addCard(new Card(i, CardType.DIAMOND));
            box.addCard(new Card(i, CardType.HEART));
            box.addCard(new Card(i, CardType.SPADES));
            box.addCard(new Card(i, CardType.CLUB));
        }
        box.shuffle();
        player1Deck=new DeckOfCards();
        player2Deck=new DeckOfCards();
        for(int i=1;i<=26;i++){
            player1Deck.addCard(box.getCard());
            player2Deck.addCard(box.getCard());
        }
    }
    public boolean isGameOver() {
        if (player1Deck.isEmpty() && player2Deck.isEmpty()) {
            initializeGame();
        }
            return player1Deck.isEmpty() || player2Deck.isEmpty();
        }

    public void oneTurn(){
        ArrayList<Card> player1WarCards = new ArrayList<>();
        ArrayList<Card> player2WarCards = new ArrayList<>();
        player1WarCards.add(player1Deck.getCard());
        player2WarCards.add(player2Deck.getCard());
        Card lastCardPlayer1 = player1WarCards.get(0);
        Card lastCardPlayer2 = player2WarCards.get(0);
        while (lastCardPlayer1.equals(lastCardPlayer2)) {
            System.out.println("player 1: " + lastCardPlayer1 + ", player 2: " + lastCardPlayer2 + "\nCards values are the same. Go to war. ");
            player1WarCards.addAll(player1Deck.getUpTo3Cards());
            player2WarCards.addAll(player2Deck.getUpTo3Cards());

            if (player1WarCards.size() != player2WarCards.size()) {
                if (player1WarCards.size() > player2WarCards.size())
                    System.out.println("Player 2 doesn't have cards to fight the war.");
                else
                    System.out.println("Player 1 doesn't have cards to fight the war.");
                return;
            }

            lastCardPlayer1 = player1WarCards.get(player1WarCards.size() - 1);
            lastCardPlayer2 = player2WarCards.get(player2WarCards.size() - 1);
        }

        System.out.println("player 1: " + lastCardPlayer1 + ", player 2: " + lastCardPlayer2);
        if(lastCardPlayer1.getCardValue() > lastCardPlayer2.getCardValue()) {
            player1Deck.addCards(player1WarCards);
            player1Deck.addCards(player2WarCards);
            String cardsAmount = "player 1 number of cards: " + player1Deck.size() + ", player 2 number of cards: " + player2Deck.size();
            System.out.println("player 1 takes the round. " + cardsAmount);
        } else if (lastCardPlayer1.getCardValue() < lastCardPlayer2.getCardValue()){
            player2Deck.addCards(player1WarCards);
            player2Deck.addCards(player2WarCards);
            String cardsAmount = "player 1 number of cards: " + player1Deck.size() + ", player 2 number of cards: " + player2Deck.size();
            System.out.println("player 2 takes the round. " + cardsAmount);
        }
    }

}


