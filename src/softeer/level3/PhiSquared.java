package softeer.level3;

import java.io.*;
import java.util.*;

public class PhiSquared {
    static int N;
    static int pos;
    static int val;

    static class Micro{
        int pos;
        int val;

        public Micro(int pos, int val){
            this.pos = pos;
            this.val = val;
        }
        public void addVal(int val2){
            this.val += val2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Micro> microList = new LinkedList<>();

        for(int i = 0; i < N; i++){
            microList.add(new Micro(i+1, Integer.parseInt(st.nextToken())));
        }

        solve(microList);
//        solve(microList, microList.size());






    }

    public static void solve(List<Micro> microList){

//        if(microList.size() == 1){
//            pos = microList.get(0).pos;
//            val = microList.get(0).val;
//            return;
//        }
//
//        List<Micro> newMicroList = new LinkedList<>();

        while(microList.size() > 1){

            for(int i = 0; i < microList.size(); i++){
                System.out.println("size ; "  + microList.size());
                int currVal = microList.get(i).val;
                if(i != microList.size()-1){ // 마지막이 아닌 경우
                    System.out.println("마지막 제외");
                    int nextVal = microList.get(i+1).val;
                    if(currVal >= nextVal){
                        microList.get(i).addVal(nextVal);
                        System.out.println("i = " + i);
                        System.out.println("microList.get(i).pos = " + microList.get(i).pos);
                        System.out.println("microList.get(i).val = " + microList.get(i).val);
                        System.out.println();
                        microList.remove(i+1);

                    }
                }
                if(i != 0){ // 첫번째가 아닌 경우
                    System.out.println("첫번째 제외");
                    int prevVal = microList.get(i-1).val;
                    if(currVal >= prevVal){
                        System.out.println("i = " + i);
                        microList.get(i).addVal(prevVal);
                        System.out.println("microList.get(i).pos = " + microList.get(i).pos);
                        System.out.println("microList.get(i).val = " + microList.get(i).val);
                        System.out.println();
                        microList.remove(i-1);
                        i -= 1;
                    }
                }

            }
        }

        System.out.println(microList.get(0).val);
        System.out.println(microList.get(0).pos);



//        solve(newMicroList, newMicroList.size());

    }
}















