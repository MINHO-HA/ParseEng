package parseEng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class VocaMeaning {

	Scanner sc = new Scanner(System.in);
	Article article = new Article();

	int i=0;
	String wordListName = null;
	
	void voca() {
		
		int j=0;
		for(int i=0;i<Article.articleMap.size();i++) {
			Set keySet = Article.articleMap.keySet();
			Iterator<String> keyIterator = keySet.iterator();
			while(keyIterator.hasNext()) {
				j++;
				String key = keyIterator.next();
				String value = Article.articleMap.get(key);
				System.out.println(j+"번 : "+key);
			}
			
			
			System.out.println("원하시는 타이틀의 번호를 선택해주세요.\n>");
			int titleNum = sc.nextInt();
			
			if(titleNum == 1) {
				for (i=0;i<ParseEng.wordList.size();i++) {
					wordListName = ParseEng.wordList.get(i).wordname;
					System.out.println(i+1+"번 : "+ ParseEng.wordList.get(i).wordname);
					}
					
					//원하는 단어 번호 선택
					System.out.println("원하시는 단어의 번호를 선택해주세요.\n>");
					int wordNum = sc.nextInt();
					i = wordNum;
					
					//단어번호에 해당되는 단어 나오고 단어 뜻입력
					System.out.println(i+"번 단어 : "+wordListName);
					System.out.println("해당되는 단어의 뜻을 입력해주세요\n>");
					Word.meaning = sc.nextLine();
					
					ArrayList<Word> wordMeaning = new ArrayList<Word>();
					
					
					
					
					//선택한 단어와 입력한 뜻을 담는 배열 만들기
					/*ArrayList<Word> wordList = new ArrayList<Word>(); // Word 클래스 타입의 리스트 wordList 생성
					Word[] word = new Word[map.size()];	//Word 클래스 타입의 배열
					
					int i=0; //아래 while문 안 word[i]에 다른값을 불러오기 위해 변수 설정 후 while안에서 카운트 올림 
					while (keyIterator.hasNext()) {
						String key = keyIterator.next();
						int value = map.get(key);
						word[i] = new Word(key, value);
						wordList.add(word[i]);
						i++;
					}	*/
					
					
					//vocabulary.add(wordListName, meaning);
					
					/*// Map 생성
					Map<String, String> map = new HashMap<String, String>();
					
					//객체 저장
					map.put("ㅇ", "ㅇㅇ");
					
					//객체를 하나씩 처리
					Set<String> keySet = map.keySet();
					Iterator<String> keyIterator = keySet.iterator();
					while(keyIterator.hasNext()) {
						String key = keyIterator.next();
						String value = map.get(key);
						System.out.println(key+" : "+value);
					}*/
				}	
		}
	
	} 
}
