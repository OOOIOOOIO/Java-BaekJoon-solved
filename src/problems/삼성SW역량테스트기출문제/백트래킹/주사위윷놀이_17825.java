package problems.삼성SW역량테스트기출문제.백트래킹;

import java.util.*;
import java.io.*;

public class 주사위윷놀이_17825{

    static class Space{
        int num; // idx랑 일치
        int score;
        int nextNum; // 1차이씩

        public Space(int num, int score, int nextNum){
            this.num = num;
            this.score = score;
            this.nextNum = nextNum;
        }
    }


    static Map<Integer, Space> board = new HashMap<>();
    static List<Integer> diceList = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 10; i++){
            diceList.add(Integer.parseInt(st.nextToken()));
        }


        makeBoard();

        dfs();
    }



    // dfs, backtracking
    private static void dfs(){

    }





    // make map
    private static void makeBoard(){

        board.put(1, new Space(1, 2, 2));
        board.put(2, new Space(2, 4, 3));
        board.put(3, new Space(3, 6, 4));
        board.put(4, new Space(4, 8, 5));
        board.put(5, new Space(5, 10, -6)); // blue

        board.put(-6, new Space(-6, 13, -7));
        board.put(-7, new Space(-7, 16, -8));
        board.put(-8, new Space(-8, 19, -9));


        board.put(-9, new Space(-9, 25, -1)); // 가운데


        board.put(-1, new Space(-1, 30, -2));
        board.put(-2, new Space(-2, 35, 20)); // 마지막으로


        board.put(6, new Space(6, 12, 7));
        board.put(7, new Space(7, 14, 8));
        board.put(8, new Space(8, 16, 9));
        board.put(9, new Space(9, 18, 10));
        board.put(10, new Space(10, 20, -11)); // blue

        board.put(-11, new Space(-11, 22, -12));
        board.put(-12, new Space(-12, 24, -9));


        board.put(11, new Space(11, 22, 12));
        board.put(12, new Space(12, 24, 13));
        board.put(13, new Space(13, 26, 14));
        board.put(14, new Space(14, 28, 15));
        board.put(15, new Space(15, 30, -16)); // blue

        board.put(-16, new Space(-16, 28, -17));
        board.put(-17, new Space(-17, 27, -18));
        board.put(-18, new Space(-18, 26, -9));

        board.put(16, new Space(16, 32, 17));
        board.put(17, new Space(17, 34, 18));
        board.put(18, new Space(18, 36, 19));
        board.put(19, new Space(19, 38, 20));
        board.put(20, new Space(20, 40, -100));

    }


}
