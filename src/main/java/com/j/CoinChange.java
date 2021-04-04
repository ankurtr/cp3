package com.j;

public class CoinChange {
    private static final int[] denominations = new int[]{100, 50, 25, 10, 5, 1};

    public static void main(String[] args) {
        System.out.println(getChange(5, 0.99F));
    }

    public static int[] getChange(float M, float P) {
        float newMoney = M * 100;
        float newPrice = P * 100;

        float change = newMoney - newPrice;

        int currentDenomination = denominations[0];
        int[] result = new int[6];
        int currentIndex = 0;
        float c;
        //401
        while (change > 0) {
            //76, 25
            c = change / currentDenomination;
            result[currentIndex] = (int) c;//((int) currentDenomination * (int) c)%100;
            change = change % currentDenomination;
            currentDenomination = denominations[++currentIndex];
        }
        return result;
    }
}
