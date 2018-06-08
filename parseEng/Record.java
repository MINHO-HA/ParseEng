package parseEng;

import java.util.ArrayList;

public class Record {
	public static void recordOutput() {
		// 저장한 Article의 title 리스트 출력
		Article.articleList();
				
		System.out.println("원하시는 title의 제목을 입력해주세요.\n>");
		String choice = ParseEng.sc.next(); 
		
		
		ArrayList<Word> thisWordList = Article.articleMap.get(choice);
		System.out.println("====== 전체 리스트 ======");
		for(int i=0; i<thisWordList.size(); i++) {
			String word = thisWordList.get(i).wordname;
			int count = thisWordList.get(i).wordcount;
			System.out.println(i+"번째" + word + " : " + thisWordList.get(i).meaning + "("+count +"번)");
		}
		System.out.println("====== 전체 리스트 끝 ======");
		System.out.println();
		
	}
}
