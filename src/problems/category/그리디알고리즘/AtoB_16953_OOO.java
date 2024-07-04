package problems.category.그리디알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class AtoB_16953_OOO {
    static long target;
    static long first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        first = Long.parseLong(temp[0]);

        target = Long.parseLong(temp[1]);

        long result2 = bfs();

        System.out.println(result2);
    }

    public static long bfs(){
        Queue<Long> queue = new LinkedList<>();
        queue.add(first * 2);
        queue.add(first * 10 + 1);

        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long curr = queue.poll();
                if(curr > target) continue;
                if (curr == target) {
                    return cnt+1;
                }
                queue.add(curr * 2);
                queue.add(curr * 10 + 1);
            }
        }

        return -1;
    }

    static int ans = 0;
    private static void dfs(long A, long B, int cnt) {

        if (A > B) {
            return;
        }

        if (A == B) {
            ans = Math.min(ans, cnt);
            return;
        }

        dfs(A * 2, B, cnt + 1);

        dfs((A * 10) + 1, B, cnt + 1);
    }

}
