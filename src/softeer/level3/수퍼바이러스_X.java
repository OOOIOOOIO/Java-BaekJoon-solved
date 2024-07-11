package softeer.level3;

import java.util.*;
import java.io.*;

public class 수퍼바이러스_X {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long ans = (long)((K * (Math.pow(P, N * 10))) % 1000000007);

        System.out.println(ans);



    }
}
