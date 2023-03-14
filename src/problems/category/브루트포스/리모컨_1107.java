package problems.category.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int channel = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean [] broken = new boolean[10];

        if(n > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i) broken[Integer.parseInt(st.nextToken())] = true;
        }
        
        int answer = Math.abs(channel-100);

        next : for(int i = 0; i < 1000000; ++i){
        	
            String cur = i+"";
            int len = cur.length();

            for(int j = 0; j < len; ++j){
                if(broken[cur.charAt(j)-'0']) continue next;
            }
            
            answer = Math.min(answer,len + Math.abs(channel-i));
        }

        System.out.print(answer);
    }
}
