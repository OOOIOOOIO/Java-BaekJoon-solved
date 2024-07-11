package softeer.level3;

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class 효도음식_X {

    static int n;
    static Integer[][] map;
    static int[] toRight;
    static int[] toLeft;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }


        // 누적합 생성
        toRight = new int[n];
        toLeft = new int[n];

        toRight[0] = list.get(0);
        toLeft[n-1] = list.get(n-1);

        for(int i = 1; i < n; i++){
            toRight[i] = list.get(i) + toRight[i-1];
        }

        for(int i = n-2; i >= 0; i--){
            toLeft[i] = list.get(i) + toLeft[i+1];
        }

        // for(int i = 0; i < n; i++){
        //     System.out.print(toRight[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0; i < n; i++){
        //     System.out.print(toLeft[i] + " ");
        // }


        int sum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            for(int j = i + 2; j < n; j++){
                sum = Math.max(sum, toRight[i] + toLeft[j]);
            }
        }


        System.out.println(sum);


    }






}
