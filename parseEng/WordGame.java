package parseEng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
//타자게임기능 클래스
public class WordGame {

	Scanner sc = new Scanner(System.in);
	
	int random;
	int correctCount;
	int wrongCount;

	
	//워드게임 메소드 생성
	public void wordgame() {
		Set<String> keySet = Article.articleMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		String choice = iterator.next();
		
		
		//반복문으로 10문제 만들기
		System.out.println();
		for(int i=1; i<=10; i++) {
			
			// 기사내용 공백구분으로 리스 배열에 담은 데이터 Article클래스를 상속받아 꺼내오기.
			String key = choice;
			ArrayList<Word> thisWordList = Article.articleMap.get(key);
			random = (int)(Math.random()*thisWordList.size());
			String words = thisWordList.get(random).wordname;
			System.out.println(i+"번 문제 : "+thisWordList.get(random).wordname);
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

