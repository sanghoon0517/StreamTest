package kr.co.jsh.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 전상훈
 * 
 * 스트림의 개수와 최대값 최소값을 구해보자
 *
 */
public class StreamCountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//스트림의 요소의 개수
		long getCountNumber = Stream.of(5,3,6,2,1).count();
		System.out.println("스트림의 총 개수 : "+getCountNumber);
				
		//String요소도 세어짐. 공백까지도
		long getCountNumber2 = Stream.of("String", "Integer", "Long", "").count();
		System.out.println("스트림의 총 개수 : "+getCountNumber2);
		
		//Optional을 이용하여 max값 뽑기
		Optional<Integer> maxStream1 = Stream.of(3,6,1).max(Integer::compare);
		int integer = maxStream1.get(); //Integer int 둘 다 가능하네
		System.out.println("최대값 : "+integer);
		
		//Integer에 바로 담기(int도 가능)
		Integer integer2 = Stream.of(6,7,2).max(Integer::compare).get();
		System.out.println("최대값 : "+integer2);
		
		//Optional을 이용하여 min값 뽑기
		Optional<Integer> minStream1 = Stream.of(3,6,1).min(Integer::compare);
		int integer3 = minStream1.get(); //Integer int 둘 다 가능하네
		System.out.println("최대값 : "+integer3);
		
		//Optional에 필터적용해서 뽑기
		Optional<String> first = Stream.of("", "Kakao", "Naver", "Line", "Google", "Microsoft")
									.filter(i -> !i.isEmpty())
									.findFirst();
		System.out.println("빈값을 제외한 첫번째 값 : "+first.get());
		
		//Optional에 필터적용해서 뽑기2
		Optional<String> any = Stream.of("", "Kakao", "Naver", "Line", "Google", "Microsoft")
				.filter(i -> !i.isEmpty())
				.findAny();
		System.out.println("빈값을 제외한 첫번째 값 : "+any.get());
		
		//anyMatch메소드 이용하기
		boolean b = Stream.of("", "Kakao", "Naver", "Line", "Google", "Microsoft").anyMatch(i -> i.startsWith("K"));
		System.out.println(b);
		
		//allMatch메소드 이용하기
		//스트림 전체를 돌면서 앞문자를 확인하는 메소드
		boolean b2 = Stream.of("", "Kakao", "Naver", "Line", "Google", "Microsoft").allMatch(i -> i.startsWith("K"));
		System.out.println(b2);
		
		//allMatch메소드 이용하기(유용하게 쓰일듯?)
		//스트림 전체를 돌면서 앞문자를 확인하는 메소드
		boolean b3 = Stream.of("K", "Kakao", "KNaver", "KLine", "KGoogle", "KMicrosoft").allMatch(i -> i.startsWith("K"));
		System.out.println(b3);
		
		//noneMatch메소드 이용하기 : 하나라도 매치되는게 있다면 false, 하나도 매치안되면 true
		//스트림 전체를 돌면서 앞문자를 확인하는 메소드  
		boolean b4 = Stream.of("", "Kakao", "Naver", "Line", "Google", "Microsoft").noneMatch(i -> i.startsWith("O"));
		System.out.println(b4);
		
		//스트림을 String[]로 바꾸기
		String[] strings = Stream.of("Kakao", "Naver", "Line", "Google", "Microsoft").toArray(String[]::new);
		System.out.println("스트림 -> 스트링 배열 : "+Arrays.toString(strings));
		
		//reduce메소드 이용하기
		Integer sum = Stream.of(1,2,3).reduce(0, Integer::sum);
		System.out.println("초기값 0에 스트림을 더한 값 : "+sum);

		//reduce메소드 이용하기2
		Integer sum2 = Stream.of(1,2,3).reduce(3, Integer::sum);
		System.out.println("초기값 3에 스트림을 더한 값 : "+sum2);
		
		//reduce메소드 이용하기3
		Integer multiply = Stream.of(3,3,3).reduce(3, (x,y)->x*y);
		System.out.println("초기값 3에 스트림을 곱한 값 : "+multiply); //81 =3*3*3*3 
		
		//reduce메소드 이용하기4 (초기값x)
		Optional<Integer> sum3 = Stream.of(3,3,3).reduce(Integer::sum);
		System.out.println("초기값 없이 스트림을 더한 값 : "+sum3.get());  
		
		//reduce메소드를 이용하여 최대값 뽑기
		Optional<Integer> max = Stream.of(5,3,8).reduce(Integer::max);
		System.out.println("스트림 max값 : "+max.get());  
		
		//reduce메소드를 이용하여 최소값 뽑기
		Optional<Integer> min = Stream.of(5,3,8).reduce(Integer::min);
		System.out.println("스트림 min값 : "+min.get());
		
		System.out.println("=================================================================");
		
		//Collection Framework를 이용하여 스트림값을 Collection Framework 타입으로 변경해보자.
		String[] strArray = new String[] {"Kakao", "Naver", "Line", "Kakao", "Google", "Microsoft", "Kakao", "Naver"};
		
		//Set으로 변경
		Set<String> set = Stream.of(strArray).collect(Collectors.toSet());
		System.out.println(set);
		
		//List로 변경
		List<String> list = Stream.of(strArray).collect(Collectors.toList());
		System.out.println(list);
	}

}
