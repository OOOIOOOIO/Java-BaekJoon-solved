package problems.category.dfs_bfs_그래프순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2_12851 {
    static int N, K;
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) System.out.println(N - K + "\n" + 1);
        else{
            bfs();
            System.out.println(minTime);
            System.out.println(count);
        }

    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if(minTime < time[curr]){
                return;
            }

            for(int i = 0; i < 3; i++){
                int next = 0;

                if(i == 0) next = curr + 1;
                else if(i == 1) next = curr - 1;
                else next = curr * 2;

                if (next < 0 || next > 100000) continue;

                if(next == K){
//                    minTime = time[next]-1;
                    minTime = time[curr];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[curr] +1){
                    queue.offer(next);
                    time[next] = time[curr] + 1;

                }
            }
        }


    }
}
