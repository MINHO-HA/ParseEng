package parseEng;

public class Word implements Comparable<Word>{
	String wordname; // 단어의 이름, 표제어, 단어 그 자체
	int wordcount; // 단어가 등장한 횟수
	
	Word(String wordname, int wordcount) {
		this.wordname = wordname;
		this.wordcount = wordcount;
	}
	
	@Override
	public int compareTo(Word word) {
		return wordname.compareTo(word.wordname);
	}
	
	
}
