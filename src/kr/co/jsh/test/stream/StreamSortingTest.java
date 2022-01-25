package kr.co.jsh.test.stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author 전상훈
 * 스트림 정렬방법
 * 
 * 이중콜론(::) 연산자를 이용하여 sorting을 간소화하여 표현할 수 있음
 *
 */
public class StreamSortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//일반적인 Stream
		Stream<String> strStream01 = Stream.of("b","c","a");
		strStream01.forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//일반적인 sorting 방법
		Stream<String> strStream02 = Stream.of("b","c","a");
		strStream02.sorted().forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//파라미터 비교 sorting 방법
		Stream<String> strStream03 = Stream.of("b","c","a");
		strStream03.sorted((a,b) -> a.compareTo(b)).forEach(i -> System.out.print(i+" "));
		System.out.println();

		//([인스턴스]::[메소드명 or new연산자]) - ::(이중콜론 연산자) sorting 방법
		Stream<String> strStream04 = Stream.of("b","c","a");
		strStream04.sorted(String::compareTo).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//Comparator인터페이스로 순서 거꾸로 나열하기
		Stream<String> strStream05 = Stream.of("b","c","a");
		strStream05.sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//알파벳 케이스별로 정렬
		Stream<String> strStream06 = Stream.of("b","c","a", "A", "B");
		strStream06.sorted().forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//알파벳 케이스와 상관없이 정렬
		Stream<String> strStream07 = Stream.of("b","c","A", "a", "B"); // 같은 알파벳(A,a)이면 먼저 나열된 순서대로(A,a순서대로) 값이 정렬된다.
		strStream07.sorted(String.CASE_INSENSITIVE_ORDER).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//알파벳 케이스와 상관없이 거꾸로 정렬
		Stream<String> strStream08 = Stream.of("b","c","A", "a", "B");
		strStream08.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//알파벳 길이순으로(짧->긴) 정렬 ::(이중콜론)연산자 이용하여 길이별로 정렬 ([인스턴스]::[메소드 or new연산자])
		Stream<String> strStream09 = Stream.of("b","cC","Aaa", "ab", "B"); 
		strStream09.sorted(Comparator.comparing(String::length)).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//알파벳 길이순으로(짧->긴) 정렬
		Stream<String> strStream10 = Stream.of("b","cC","Aaa", "ab", "B"); 
		strStream10.sorted(Comparator.comparing(i -> i.length())).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		//알파벳 역길이순으로(긴->짧) 정렬
		Stream<String> strStream11 = Stream.of("b","cC","Aaa", "ab", "B"); 
		strStream11.sorted(Comparator.comparing(String::length).reversed()).forEach(i -> System.out.print(i+" "));
		System.out.println();
		
	}

}
