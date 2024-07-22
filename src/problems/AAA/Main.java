package problems.AAA;

import java.util.*;
import java.io.*;

public class Main{


    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[][] map = new String[N][M];
        List<HashSet<String>> list = new ArrayList<>();
        for(int i = 0; i < M; i++){
            list.add(new HashSet<String>());
        }

        int max = -1;
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split("");

            map[i] = str;
        }

        for(int j = 0; j < M; j++){
            HashSet<String> set = list.get(j);

            for(int i = 0; i < N; i++){
                if(!(set.contains(map[i][j])) && !map[i][j].equals(".")){
                    set.add(map[i][j]);
                }

            }

            max = Math.max(max, set.size());
        }

        if(max == -1){
            System.out.println(1);
        }
        else{
            System.out.println(max);
        }

    }
}