package softeer.level2;

import java.io.*;
import java.util.*;

public class 연탄의크기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(list);

        int max = list[list.length-1];
        int ans = -1;
        for(int i = 2; i <= 100; i++){

            if(i > max) break;

            int cnt = 0;

            for(int j = 0; j < list.length; j++){
                if(list[j] % i == 0) cnt++;
            }

            ans = Math.max(ans, cnt);
        }


        System.out.println(ans);
    }



}

