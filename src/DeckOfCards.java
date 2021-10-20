import java.util.ArrayList;

public class DeckOfCards {

    private ArrayList<Card> cards;

    public DeckOfCards() {
        cards = new ArrayList<>();
    }
    public void shuffle (){
        ArrayList<Card> temp=new ArrayList<>();
        while (cards.size()>0){
            int i=(int)(Math.random()*cards.size());
            temp.add(cards.remove(i));
        }
        cards=temp;
    }
    public Card getCard(){
        if (isEmpty())
            return null;
        return cards.remove(0);
    }

    public ArrayList<Card> getUpTo3Cards(){
        ArrayList<Card> result = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (this.isEmpty()) {
                return result;
            } else {
                result.add(cards.remove(0));
            }
        }
        return result;
    }

    public void addCards(ArrayList<Card> cards){
        this.cards.addAll(cards);
    }
    public void addCard (Card c){
        this.cards.add(c);
    }
    public boolean isEmpty(){
        return cards.size()==0;
    }

    public int size() {
        return cards.size();
    }
}
