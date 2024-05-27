package softeer.level3;

import java.io.*;
import java.util.*;

public class 성적평균 {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            double sum = 0f;

            for(int i = start; i <= end; i++){
                sum += arr[i];
            }

            System.out.println(String.format("%.2f", sum / (end - start + 1)));

        }


    }

}
