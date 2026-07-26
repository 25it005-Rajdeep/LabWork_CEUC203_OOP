public class DriverCard {

    public static void main(String[] args) {

        Card[] cards = new Card[6];

        cards[0] = new Card("Ace", "Spades");
        cards[1] = new Card("King", "Hearts");
        cards[2] = new Card("Queen", "Diamonds");
        cards[3] = new Card("Ace", "Spades");
        cards[4] = new Card("Ten", "Clubs");

        for (int i = 0; i < 5; i++) {

            boolean duplicate = false;

            for (int j = 0; j < i; j++) {

                if (cards[i].equals(cards[j])) {
                    System.out.println("Duplicate found: " + cards[i]);
                    duplicate = true;
                    break;
                }
            }

            if (duplicate)
                break;
        }
    }
}