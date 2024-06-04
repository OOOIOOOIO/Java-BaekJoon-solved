package problems.category.수학;

import java.util.*;
import java.io.*;

/**
 * 신발끈 공식
 */

public class 다각형의면적_2166 {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] points = new long[N + 1][2];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            points[n][0] = Long.parseLong(st.nextToken());
            points[n][1] = Long.parseLong(st.nextToken());
        }
        points[N] = points[0].clone();

        long sum1 = 0L;
        long sum2 = 0L;

        for (int n = 0; n < N; n++) {
            sum1 += points[n][0] * points[n + 1][1];
            sum2 += points[n][1] * points[n + 1][0];
        }

        double answer = Math.abs(sum1 - sum2) / 2D;

        System.out.println(String.format("%.1f", answer));
    }
}
