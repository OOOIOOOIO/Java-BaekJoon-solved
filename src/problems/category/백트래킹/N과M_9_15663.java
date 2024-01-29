package problems.category.백트래킹;

import java.util.*;
import java.io.*;

public class N과M_9_15663 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] store;
    static Set<String> set = new LinkedHashSet<>();
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        store = new int[M];


        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
//                .distinct()
                .sorted()
                .toArray();

//        for(int i = 0; i < nums.length; i++){
//            System.out.println(nums[i]);
//
//        }
//        System.out.println("===");

        recur(0);


        set.forEach(System.out::println);
    }

    static void recur(int depth){

        // 종료
        if(depth == M){
            String answer = "";
            for(int num : store){
                answer += num + " ";
            }
            set.add(answer);
            return;
        }


        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                store[depth] = nums[i];
                recur(depth + 1);
                visited[i] = false;

            }
        }



    }


}
