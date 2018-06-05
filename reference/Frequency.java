package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import parseEng.compareTo.Word;

public class Frequency {

	public static void main(String[] args) {
		// 1. 배열
		//  split 예시
		String[] split = {"Java", "Java", "Java", "Java", "Java", "Java", "som","som","som","som","som","som","som","som", "AA", "AA", "AA", "AA", "AA", "AA", "AA", "AA", "AA", "AA", "AA", "AA"};
		// contents를 split (parseEng 53번줄)
		
		
		// 2. 배열 -> 리스트
		List<String> list1 = new ArrayList<>(); // split 배열을 복사할 List 선언
		
		for(int i = 0 ; i<split.length; i++) { // 배열을 리스트에 복사
			list1.add(split[i]);
		}

//		
//		int a = Collections.frequency(list1, "Java");
//		System.out.println(a);
		
		// 3. 배열 -> 리스트 -> 맵
		Map<String, Integer> map = new HashMap<String, Integer>(); // Map을 선언 (parseEng 72번줄) key가 단어, value가 단어의 횟수 
		
		for(int i = 0 ; i<split.length; i++) {
			int a = Collections.frequency(list1, split[i]); // 횟수를 구하는 method, (이후 메소드에 대한 설명 정리) 
			map.put(split[i], a); // key가 단어, value가 단어의 횟수
		}
		
		
		// 4. 배열 -> 리스트 -> 맵 -> (클래스로 매개를 갖는)리스트
		Set<String> keySet = map.keySet(); // map 검색용 , Returns a Set view of the keys contained in this map
		Iterator<String> keyIterator = keySet.iterator();
		
		ArrayList<Word> wordList = new ArrayList<Word>(); // Word 클래스 타입의 리스트 wordList 
		Word[] word = new Word[map.size()]; // Word 클래스 타입의 배열
		
		int i = 0;
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			int value = map.get(key);
//			System.out.println("key : "+key + " value : "+value);
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
