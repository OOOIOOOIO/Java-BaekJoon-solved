package problems.category.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식_1918 {

    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] calculation = br.readLine().toCharArray();

        // 문자개수만큼
        for(int i = 0; i < calculation.length; i++) {
            // 연산식이 숫자라면 그대로 문자열에 담아준다.
            if (calculation[i] >= 'A' && calculation[i] <= 'Z') sb.append(calculation[i] + "");
            else { //연산식이 숫자가 아니라면

                if (calculation[i] == '(') stack.push(calculation[i]);

                else if (calculation[i] == ')') { //'('이 나올때까지 문자열에 담아준다.
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop()); //괄호가 아니면 연산자를 꺼내어 문자열에 담는다.
                    }

                    if (!stack.isEmpty()) stack.pop(); //'('연산자를 꺼내준다.
                }

                else { // + - / * 연산자 일경우
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(calculation[i])) {
                        sb.append(stack.pop());
                    }
                    stack.push(calculation[i]); // 처음 혹은 비교하고 더 작을 때 혹은 ( 일 때
                }
            }

        }


        while (!stack.empty()) sb.append(stack.pop());
        System.out.println(sb);

    }

    static int priority(char curr){
        if(curr == '*' || curr == '/') return 2;
        else if(curr == '+' || curr == '-') return 1;
        else return 0; //스택 안에는 '('도 들어올 수 있다. 하지만 '('는 꺼내져서는 안되기 때문에 제일 낮은 값을 반환하도록 한다.

    }


}
