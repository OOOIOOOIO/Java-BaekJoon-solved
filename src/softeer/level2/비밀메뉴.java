package softeer.level2;


import java.io.*;
import java.util.*;

public class 비밀메뉴 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String secret = br.readLine().strip();
        String context = br.readLine().strip();

        if (context.contains(secret)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}
