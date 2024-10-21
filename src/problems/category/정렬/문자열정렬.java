package problems.category.정렬;

import java.util.*;
import java.io.*;

public class 문자열정렬 {


    static class Word{
        String word;
        int length;

        public Word(String word, int length){
            this.word = word;
            this.length = length;
        }
    }

    static int N;
    static List<Word> list = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine();

            if(!set.contains(word)){
                set.add(word);
                list.add(new Word(word, word.length()));
            }

        }



        Collections.sort(list, (o1, o2) -> {
            if(o1.length == o2.length) return o1.word.compareTo(o2.word);

            return o1.length - o2.length;
        });

        for(int i = 0; i < set.size(); i++){
            System.out.println(list.get(i).word);
        }



    }
}
