package softeer.level3;

import java.io.*;
import java.util.*;

public class 징검다리 {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int len = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] > dp[len]){
                len += 1; // 이게 키포인트
                dp[len] = arr[i];
            }
            else{
                idx = binary(0, len, arr[i]);
                dp[idx] = arr[i];
            }
        }

        System.out.println(len);



    }


    private static int binary(int left, int right, int key){
        int mid = 0;

        while(left < right){
            mid = (left + right) / 2;

            if(dp[mid] < key){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return right;

    }



}
