package com.j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class ShopifyComparator {


    public static void main1(String[] args) {

        String[][] strs = {{"X", "90", "50"}, {"Y", "91", "40"}, {"Z", "91", "30"}};

        Arrays.sort(strs,
                comparingInt((String[] str) -> Integer.parseInt(str[1])).reversed()
                        .thenComparing((String[] str) -> Integer.parseInt(str[2])));

        IntStream.range(0, strs.length)
                .forEach(index -> {
                    System.out.print(strs[index][0]);
                    System.out.print(strs[index][1]);
                    System.out.println(strs[index][2]);
                });
    }

    public static void main(String[] args) {
        /*String[] list = {"A", "B", "C", "A", "C"};

        Map<String, Long> map = Arrays.stream(list)
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()));

        System.out.println(map);*/

       /* String str = "annkkuurtratpasiya";

        Map<Integer, Long> freq = str.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        char result;

        result = (char) (int) freq.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE);

        System.out.println(result);*/

        /*Pattern pattern = Pattern.compile(" +");

        String text = "Be confident Be Courageus Be Strong Be Happy Be Awesome";

        String result = pattern.splitAsStream(text)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));

        System.out.println(result);*/

        /*String containsDigit = "ankur1234trapasiya";
        String noDigit = "aniltrapasiya";

        Predicate<String> predicate = str -> str.chars().anyMatch(Character::isDigit);
        boolean containsDigitR = predicate.test(containsDigit);
        System.out.println(containsDigitR);

        containsDigitR = predicate.test(noDigit);
        System.out.println(containsDigitR);*/

        /*String name = "ankurtrapasiya";

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');*/

        /*Map<Boolean, Long> result = name.chars().mapToObj(c -> (char) c)
                .collect(Collectors.partitioningBy(vowels::contains, Collectors.counting()));*/

        /*Map<Boolean, List<Character>> result = name.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(vowels::contains, Collectors.toList()));

        System.out.println(result.get(true));
        System.out.println(result.get(false));*/

        /*String str = "malam";

        boolean isPalindrome = IntStream.range(0, str.length() / 2)
                .allMatch(idx -> str.charAt(idx) == str.charAt(str.length() - idx - 1));

        System.out.println(isPalindrome);

        System.out.println(Arrays.stream(str.split("")).distinct().collect(Collectors.joining()));*/

        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        Comparator<int[]> comparator = comparingInt((int[] tasks1) -> tasks1[0])
                .thenComparing((int[] tasks2) -> tasks2[1]);
        Arrays.sort(tasks, comparator.reversed());

        Arrays.stream(tasks)
                .forEach(task -> System.out.println(Arrays.toString(task)));
    }
}
