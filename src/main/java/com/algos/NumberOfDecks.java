package com.algos;

public class NumberOfDecks {
    public static void main(String[] args) {
        //output 0
        System.out.println(numberOfDecks(new String[]{"9C", "KS", "AC", "AH", "8D", "4C", "KD", "JC", "7D", "9D", "2H", "7C", "3C", "7S", "5C", "6H", "TH"}));

        //output 2
        System.out.println(numberOfDecks(new String[]{"2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH", "2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH", "2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD"}));

        //output 1
        System.out.println(numberOfDecks(new String[]{"TD", "TC", "6H", "5H", "KC", "JH", "QC", "4S", "2S", "8H", "JD", "2H", "AC", "7D", "6C", "5D", "AD", "TS", "4D", "KH", "3H", "9H", "3S", "2D", "5S", "6S", "AH", "JS", "6D", "9S", "4C", "7C", "8S", "AS", "KD", "7S", "4H", "KS", "7H", "9D", "8D", "3D", "5C", "9C", "QH", "JC", "8C", "TH", "QS", "3C", "QD", "2C"}));

        //output 2
        System.out.println(numberOfDecks(new String[]{"2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "2S", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH", "AH"}));

        //output 1
        System.out.println(numberOfDecks(new String[]{"QC", "6D", "KD", "QS", "7S", "5C", "QH", "3H", "AD", "9C", "7H", "QD", "QH", "2S", "AH", "KS", "5D", "QC", "AS", "2D", "6C", "8C", "7D", "8H", "9S", "4D", "6H", "JC", "3S", "4C", "3C", "7S", "KD", "4H", "5C", "7C", "AS", "3D", "7D", "2H", "8S", "2H", "8D", "9S", "3C", "5H", "KS", "8D", "9H", "TH", "2C", "JH", "6D", "KC", "TS", "6S", "TD", "4S", "8S", "5S", "8H", "TD", "9D", "4H", "6C", "7C", "AC", "JC", "JD", "TS", "KH", "2C", "QD", "JS", "QS", "KH", "8C", "3H", "2D", "2S", "3S", "5H", "4S", "9C", "4D", "6H", "JS", "TH", "9H", "TC", "7H", "JH", "TC", "6S", "AD", "AC", "JD", "4C", "5D", "9D", "KC", "3D"}));

        //output 0
        System.out.println(numberOfDecks(new String[]{"AC", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH", "AC", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH", "AC", "2C", "2D", "2H", "3S", "3C", "3D", "3H", "4S", "4C", "4D", "4H", "5S", "5C", "5D", "5H", "6S", "6C", "6D", "6H", "7S", "7C", "7D", "7H", "8S", "8C", "8D", "8H", "9S", "9C", "9D", "9H", "TS", "TC", "TD", "TH", "JS", "JC", "JD", "JH", "QS", "QC", "QD", "QH", "KS", "KC", "KD", "KH", "AS", "AC", "AD", "AH"}));

    }

    private static int numberOfDecks(String[] arr) {
        //A-Z
        int[] H = new int[128];//13
        int[] S = new int[128];//13
        int[] C = new int[128];//13
        int[] D = new int[128];//13

        char[] charArray;
        char card;
        char suit;

        for (String current : arr) {
            charArray = current.toCharArray();
            card = charArray[0];
            suit = charArray[1];

            switch (suit) {
                case 'H':
                    H[card]++;
                    break;
                case 'S':
                    S[card]++;
                    break;
                case 'C':
                    C[card]++;
                    break;
                case 'D':
                    D[card]++;
                    break;
            }
        }

        int decks = 0;
        while (true) {
            int HC = calculateNumberOfCards(H);
            if (HC == 0)
                break;
            int DC = calculateNumberOfCards(D);
            if (DC == 0)
                break;
            int SC = calculateNumberOfCards(S);
            if (SC == 0)
                break;
            int CC = calculateNumberOfCards(C);
            if (CC == 0)
                break;

            if (HC == 13 && DC == 13 && SC == 13 && CC == 13) {
                decks++;
            }
        }
        return decks;
    }

    private static int calculateNumberOfCards(int[] suit) {
        int numberOfCards = 0;
        for (int i = 0; i < suit.length; i++) {
            if (suit[i] > 0) {
                numberOfCards++;
                suit[i]--;
            }
        }
        return numberOfCards;
    }
}
