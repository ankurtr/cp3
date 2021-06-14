package com.educative;

import java.util.*;

public class Intervals {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        /*List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));

        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/

        /*List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/

        /*List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/

        /*List<Interval> input1 = new ArrayList<>();
        input1.add(new Interval(1, 3));
        input1.add(new Interval(5, 6));
        input1.add(new Interval(7, 9));

        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(2, 3));
        input2.add(new Interval(5, 7));

        for (Interval interval : intersect(input1, input2))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/

        List<Interval> input1 = new ArrayList<>();
        input1.add(new Interval(1, 3));
        input1.add(new Interval(5, 7));
        input1.add(new Interval(9, 12));

        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(5, 10));

        for (Interval interval : intersect(input1, input2))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> intersect(List<Interval> intervals1, List<Interval> intervals2) {
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        Interval i1;
        Interval i2;

        while (i < intervals1.size() && j < intervals2.size()) {
            i1 = intervals1.get(i);
            i2 = intervals2.get(j);
            if ((i1.start >= i2.start && i1.start <= i2.end) ||
                    (i2.start >= i1.start && i2.start <= i1.end)) {
                result.add(new Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end)));
            }
            if (i1.end > i2.end) {
                j++;
            } else {
                i++;
            }
        }
        return result;
    }

    private static List<Interval> insert(List<Interval> intervals, Interval toInsert) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.singletonList(toInsert);
        }

        Interval newInterval = new Interval(toInsert.start, toInsert.end);
        List<Interval> result = new ArrayList<>();
        int i = 0;

        while (i < intervals.size() && intervals.get(i).end < toInsert.start) {
            result.add(intervals.get(i++));
        }

        while (i < intervals.size() && intervals.get(i).start < newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }

        result.add(newInterval);

        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }
        return result;
    }

    private static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> merged = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start < end) {
                end = Math.max(end, current.end);
            } else {
                merged.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }

        merged.add(new Interval(start, end));
        return merged;
    }
}
