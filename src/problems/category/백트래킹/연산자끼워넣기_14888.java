package problems.category.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 연산자끼워넣기_14888 {

    static int N;
    static int M;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static long[] op = new long[4];
    static long[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());// 6
        M = N-1; // 5
        number = new long[N];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            number[i] = Long.parseLong(st.nextToken());
        }


        // 0 : +, 1 : -, 2 : *, 3 : / 로 정의
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            int size = Integer.parseInt(st.nextToken());
            op[i] = size;
        }

        dfs(number[0], 1);

        System.out.println(max);
        System.out.println(min);


    }
    private static void dfs(long num, int depth){
        if(depth == N){
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }

        for(int i = 0; i < 4; i++){

            // 있을 때만
            if(op[i] > 0){
                op[i]--;

                switch (i){
                    case 0: dfs(num + number[depth], depth + 1);
                        break;
                    case 1: dfs(num - number[depth], depth + 1);
                        break;
                    case 2: dfs(num * number[depth], depth + 1);
                        break;
                    case 3: dfs(num / number[depth], depth + 1);
                        break;

                }

                op[i]++;
            }



        }

    }




}
