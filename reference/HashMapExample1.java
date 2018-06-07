package reference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class HashMapExample1 {

	public static void main(String[] args) {
		
		//Map 컬렉션 생성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//객체 저장
		map.put("손흥민", 185);
		map.put("기성용", 191);
		map.put("박지성", 176);
		map.put("이승우", 170);
		map.put("박지성", 177);
		
		//저장된 map entry 수
		System.out.println("총 Entry 수 : "+map.size());
		
		//객체 찾기
		//이름(키값)으로 신장(벨류값) 검색
		System.out.println(map.get("손흥민"));
		System.out.println();
		
		//객체를 하나씩 처리
		Set<String> keySet = map.keySet(); //Key Set 얻기
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println(key+" : "+value);
			
		}

	}

}
