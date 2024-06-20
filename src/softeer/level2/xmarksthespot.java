package softeer.level2;

import java.io.*;
import java.util.*;

public class xmarksthespot {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken().toLowerCase();
            String str2 = st.nextToken();
            // System.out.println(str1);
            // System.out.println(str1.indexOf('x'));
            sb.append(str2.charAt(str1.indexOf('x')));
        }

        System.out.println(sb.toString().toUpperCase());
    }
}


