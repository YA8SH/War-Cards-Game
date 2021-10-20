public class Card {
    private int value;
    private CardType cardType;

    public Card(int value, CardType cardType){
        this.value = value;
        this.cardType = cardType;
    }
    public int getCardValue() {
        if (value == 1) {
            return 14;
        }
        return value;
    }

    public CardType getCardType() {
        return cardType;
    }

    public String toString() {
        return "Card{" + "value = " + this.value + ", cardType = " + this.cardType + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return this.value == card.value;
    }
}
