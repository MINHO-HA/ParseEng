package parseScript;

import java.util.ArrayList;

public class Word implements Comparable<Word>{
	public String wordname; // 단어의 이름, 표제어, 단어 그 자체
	public int wordcount; // 단어가 등장한 횟수
	public String meaning; // 단어의 뜻
	
	// 생성자
	Word(String wordname, int wordcount) {
		this.wordname = wordname;
		this.wordcount = wordcount;
	}

	// Comparable 인터페이스 구현(단어 표제어로 정렬할 시 사용)
	@Override
	public int compareTo(Word word) {
		return wordname.compareTo(word.wordname);
	}
	
}
