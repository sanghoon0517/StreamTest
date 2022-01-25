package kr.co.jsh.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 전상훈
 * 
 * 스트림은 한번 쓰고나면 메모리에서 사라지게된다.
 * 따라서 호출을 한 번 하게 되면,
 * 또다시 호출하기 위해서는 객체를 다시 생성해야 한다.
 *
 */
public class StreamTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> strList01 = new ArrayList<String>();
		strList01.add("반도체");
		strList01.add("가전제품");
		strList01.add("휴대폰");
		strList01.add("자동차");
		
		//sorted()로 오름차순으로 글자들을 정렬
		//forEach()로 for문을 돌림
		//람다식으로 소스코드 간소화
		strList01.stream().sorted().forEach(i -> System.out.print(i+" "));
		System.out.println();
		//-------------------------------------------------------------------
		Stream<String> streamList01 = strList01.stream();
		streamList01.sorted().forEach(i->System.out.print(i+" "));
		System.out.println();
		//-------------------------------------------------------------------
		String[] strArray = new String[] {"Alpha", "Bravo", "Charlie", "Delta"};
		List<String> cvtStrList = Arrays.asList(strArray);
		cvtStrList.stream().forEach(i -> System.out.print(i+" "));
		System.out.println();
		//-------------------------------------------------------------------
		Stream<String> cvtStream = Arrays.stream(strArray);
		cvtStream.forEach(i -> System.out.print(i+" "));
		System.out.println();
		//-------------------------------------------------------------------
		//이미 사용한 경우 에러가 난다.
		try {
			cvtStream.forEach(i -> System.out.print(i+" "));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("삐이잉--- 이미 사용한 스트림입니다. 스트림은 재사용이 불가능합니다. 사용하실 스트림을 재생성하세요.");
		}
		//-------------------------------------------------------------------
		//인덱스 잘라서 사용
		//stream(리스트, 시작인덱스, 자를 인덱스)
		Stream<String> cvtStream2 = Arrays.stream(strArray,1,3); //인덱스 1부터 인덱스 3 전까지 자르겠다.
		cvtStream2.forEach(i -> System.out.print(i+" "));
		System.out.println();
		//------------------------------------------------------------------
		//Stream 클래스 사용
		Stream<String> cvtStream3 = Stream.of(strArray);
		cvtStream3.forEach(i -> System.out.print(i+" "));
		System.out.println();
		//
		//Stream 클래스 사용
		Stream<String> cvtStream4 = Stream.of("Samsung", "Kakao", "Naver", "Line");
		cvtStream4.forEach(i -> System.out.print(i+" "));
		System.out.println();

		System.out.println("================================================================");
		//IntStream 사용
		IntStream intStream = IntStream.range(1, 8); //1부터 8전까지
		intStream.forEach(i -> System.out.print(i+" "));
		System.out.println();
		//--------------------------------------------------------------------
		//IntStream 사용
		IntStream intStream2 = new Random().ints();
		intStream2.limit(5).forEach(i -> System.out.print(i+" ")); //랜덤숫자 5개
		System.out.println();
		//--------------------------------------------------------------------
		IntStream intStream3 = new Random().ints(3); //랜덤숫자 3개
		intStream3.forEach(i -> System.out.print(i+" "));
		System.out.println();
		System.out.println("================================================================");
		//--------------------------------------------------------------------
		//DoubleStream
		DoubleStream doubleStream1 = new Random().doubles();
		doubleStream1.limit(5).forEach(i -> System.out.print(i+" ")); //랜덤숫자 5개
		System.out.println();
		//--------------------------------------------------------------------
		DoubleStream doubleStream2 = new Random().doubles(3);
		doubleStream2.forEach(i -> System.out.print(i+" "));
		System.out.println();
		System.out.println("================================================================");
		//--------------------------------------------------------------------
		//DoubleArray DoubleStream
		Double[] arrayDouble = new Double[] {0.31, 0.32, 0.33, 0.34, 0.35};
		Stream<Double> doubleStream3  = Arrays.stream(arrayDouble);
		doubleStream3.forEach(i -> System.out.print(i+" "));
		System.out.println();
		//--------------------------------------------------------------------
		Stream<String> generateString1 = Stream.generate(() -> "스트림테스트");
		generateString1.limit(3).forEach(i -> System.out.print(i+" "));
		System.out.println();
		//--------------------------------------------------------------------
		Stream<Double> generateDouble1 = Stream.generate(() -> Math.random()*10);
		generateDouble1.limit(3).forEach(i -> System.out.println(i+" "));
		System.out.println();
		//--------------------------------------------------------------------
		//위의 double방식과 같은 문법
		Stream<Double> generateDoubleAnothorGrammer = Stream.generate(Math::random);
		generateDoubleAnothorGrammer.limit(3).forEach(i -> System.out.println(i+" "));
		System.out.println();
		//--------------------------------------------------------------------
		System.out.println("==========================iterate연습===========================");
		//iterate방식 - Integer
		Stream<Integer> iterateStream1 = Stream.iterate(1, i -> i+3);
		iterateStream1.limit(5).forEach(i -> System.out.print(i+" "));
		System.out.println();
		//--------------------------------------------------------------------
		//iterate방식 - double
		Stream<Double> iterateStream2 = Stream.iterate(1.0, i -> i+0.2);
		iterateStream2.limit(5).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		

		

	}

}
