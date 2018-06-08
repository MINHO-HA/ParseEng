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
	public static Scanner sc = new Scanner(System.in);
	
	public String title; // 제목을 입력 값으로 받기 위한 임시 변수 
	public WordGame wordgame = new WordGame(); // "WordGame" 메뉴를 불러오기 위한 객체 생성
	public VocaMeaning vocaMeaning = new VocaMeaning();	// "단어 뜻 입력" 메뉴를 불러오기 위한 객체 생성

	public void start() { // 시작 메소드
		System.out.println("=====================================================");
		System.out.println("                       Welcome");
		
		int menuNum = 0; // 메뉴 선택을 int 값으로 하기 위한 변수
		do {
			System.out.println("=====================================================");
			System.out.println("1. parseEng | 2. WordGame | 3. 단어 뜻 입력 | 4. 프로그램 종료");
			System.out.println("=====================================================");
			System.out.println("원하시는 메뉴번호를 입력하세요.\n>");
			menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				System.out.println("제목을 입력하세요.\n>");
				this.title = sc.next(); // 스페이스가 아닌 엔터친 부분까지 받을 것

				System.out.println("내용을 입력하세요.");
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
				vocaMeaning.vocaMeaningInput();
			}
		} while(menuNum != 4);
			System.out.println("**************** 프로그램이 종료되었습니다. ******************");
			sc.close();
	}

	
	/************************************
	 * 1. 장문으로 입력된 값의 전처리를 담당하는 메소드 *
	 ************************************/
	public void trim(String contents) {
		String temp = contents; // 입력 값을 임시로 담아두기 위한 변수
		
		// 입력 값에서 ",",".","-","—"인 특수 문자 제거
		contents = contents.replace(",", " ");
		contents = contents.replace(".", " ");
		contents = contents.replace("—", " ");
		contents = contents.replace(":", " ");
		
		// 입력 값에서 연속된 공백 제거(공백은 모두 하나의 공백문자가 됨)
		for (int i = 0; i < contents.length(); i++) { // [Q] 공백이 없을 때까지의 조건으로 While문 할 수는 없나?
			contents = contents.replace("  ", " ");
		}
		
		parseEng(contents); // 전처리를 한 입력 값의 분석 시작
	}

	
	/******************************
	 * 2. 전처리된 값의 분석을 담당하는 메소드 *
	 ******************************/
	public void parseEng(String contents) {
		// 1. split 통해서 공백 기준으로 문자열을 구분해 배열에 담음
		String[] split = contents.split(" "); 

		// 2. 배열의 모든 값을 소문자로 변환 
		for (int i = 0; i < split.length; i++) { // [Update] 추가기능 : 's 구분을 추후에 삽입			
			split[i] = split[i].toLowerCase();   // 모두 소문자로 만들어 String 타입의 변수 LowerCaseContends에 담음.
		}
		
		
		// 3-1. 공백 기준으로 쪼개어진 문자열을 담은 split 배열을, ArrayList로 복사 하기 위한 변수 선언
		List<String> list = new ArrayList<String>();	

		// 3-2. split 배열을 ArrayList에 복사
		for(int i=0;i<split.length;i++) {	
			list.add(split[i]);				// [Update]clone으로 가능? 
		}
		
		
		// 4-1. ArrayList를 HashMap으로 복사하기 위한 변수 선언 (key 값이 단어 , value값이 단어의 횟수)
		Map<String, Integer> map = new HashMap<String, Integer>();  

		// 4-2. HashMap에 ArrayList 복사
		for (int i = 0; i < split.length; i++) {
			int count = Collections.frequency(list, split[i]); //횟수를 구하는 method
			map.put(split[i], count);
		}
		
		// 5-1. HashMap의 검색을 위한 iterator 선언
		Set<String> keySet = map.keySet(); // Returns a Set view of the keys contained in this map
		Iterator<String> keyIterator = keySet.iterator(); // Iterator로 출력
		
		
		// 5-2. Word 클래스 타입의 리스트 wordList 생성
		ArrayList<Word> wordList = new ArrayList<Word>(); 
		// 5-2.  Word 클래스 타입의 배열
		Word[] word = new Word[map.size()];	
		
		int i=0; //  word 배열의 크기를 key값의 수만큼 지정하기 위한 변수 
		// 5-4. word[]을 값으로 가지는 wordList를 만들기
		while (keyIterator.hasNext()) {
			String key = keyIterator.next(); // map의 key는 단어
			int value = map.get(key); // map의 value는 횟수
			word[i] = new Word(key, value); // map의 key와 value를, word 클래스의 wordname과 wordCount로 받는 word 배열 생성 
			wordList.add(word[i]); // 생성된 word 클래스 타입 배열을 wordList의 값으로 만듦
			i++;
		}	
		
		
		// 5-5. wordList인스턴스의 각 값인 word클래스의 wordcount로 정렬
		Collections.sort(wordList, new Comparator<Word>() { 
			
			@Override // [Update] 왜 오버라이딩을 이렇게 했는가.
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
		
		
		// 6. 임시로 제목의 입력값을 받아둔 title과 방금 생성한 wordList를 매개로 하여, static변수 articleMap의 하나의 key-value 쌍을 입력
		Article.articleMap.put(this.title, wordList);
		ArrayList<Word> thisWordList = Article.articleMap.get(this.title);
		
		 // 7. 5-5에서 정렬된 wordList를 차례로 출력
		for(int j=0; j<thisWordList.size(); j++) {
			System.out.println(thisWordList.get(j).wordname + " : " + thisWordList.get(j).wordcount );
		} 
	}
	
}
