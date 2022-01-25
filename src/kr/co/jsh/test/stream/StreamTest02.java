package kr.co.jsh.test.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub"
		Stream<String> strStream1 = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft");
		strStream1.forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//Stream 단어 필터링- 특정규칙의 단어를 제외시킴
		Stream<String> strStream2 = Stream.of("Kakao", "Naver", "", "LG", "Google", "Line");
		strStream2.filter(i -> !i.isEmpty()).filter(i->!i.startsWith("L")).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//String배열 Stream 단어중복 허용
		String[] strArray01 = new String[] {"Language", "Math", "Science", "Math", "Science"};
		Stream<String> strStream3 = Arrays.stream(strArray01);
		strStream3.forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//String배열 Stream 단어중복 X
		Stream<String> strStream4 = Arrays.stream(strArray01).distinct(); //distinct()메소드로 단어 중복제거
		strStream4.forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//Integer 숫자 정렬 sorted()메소드
		Stream<Integer> intStream3 = Stream.of(5,3,6,9,1);
		intStream3.sorted().forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//String 문자 정렬 sorted()메소드
		Stream<String> strStream5 = Stream.of("나","라","하","가","마");
		strStream5.sorted().forEach(i -> System.out.print(i+" "));
		System.out.println();
		

	}

}
