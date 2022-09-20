package 기본;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class EOF_10591 {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        String line = br.readLine();
	        int pos, a, b = 0;
	        
//	        입력 횟수가 주어지지 않고 입력만 들어올 때, 무한 입력일 때 EOF 사용(입력 자체가 파일일 경우 input != null만으로도 충분)
//	        InuputStreamRead(System.in)은 Ctrl + z(콘솔)(+Enter 커맨드라인)를 입력하면 종료하는 것으로 인식하고 null 리턴하고
//	        BufferedReader 또한 System.in을 통해 입력을 받기 때문에 readLine()은 null을 리턴한다. 
	        while(line != null){	// EOF handling 
	            pos = line.indexOf(" ");
	            a = Integer.parseInt(line.substring(0,pos));
	            b = Integer.parseInt(line.substring(pos+1));
	            
	            bw.write(Integer.toString(a+b)); // String.valueOf(int형) 과 같음 
	            bw.newLine();
	            
	            line = br.readLine();
	        }
	        bw.flush();
	       
	}
}
/*
*  Scanner같은 경우 sc.hasNext() 메소드가 있음. 입력된 토큰이 있으면 true 없으면 false
*  
*  BufferedReader는 EOF를 처리하는 내장 함수가 없다.
*  
*  그래서
*  	String input = "";
*   
*  	while((input = br.readLine()) != null){
*  
*  	}
*  	혹은 
*  
*  	while(br.reaLine() != null){
*  	
*  	}
*  이런 식으로 처리, br.readLine()으로 계속 읽되, 입력한 값이 null이 되면 반복문을 종료
*  readLine() : 만약 stream의 끝에 다다르면(EOF) null 값을 반환한다. 아무것도 입력 안하면 null 반환 
*  			아무것도 입력을 받지 않는 것은 콘솔 Ctrl + z / 커맨드랑ㄴ Ctrl + z + Enter이다.
*  			System.in은 키 입력을 종료하는 것으로 인식하고 null을 반환한다.
*  			
*/