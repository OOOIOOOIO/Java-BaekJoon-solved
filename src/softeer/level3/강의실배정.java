package softeer.level3;

import java.util.*;
import java.io.*;

public class 강의실배정{

    static class Class{
        int start;
        int end;

        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static int N;
    static List<Class> cList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            cList.add(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(cList, (o1, o2) -> {
            if(o1.start == o2.start) return o1.end - o2.end;

            return o1.start - o2.start;

        });

        int cnt = 1;
        int ps = cList.get(0).start;
        int pe = cList.get(0).end;

        for(int i = 1; i < cList.size(); i++){
            Class next = cList.get(i);
            if(next.start >= pe){
                if(ps == next.start && pe == next.end) continue;

                ps = next.start;
                pe = next.end;
                cnt++;
            }
            else if(next.end < pe){ // 시작시간은 더 긴데, 끝나는 시간이 더 짧을 경우 업데이트
                pe = next.end;
                ps = next.start;
            }
        }

        System.out.println(cnt);

    }


}

