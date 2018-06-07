package parseEng;

import java.util.*;
//타자게임기능 클래스
public class WordGame {

	Scanner sc = new Scanner(System.in);
	
	int random;
	int correctCount;
	int wrongCount;

	
	//워드게임 메소드 생성
	public void wordgame() {
		
		//반복문으로 10문제 만들기
		System.out.println();
		for(int i=1; i<=10; i++) {
			
			// 기사내용 공백구분으로 리스 배열에 담은 데이터 Article클래스를 상속받아 꺼내오기.
			random = (int)(Math.random()*ParseEng.wordList.size());
			String words = ParseEng.wordList.get(random).wordname;
			System.out.println(i+"번 문제 : "+ParseEng.wordList.get(random).wordname);
			System.out.println(">");
			
			//꺼내온 단어로 입력게임시작
			String inputword = sc.nextLine();
			
			if (inputword.equals(words)) {
				System.out.println("맞았다");
				correctCount++;
			} else {
				System.out.println("틀렸다");
				wrongCount++;
			}

		}
		
		System.out.println("맞은갯수 : " + correctCount);
		System.out.println("틀린갯수 : " + wrongCount);
		
	}
	
	
}

