package problems.category.수학;

import java.util.*;
import java.io.*;

public class 수나누기게_27172 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] players = new int[N];
        int INF = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            players[i] = Integer.parseInt(st.nextToken());
            INF = Math.max(INF, players[i]);
        }

        int[] scores = new int[N+1];
        int[] pos = new int[INF+1];

        for(int i = 0; i < N; i++){
            pos[players[i]] = i+1;
        }

        for(int mod : players) {
            for(int i = mod*2; i <= INF; i += mod) {
                if (pos[i] != 0) {
                    scores[pos[i]]--;
                    scores[pos[mod]]++;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            sb.append(scores[i]).append(" ");
        }

        System.out.print(sb);

    }


}
