package com.j;
import java.util.HashMap;
public class MS3 {
    // 1 1 2 , 3 2 3
    static class Fraction {
        int num;
        int den;
        public Fraction(int num, int den) {
            this.num = num;
            this.den = den;
        }
        public int[] get() {
            return new int[]{num, den};
        }
        public Fraction getResidue() {
            Fraction normalized = normalize();
            return new Fraction(normalized.den - normalized.num, normalized.den);
        }
        public Fraction normalize() {
            int gcd = gcd(num, den);
            return new Fraction(num / gcd, den / gcd);
        }
        public static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
        public boolean equals(Object other) {
            if (other == null) return false;
            if (other instanceof Fraction) {
                Fraction f2 = ((Fraction) other).normalize();
                Fraction f1 = normalize();
                if (f1.num == f2.num && f1.den == f2.den) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        public int hashCode() {
            return num + den;
        }
    }
    public static void main(String args[]) {
        HashMap<Fraction, Integer> seenFractions = new HashMap<>();
        int pairs = 0;
        int num[] = {1, 1, 2};
        int den[] = {3, 2, 3};
        for (int i = 0; i < num.length; i++) {
            Fraction f = new Fraction(num[i], den[i]);
            Fraction residue = f.getResidue();
            if (seenFractions.containsKey(residue.normalize())) {
                pairs += seenFractions.get(residue.normalize());
            }
            if (seenFractions.containsKey(f.normalize())) {
                int currentCount = seenFractions.get(f.normalize());
                seenFractions.put(f.normalize(), currentCount + 1);
            }
        }
        //return pairs;
    }
}