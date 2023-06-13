package problems.category.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_8_15657 {
    static int N, M;
    static int[] seq;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        nums = new int[N];

        String[] temp = br.readLine().split(" ");

        for(int i = 0; i < temp.length; i++){
            nums[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(nums);

        backTracking(0, 0);


        System.out.println(sb.toString());


    }

    static void backTracking(int depth, int lastIdx){

        if(depth == M){
            for(int num : seq){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i = lastIdx; i < N; i++){

            seq[depth] = nums[i];
            backTracking(depth+1, i);

        }
    }

}

