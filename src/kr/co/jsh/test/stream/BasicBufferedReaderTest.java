package kr.co.jsh.test.stream;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author 전상훈
 * 
 * BufferedReader의 동작 방식을 알아보자.
 * 
 * 1. 입력과 출력의 버퍼의 크기를 맞춘다. ex) 입력 3칸이면 출력 3칸
 * 2. 버퍼가 가득차면 자동으로 전송된다. (자동으로 전송되는 조건은 출력하는 쪽의 버퍼가 비워져있어야 한다.)
 * 3. 전송된 후 버퍼가 비워지고, 그 자리에 나머지 데이터가 갱신된다.
 */
public class BasicBufferedReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = System.in; // 키보드로 입력.
		InputStreamReader isr = new InputStreamReader(is); //아스키코드값을 부호화해줌 ex) 65 -> A
		BufferedReader br = new BufferedReader(isr); // 버퍼로 읽어드림
		
		try {
			String data = br.readLine();
			System.out.println(data);
		} catch(Exception e) {
			
		}

	}

}
