package parseEng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class ParseEng {
	
	public WordGame wordgame = new WordGame();
	public VocaMeaning vm = new VocaMeaning();
	public static Scanner sc = new Scanner(System.in);
	// 단어를 필드 값으로 갖는 객체가 있어야 함.

	public void start() {
		System.out.println("=====================================================");
		System.out.println("                       Welcome");
		
		
		//메뉴 만들기 
		int menuNum;
		
		do {
			System.out.println("=====================================================");
			System.out.println("1. parseEng | 2. WordGame | 3. 단어 뜻 입력 | 4. 프로그램 종료");
			System.out.println("=====================================================");
			System.out.println("원하시는 메뉴번호를 입력하세요.\n>");
			menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				//System.out.println("제목을 입력하세요.\n>");
				//article.title = sc.nextLine(); // 스페이스가 아닌 엔터친 부분까지 받을 것
				Article.articleMap.put("firstArticle", "첫번째기사");
				Article.articleMap.put("SecondArticle", "두번째기사");	
				Article.articleMap.put("ThirdArticle", "세번쨰기사");
				
				//System.out.println("내용을 입력하세요.");
				// article.contents = sc.nextLine(); // 스페이스가 아닌 엔터친 부분까지 받을 것, 공백이 있어도 하나의 변수여야 함.
				trim("JALALABAD, Afghanistan — Eleven members of the Mirza Gul family, 10 of them children, "
						+ "gathered around an unfamiliar object on the ground outside their home. It was 6 a.m. "
						+ "on April 29, and the night before, the Taliban had fought Afghan soldiers nearby.Two "
						+ "of the smaller children picked the object up, and 16-year-old Jalil then realized that "
						+ "it was dangerous: an unexploded rocket from the battle. He tried to wrest it away from "
						+ "them, but in the tussle, it fell and exploded.It was a cruel day, even by the standards "
						+ "of Afghanistan’s long war.By nightfall, four were dead, including Jalil, who had tried "
						+ "to save them all and died at a hospital that night. One 4-year-old girl, Marwa, lost both "
						+ "her twin sister, Safwa, and their mother, Brekhna, who had been nearby making dung cakes "
						+ "for fuel. One of Brekhna’s nieces, a 6-year-old, was also killed in the blast.Seven survivors "
						+ "— three brothers and four of their first cousins — were left to bear the weight of those "
						+ "losses, and more: Every one of them lost a leg, and two lost both.Through the next two days, "
						+ "doctors at the Nangarhar Regional Hospital in Jalalabad worked around the clock trying to "
						+ "repair mangled limbs, then sometimes amputated them, after finding they could not be saved.");
					
			} else if (menuNum == 2) {
				
				wordgame.wordgame();
				
			} else if (menuNum == 3) {
				
				vm.voca();
				
			}
		} while(menuNum != 4);
			System.out.println("**************** 프로그램이 종료되었습니다. ******************");
			sc.close();
	}	
		

	// Map<String, Integer> map = new HashMap<String, Integer>();
	
	public void trim(String contents) {
		// split 전에 replace
		// String replacedContents = contents.replace(",", " ");
		// String replacedContents2 = replacedContents.replace(".", " ");
		// String replacedContents3 = replacedContents2.replace("—", " ");
		// String replacedContents4 = replacedContents3.replace(":", " ");
		String temp = contents;

		contents = contents.replace(",", " ");
		contents = contents.replace(".", " ");
		contents = contents.replace("—", " ");
		contents = contents.replace(":", " ");

		for (int i = 0; i < contents.length(); i++) { // [Q]
			contents = contents.replace("  ", " ");
		}
		
		parseEng(contents);
	}
	
	public static ArrayList<Word> wordList = new ArrayList<Word>();
	public void parseEng(String contents) {
		String[] split = contents.split(" "); // split 통해서 공백 기준으로 문자열을 구분해 배열에 담음
		
		for (int i = 0; i < split.length; i++) { // [Update] 추가기능 : 's 구분을 추후에 삽입			
			split[i] = split[i].toLowerCase();   // 모두 소문자로 만들어 String 타입의 변수 LowerCaseContends에 담음.
		}
		
		List<String> list = new ArrayList<String>();	// Split 배열을 복사할 list 선언
		
		for(int i=0;i<split.length;i++) {	// 배열을 리스트에 복사
			list.add(split[i]);				// [Update]clone으로 가능? 
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();   //Map 생성Key값이 단어 , Value값이 단어의 횟수

		// Map에 Array 복사
		for (int i = 0; i < split.length; i++) {
			int count = Collections.frequency(list, split[i]); //횟수를 구하는 method
			map.put(split[i], count);
		}
		
		Set<String> keySet = map.keySet(); // Returns a Set view of the keys contained in this map
		Iterator<String> keyIterator = keySet.iterator(); // Iterator로 출력
		
//		ArrayList<Word> wordList = new ArrayList<Word>(); // Word 클래스 타입의 리스트 wordList 생성
		Word[] word = new Word[map.size()];	//Word 클래스 타입의 배열
		
		int i=0; //아래 while문 안 word[i]에 다른값을 불러오기 위해 변수 설정 후 while안에서 카운트 올림 
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			int value = map.get(key);
			word[i] = new Word(key, value);
			wordList.add(word[i]);
			i++;
		}	
		
		Collections.sort(wordList, new Comparator<Word>() { // wordList 인스턴스를 wordcount로 정렬
			
			@Override // 왜 오버라이딩을 이렇게 했는가.
			public int compare(Word word1, Word word2) {
				if(word1.wordcount > word2.wordcount) {
					return -1;
				} else if (word1.wordcount < word2.wordcount) {
					return 1;
				} else { 
					return 0;
				}
			}
		});
		
		
		
		for(int j=0; j<wordList.size(); j++) { // 정렬된 wordList를 차례로 출력
			System.out.println(wordList.get(j).wordname + " : " + wordList.get(j).wordcount );
		} 
		
		
		
	}
}
