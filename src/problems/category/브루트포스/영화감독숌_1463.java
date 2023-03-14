package problems.category.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌_1463 {
	static int check(int N) {
		int cnt = 1;
		int digit = 0;
		int num  = 0;
		
		// 10000일 떄 최대 7자리겠네
		while(true) {
			// 최대,최소 자리수부터 확인해서 범위를 알면, 큰 틀부터 정해보자
			// ABCD666
			// 큰 범위부터 if문 안그러면  % 10일 때로 다 들어감
			// ABC == 666n / ABCD ==6666nnn, 1666nnn 겹친다. 7자리 667nnnn
			if(((digit % 10000) / 10 == 666) && (digit % 10 != 6)) {
				num = 0;
				for(int i = 0; i < 1000; i++) {
					if(cnt == N) {
						return digit * 1000 + num; 
					}
					num++;
					cnt++;
				}
				//ex) 6661 + 1 = 6662 나머지 3자리 ㅇㅋㅇㅋ
				digit++;
			}
			// BCD == 666, 6자리
			else if(digit % 1000 == 666) {
				num = 0;
				for(int i = 0; i < 1000; i++) {
					if(cnt == N) {
						return digit * 1000 + num; 
					}
					num++;
					cnt++;
				}
				digit++;
			}
			// CD == 66, 5자리
			else if(digit % 100 == 66) {
				num = 600;
				for(int i = 0; i < 100; i++) {
					if(cnt == N) {
						return digit * 1000 + num; 
					}
					num++;
					cnt++;
				}
				digit++;				
			}
			// D == 6, 4자리
			else if(digit % 10 == 6) {
				num = 660;
				for(int i = 0; i < 10; i++) {
					if(cnt == N) {
						return digit * 1000 + num; 
					}
					num++;
					cnt++;
				}
				digit++;
			}

			// 666이 아닐 때
			else {
				num = 666;
				if(cnt == N) {
					return digit * 1000 + num;
				}
				digit++;
				cnt++;
			}
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(check(N));
	}
}

/*
	1 ~ 10 번쨰

1 : 0666
2 : 1666
3 : 2666
4 : 3666	6개
5 : 4666
6 : 5666 -------------------
7 : 6660
8 : 6661
9 : 6662
10 : 6663	6개
11 : 6664
12 : 6665
13 : 6666 	1개 ------------------
14 : 6667
15 : 6668	3개
16 : 6669
17 : 7666 -------------------
18 : 8666	3개
19 : 9666

--> 10개

0666 ~ 9666 까지 총 19개

19개의 배수로 바뀐다??



11 : 10666
12 : 11666
13 : 12666
14 : 13666	6개
15 : 14666
16 : 15666
16660
16661
16662	6개
16663
16664
16665
17 : 16666	1개
16667
16668	3개
16669

18 : 17666
19 : 18666	3개
20 : 19666

---> 10개

10666 ~ 19666 까지 총 19개

20666 ~ 29666 꺄지 총 19개

...

1 : 60666\
2 : 61666
3 : 62666
4 : 63666	6개
5 : 64666
6 : 65666
66660
66661
66662
66663	6개
66664
66665
7 : 66666	1개
66667
66668	3개
66669
66670 ~ 66679 : 10개
66680 ~ 66689 : 10개		30개
66690 ~ 66699 : 10개
8 : 67666
9 : 68666	3개
10 : 69666

만약 자릿수가 5개를 넘어간다면
*/