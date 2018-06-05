package parseEng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class ParseEng extends Article {

	public static Scanner sc = new Scanner(System.in);
	// 단어를 필드 값으로 갖는 객체가 있어야 함.

	public void start() {
		System.out.println("제목을 입력하세요.");
		title = sc.nextLine(); // 스페이스가 아닌 엔터친 부분까지 받을 것

		System.out.println("내용을 입력하세요.");
		// contents = sc.nextLine(); // 스페이스가 아닌 엔터친 부분까지 받을 것, 공백이 있어도 하나의 변수여야 함.
		parseEng("JALALABAD, Afghanistan — Eleven members of the Mirza Gul family, 10 of them children, "
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
	}

	public void parseEng(String contents) {
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

		for (int i = 0; i < contents.length(); i++) {
			contents = contents.replace("  ", " ");
		}

		// 변경전에 split
		String[] split = contents.split(" ");
		
		for (int i = 0; i < split.length; i++) {
																			// Lowercase로 변경.(추가기능 : 's 구분을 추후에 삽입) >> 다형이가 작성한 가이드
			split[i] = split[i].toLowerCase(); 								// String 타입의 Lowercase 매개변수에 스캐너로 입력받을 내용(문장) contents 대입.
																		 	// 모두 소문자로 만들어 String 타입의 변수 LowerCaseContends에 담음.
		}																	// 대입된 내용(Lowercase) 매개변수를 내재되어있는 메소드 (toLowerCase)를 이용하여
																			// 소문자로 만드는 이유는 컴퓨터는 대소문자를 다른문자열로 인식할 가능성이 있기 때문에
																			// 사전작업으로 소문자로 통일시킴....
																			// System.out.print(LowercaseContents); //확인차 LowercaseContends 매개변수 프린트아웃해봤고
																			// 이상없이 소문자로 바뀜..

																			// ..실제 기사 복사해와 실행해보니 문단이 바뀔때는 인식못하는 문제를 발생시킴...
																			// LowerCase method에서 기사를 가져오면 문단이 인식안되는 문제를 해결하기 위해
																			// trim method사용을 시도하였지만 문자열a 와 문자열b의 공백(띄어쓰기)은 줄여주지만
																			// 문자열a안의 공백(띄어쓰기)는 없애주기 못하는 것을 발견..(trim method 사용불가)
																			// 다른 방법 고안해야됨

		// 만든 배열(split) 리스트에 담기 (이유는? 동일한 문자열 쓰인 횟수 찾는 collections.frequency 함수 쓰기위해서..
		// Split 배열을 복사할 list 선언
		List<String> list = new ArrayList<String>();
		
		// 배열을 리스트에 복사
		for(int i=0;i<split.length;i++) {
			list.add(split[i]);
		}
		
		// Map 생성
		Map<String, Integer> map = new HashMap<String, Integer>();   //Key값이 단어 , Value값이 단어의 횟수

		// Map에 Array 복사
		for (int i = 0; i < split.length; i++) {
			int count = Collections.frequency(list, split[i]); //횟수를 구하는 method
			map.put(split[i], count);
		}

		// Iterator로 출력
		Set<String> keySet = map.keySet(); // Returns a Set view of the keys contained in this map
		Iterator<String> keyIterator = keySet.iterator();
		
		//Word클래스 타입의 리스트 wordList
		ArrayList<Word> wordList = new ArrayList<Word>(); //
		
		//Word 클래스 타입의 배열
		Word[] word = new Word[map.size()];
		
		int i=0; //아래 while문 안 word[i]에 다른값을 불러오기 위해 변수 설정 후 while안에서 카운트 올림 
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			int value = map.get(key);
			word[i] = new Word(key, value);
			wordList.add(word[i]);
			i++;
		}	
		
		Collections.sort(wordList, new Comparator<Word>() {
			
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
		
		for(int j=0; j<wordList.size(); j++) {
			System.out.println(wordList.get(j).wordname + " : " + wordList.get(j).wordcount );
		}
		
	}
		
}
