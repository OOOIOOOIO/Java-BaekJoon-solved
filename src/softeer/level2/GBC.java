package softeer.level2;

import java.io.*;
import java.util.*;

public class GBC {
    static int N;
    static int M;
    static int[][] test;
    static List<Section> limitList = new ArrayList<>();
    static List<Section> actList = new ArrayList<>();

    static class Section{
        private int start;
        private int end;
        private int speed;

        public Section(int start, int end, int speed){
            this.start = start;
            this.end = end;
            this.speed = speed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        test = new int[2][100];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startA = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for(int j = startA; j < startA + end; j++){
                test[0][j] = speed;
            }

            startA += end;

        }

        int startB = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for(int j = startB; j < startB + end; j++){
                test[1][j] = speed;
            }

            startB += end;

        }

        int max = 0;
        for(int i = 0; i < 100; i++){
//            System.out.println(i + "번 쨰 : " + test[0][i] + " | " + test[1][i] + " | " + Math.abs(test[0][i] - test[1][i]));
            System.out.println(i + "번 쨰 : " + test[0][i] + " | " + test[1][i] + " | " + (test[0][i] - test[1][i]));
            max = Math.max(max, test[1][i] - test[0][i]);
        }

        System.out.println(max);




        // int start = 0;
        // for(int i = 0; i < N; i++){
        //     st = new StringTokenizer(br.readLine());
        //     int end = Integer.parseInt(st.nextToken());
        //     int speed = Integer.parseInt(st.nextToken());

        //     limitSpeed.add(new Section(start, start + end, speed)));
        //     start = end;

        // }

        // int start = 0;
        // for(int i = 0; i < M; i++){
        //     st = new StringTokenizer(br.readLine());
        //     int end = Integer.parseInt(st.nextToken());
        //     int speed = Integer.parseInt(st.nextToken());

        //     actSpeed.add(new Section(start, start + end, speed)));
        //     start = end;

        // }




    }
}

