package com.cf.may6_977;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class ProblemE {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            Elem[] a = new Elem[n];

            for (int i = 0; i < n; i++) {
                a[i] = new Elem(in.nextLong());
            }

            Arrays.sort(a);

            for (int i = 0; i < n; i++) {
                if (i > 0) out.print(" ");
                out.print(a[i].val);
            }
            out.println();
        }

        private class Elem implements Comparable<Elem> {
            long val;
            int deg3;

            public Elem(long v) {
                val = v;
                deg3 = count3(v);
            }

            private int count3(long x) {
                int ret = 0;
                while (x % 3 == 0) {
                    ret++;
                    x /= 3;
                }

                return ret;
            }


            public int compareTo(Elem o) {
                if (deg3 == o.deg3) return Long.compare(val, o.val);
                return o.deg3 - deg3;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}