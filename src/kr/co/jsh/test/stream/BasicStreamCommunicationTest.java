package kr.co.jsh.test.stream;

import java.io.InputStream;

/**
 * @author 전상훈
 * 
 * 자바 Stream이 동작하는 원리를 자세하게 알아보자.
 *
 */
public class BasicStreamCommunicationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = System.in; // System.in : 키보드를 통해 값을 입력한다는 의미
		
		//컴파일 에러
		
		// 1. 키보드에서 입력한 문자 'A'를 컴퓨터가 이해할 수 있도록 2진법 01000001로 인코딩하여 컴퓨터에게 전송
		// 2. 컴퓨터로부터 받은 값을 자바가 ByteStream을 통해 is객체에 값이 흘러들어간다.
		// 3. read()메서드를 통해 '01000001'값을 사람이 이해할 수 있도록 10진법인 '65'로 디코딩해준다.
		// 4. 65라는 10진법의 숫자를 부호화하여 다시 'A'라는 문자로 돌려놓는다.
		try {
			int data = is.read();
			System.out.println(data);
			System.out.println((char)data);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
