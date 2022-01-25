package kr.co.jsh.test.stream;

import java.util.stream.Stream;

/**
 * @author 전상훈
 * 
 * Stream 클래스의 필터로 데이터들을 걸러내보자
 *
 */
public class StreamFilterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 첫문자열로 필터링
		Stream<String> strStream01 = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft");
		strStream01.filter(i -> !i.startsWith("L")).forEach(i -> System.out.print(i+" ")); //L로 시작하는 문자 외에 것들만 출력하겠다는 의미
		System.out.println();

		// 동일문자열로 필터링
		Stream<String> strStream02 = Stream.of("휴가", "병가", "출근", "결근");
		strStream02.filter(i -> !i.equals("출근")).forEach(i -> System.out.print(i+" ")); //출근 문자열 외의 것들만 출력하겠다는 의미
		System.out.println();
		
		// 문자열 길이로 필터링
		Stream<String> strStream03 = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft");
		strStream03.filter(i -> i.length() < 6).forEach(i -> System.out.print(i+" ")); //문자열 길이가 6미만인 것들만 출력하겠다는 의미
		System.out.println();
		
		// 빈값 필터링
		Stream<String> strStream04 = Stream.of("Kakao", "Naver", "", "Line", "Google", "Microsoft", "");
		strStream04.filter(i -> !i.isEmpty()).forEach(i -> System.out.print(i+" ")); //빈값들 외의 것들만 출력하겠다는 의미
		System.out.println();
		
		// 중복값 필터링
		Stream<String> strStream05 = Stream.of("Kakao", "Naver", "Google", "Line", "Google", "Microsoft", "Naver");
		strStream05.distinct().forEach(i -> System.out.print(i+" ")); //중복값은 제거하고 출력하겠다는 의미
		System.out.println();
		
		// 요소 제한
		Stream<String> strStream06 = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft");
		strStream06.limit(3).forEach(i -> System.out.print(i+" ")); //스트림 요소가 몇개든지 3개까지만 출력하겠다는 의미
		System.out.println();
		
		// 요소 skip
		Stream<String> strStream07 = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft");
		strStream07.skip(3).forEach(i -> System.out.print(i+" ")); //3개까지 무시하고 그 이후 값들부터 출력하겠다는 의미
		System.out.println();
		
	}

}
