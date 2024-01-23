package problems.category.이분탐색;

import java.io.*;
import java.util.*;

public class 가장긴바이토닉부분수열_11054 {


    static Integer[] lds;
    static Integer[] lis;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        lds = new Integer[N];
        lis = new Integer[N];

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        for(int i = 0; i < N; i++){
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i = 0; i < N; i++){
            max = Math.max(lis[i] + lds[i], max);
        }

        System.out.println(max -1);


    }

    // 순방향
    static int LIS(int curr) {

        // 만약 탐색하지 않던 위치의 경우
        if (lis[curr] == null) {
            lis[curr] = 1; // 1로 초기화

            // 오름차순. 진행방향은 ->, 검사는 <-방향으로 검사
            for (int i = curr - 1; i >= 0; i--) {
                // 이전의 노드 중 arr[curr]의 값보다 작은 걸 발견했을 경우
                if (arr[i] < arr[curr]) {
                    lis[curr] = Math.max(lis[curr], LIS(i) + 1);
                }
            }
        }
        return lis[curr];
    }

    // 역방향
    static int LDS(int curr) {

        // 만약 탐색하지 않던 위치의 경우
        if (lds[curr] == null) {
            lds[curr] = 1; // 1로 초기화

            // 내림차순. 진행방향은 -> , 검사도 ->방향으로 검사
            for (int i = curr + 1; i < N; i++) {
                // 이후의 노드 중 arr[curr]의 값보다 작은 걸 발견했을 경우
                if (arr[i] < arr[curr]) {
                    lds[curr] = Math.max(lds[curr], LDS(i) + 1);
                }
            }
        }
        return lds[curr];
    }



}
