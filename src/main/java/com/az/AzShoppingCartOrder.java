package com.az;

public class AzShoppingCartOrder {

    /**
     * Input: codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana,
     * orange, banana]
     * Output: 1
     * Explanation:
     * codeList contains two groups - [apple, apple] and [banana, anything, banana].
     * The second group contains 'anything' so any fruit can be ordered in place of 'anything' in the shoppingCart.
     * The customer is a winner as the customer has added fruits in the order of fruits in the groups and the order of
     * groups in the codeList is also maintained in the shoppingCart.
     * <p>
     * Example 2:
     * <p>
     * Input: codeList = [[apple, apple], [banana, anything, banana]]
     * shoppingCart = [banana, orange, banana, apple, apple]
     * Output: 0
     * Explanation:
     * The customer is not a winner as the customer has added the fruits in order of groups but group [banana, orange,
     * banana] is not following the group [apple, apple] in the codeList.
     * <p>
     * Example 3:
     * <p>
     * Input: codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [apple, banana, apple, banana,
     * orange, banana]
     * Output: 0
     * Explanation:
     * The customer is not a winner as the customer has added the fruits in an order which is not following the order
     * of fruit names in the first group.
     * <p>
     * Example 4:
     * <p>
     * Input: codeList = [[apple, apple], [apple, apple, banana]] shoppingCart = [apple, apple, apple, banana]
     * Output: 0
     * Explanation:
     * The customer is not a winner as the first 2 fruits form group 1, all three fruits would form group 2, but can't
     * because it would contain all fruits of group 1.
     *
     * @param args
     */
    public static void main(String[] args) {

        //String[][] codeList = {{"apple", "apple"}, {"apple", "apple", "banana"}};
        //String[] shoppingCart = {"apple", "apple", "apple", "banana"};

        String[][] codeList = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart = {"orange", "apple", "apple", "banana", "orange", "banana"};

        System.out.println(freshPromotion(codeList, shoppingCart));
    }

    private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0, codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if ((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur)) && hasOrder(shoppingCart, cartIdx, codeList[codeIdx])) {
                cartIdx += codeList[codeIdx++].length;
            } else {
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))) {
                idx++;
            } else {
                return false;
            }
        }
        return true;
    }
}
