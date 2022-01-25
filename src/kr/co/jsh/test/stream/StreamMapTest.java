package kr.co.jsh.test.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author 전상훈
 * 
 * map()를 사용해서 stream 데이터를 조작해보자
 *
 */
public class StreamMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//map으로 +1하기
		Stream<Integer> mapStream01 = Stream.of(3,4,5);
		mapStream01.map(i -> i+1).forEach(i -> System.out.print(i+" ")); //원래의 데이터에서 +1을 하고 출력하겠다는 의미
		System.out.println();

		//map으로 true/false 체크하기
		Stream<Boolean> mapStream02 = Stream.of(3,4,5).map(i -> i<5);
		mapStream02.forEach(i -> System.out.print(i+" ")); // 데이터 값들이 5보다 작은지 체크한 결과값을 출력하겠다는 의미
		System.out.println();
		
		//map으로 true/false 체크하기
		Stream<Boolean> mapStream03 = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft").map(i -> i.equals("Kakao"));
		mapStream03.forEach(i -> System.out.print(i+" ")); // 데이터 값들 중 "Kakao"가 있는지 체크
		System.out.println();
		
		//flatMap으로 다차원배열 값들 꺼내서 하나로 나열하기
		String[][] multipleArray = new String[][] {{"Kakao", "Naver", "Line"}, {"Google", "Microsoft"}};
		Stream<String> mapStream04 = Stream.of(multipleArray).flatMap(arr -> Arrays.stream(arr));
		mapStream04.forEach(i -> System.out.print(i+" ")); // 다차원 배열에 있는 배열들을 꺼내서 하나의 리스트로 전부 출력하기
		System.out.println();
		
		//2개의 스트림 합치기
		Stream<String> mapStream05 = Stream.of("Kakao", "Naver", "Line");
		Stream<String> mapStream06 = Stream.of("Google", "Microsoft");
		Stream<String> concatStream = Stream.concat(mapStream05, mapStream06);
		concatStream.forEach(i -> System.out.print(i+" ")); // 2개의 스트림을 합친 스트림을 모조리 출력하기
		System.out.println();
		
		//메소드체이닝을 이용한 스트림
		Stream<String> mapStream07 = Stream.of("Naver", "Kakao", "", "Naver", "Line", "Kakao", "Google", "", "Microsoft");
		mapStream07
				.distinct()
				.filter(i -> !i.isEmpty())
				.sorted((a,b) -> a.compareTo(b))
				.forEach(i -> System.out.print(i+" ")); // 중복을 제거하고, 빈값을 제거하고, 오름차순으로 정렬한 뒤 출력하기
		System.out.println();
		
	}

}
