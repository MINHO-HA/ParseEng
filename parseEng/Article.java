package parseEng;

import java.util.ArrayList;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;


public class Article {

	// 각 장문의 제목을 담는 String type 변수
	public String title; 

	// 장문 자체를 담는 String type 변수. contents에 담긴 문자열을 처리한 후에는 ArrayList<Word> type이 될 것.(ParseEng.java 참고)
	public String contents; 

	// 제목과 제목에 따른 분석 결과를 담을 정적변수 articleMap 선언
	public static TreeMap<String, ArrayList<Word>> articleMap = new TreeMap<String, ArrayList<Word>>(); 
	
	
	/****************************
	 * Article의 리스트를 출력하는 메소드*
	 ****************************/
	public static void articleList() {
		NavigableMap<String, ArrayList<Word>> descendingMap = articleMap.descendingMap();
		Set<Map.Entry<String, ArrayList<Word>>> descendingEntrySet = descendingMap.entrySet();
		int i=1;
		System.out.println("======== Aritcle List ========");
		for(Map.Entry<String, ArrayList<Word>> entry : descendingEntrySet) {
			System.out.println(i + ". title : " + entry.getKey());
			i++;
		}
		System.out.println();
	}
	
}
