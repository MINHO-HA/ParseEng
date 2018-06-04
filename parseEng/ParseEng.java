package parseEng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseEng extends Article{
	
	public static Scanner sc = new Scanner(System.in);
	//단어를 필드 값으로 갖는 객체가 있어야 함.

	public void start() {
	    System.out.println("제목을 입력하세요.");
	    title = sc.nextLine(); // 스페이스가 아닌 엔터친 부분까지 받을 것

	    System.out.println("내용을 입력하세요.");
	    contents = sc.nextLine(); // 스페이스가 아닌 엔터친 부분까지 받을 것, 공백이 있어도 하나의 변수여야 함.
	    parseEng(contents);
	}

	public void  parseEng(String contents) {
		
	    // Lowercase로 변경.(추가기능 : 's 구분을 추후에 삽입) >> 다형이가 작성한 가이드
		String Lowercase = contents; //String 타입의 Lowercase 매개변수에 스캐너로 입력받을 내용(문장) contents 대입.
		String LowercaseContents = Lowercase.toLowerCase(); //대입된 내용(Lowercase) 매개변수를 내재되어있는 메소드 (toLowerCase)를 이용하여 
															//모두 소문자로 만들어 String 타입의 변수 LowerCaseContends에 담음.
															//소문자로 만드는 이유는 컴퓨터는 대소문자를 다른문자열로 인식할 가능성이 있기 때문에 
															//사전작업으로 소문자로 통일시킴....
		System.out.print(LowercaseContents);  			//확인차 LowercaseContends 매개변수 프린트아웃해봤고 이상없이 소문자로 바뀜..
		
														//실제 기사 복사해와 실행해보니 문단이 바뀔때는 인식못하는 문제를 발생시킴.....
														//LowerCase method에서 기사를 가져오면 문단이 인식안되는 문제를 해결하기 위해 
														//trim method사용을 시도하였지만 문자열a 와 문자열b의 공백(띄어쓰기)은 줄여주지만 
														//문자열a안의 공백(띄어쓰기)는 없애주기 못하는 것을 발견..(trim method 사용불가)
														//다른 방법 고안해야됨
		
		// content의 공백 기준으로 단어를 구분
		
		
	    List<String> word = new ArrayList<String>();
	    // ㄴ 구분된 단어를 ArrayList 타입의 word[i]에 담을 것 -> 객체 하나가 배열 하나. array[0]...
	    // ㄴ 중첩 for문으로 word[i]번과 word[j]이 동일한지 비교, 횟수를 int count 변수에 담아서 HashMap에 담기(key 단어, value가 횟수);
	    // ㄴ HashMap을 내림차순으로 출력
	} 
	
}
