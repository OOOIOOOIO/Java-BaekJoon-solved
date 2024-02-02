package softeer.level2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class 전광판 {


    static boolean[][] numbers = new boolean[][]{

            {true, true, true, true, true, true, false}, //0
            {false, true, true, false, false, false, false},//1
            {true, true, false, true, true, false, true},//2
            {true, true, true, true, false, false, true},//3
            {false, true, true, false, false, true, true},//4
            {true, false, true, true, false, true, true},//5
            {true, false, true, true, true, true, true},//6
            {true, true, true, false, false, true, false},//7
            {true, true, true, true, true, true, true},//8
            {true, true, true, true, false, true, true}//9
    };






    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());


        while(T-- > 0){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());

            char[] arrA = st.nextToken().toCharArray(); // String -> char[]
            char[] arrB = st.nextToken().toCharArray(); // String -> char[]
            char[] reversedArrA = new char[arrA.length];
            char[] reversedArrB = new char[arrB.length];
            for(int i = 0; i < arrA.length; i++){
                reversedArrA[arrA.length-1-i] = arrA[i];
            }
            for(int i = 0; i < arrB.length; i++){
                reversedArrB[arrB.length-1-i] = arrB[i];
            }

            String A = new String(reversedArrA);
            String B = new String(reversedArrB);

//            String A = Arrays.stream(st.nextToken().split(""))
//                    .collect(Collectors.toList())
//                    .stream()
//                    .sorted((o1, o2) -> o2.compareTo(o1))
//                    .collect(Collectors.joining());
//
//            String B = Arrays.stream(st.nextToken().split(""))
//                    .collect(Collectors.toList())
//                    .stream()
//                    .sorted((o1, o2) -> o2.compareTo(o1))
//                    .collect(Collectors.joining());



            System.out.println("A : "  + A);
            System.out.println("B : " + B);


            int smallLen = 0;
            String smallStr = "";
            int bigLen = 0;
            String bigStr = "";

            if(A.length() < B.length()){
                smallLen = A.length();
                smallStr = A;
                bigLen = B.length();
                bigStr = B;
            }
            else{
                smallLen = B.length();
                smallStr = B;
                bigLen = A.length();
                bigStr = A;
            }

            for(int i = 0; i < smallLen; i++){
                int small = smallStr.charAt(i) - '0';
                int big = bigStr.charAt(i) - '0';
                System.out.println("small : " + small + " | " + "big : " + big);

                for(int j = 0; j < 7; j++){
                    if(numbers[small][j] != numbers[big][j]){
                        cnt++;
                    }
                }


            }

            //남은 것
            for(int i = smallLen; i < bigLen; i++){
                int num = bigStr.charAt(i) - '0';
                System.out.println("num : " + num);
                for(int j = 0; j < 7; j++){
                    if(numbers[num][j]){
                        cnt++;
                    }
                }


            }

            System.out.println(cnt);

        }


    }
}
