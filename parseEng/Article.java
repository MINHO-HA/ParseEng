package parseEng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Article {

	public String title;
	public String contents;
	public static Map<String, ArrayList<Word>> articleMap = new HashMap<String, ArrayList<Word>>();
		
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
	//static ArrayList wordList;
*/	
}
