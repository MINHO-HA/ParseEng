package parseScript;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
//타자게임기능 클래스
public class WordGame {

	Scanner sc = new Scanner(System.in);
	
	public int random;
	public int correctCount;
	public int wrongCount;

	
	//워드게임 메소드 생성
	public void wordgame() {
		// 저장한 Article의 title 리스트 출력
		Article.articleList();
		
		System.out.println("원하시는 title을 입력해주세요.\n>");
		String choice = ParseScript.sc.next(); // 입력 값을 key 값으로 받기위한 변수
		
		
		//반복문으로 10문제 만들기
		System.out.println();
		for(int i=1; i<=10; i++) {
			
			// 기사내용 공백구분으로 리스 배열에 담은 데이터 Article클래스를 상속받아 꺼내오기.
			ArrayList<Word> thisWordList = Article.articleMap.get(choice);
			random = (int)(Math.random()*thisWordList.size());
			String words = thisWordList.get(random).wordname;
			System.out.println(i+"번 문제 : "+thisWordList.get(random).wordname);
			System.out.println(">");
			
			//꺼내온 단어로 입력게임시작
			String inputword = sc.nextLine();
			
			// 정오 판별하는 if문
			if (inputword.equals(words)) {
				System.out.println("맞았다");
				correctCount++;
			} else {
				System.out.println("틀렸다");
				wrongCount++;
			}

		}
		
		// 맞은 갯수와 틀린 갯수 출력
		System.out.println("맞은갯수 : " + correctCount);
		System.out.println("틀린갯수 : " + wrongCount);
		
	}
	
	
}

