package problems.category.백트래킹;

import java.util.*;
import java.io.*;
import java.util.stream.*;
public class N과M_12_15666 {



    static int N;
    static int M;
    static int[] nums;
    static int[] store;
    static Set<String> set = new LinkedHashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        store = new int[M];

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
//
//        for(int i = 0; i < nums.length; i++){
//            System.out.println(nums[i]);
//
//        }
//
//        System.out.println("===");

        recur(0, 0);

        set.forEach(System.out::println);


    }


    /**
     * l
     * @param depth
     * @param startIdx
     */
    public static void recur(int depth, int startIdx){

        if(depth == M){

            String answer = "";
            for(int num : store){
                answer += num + " ";
            }
            set.add(answer);
            return;

        }

        for(int i = startIdx; i < N; i++){
            //이전

            store[depth] = nums[i];
            recur(depth+1, i);


        }

    }
}
