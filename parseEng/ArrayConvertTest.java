package parseEng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayConvertTest {

	public static void main(String[] args) {
		String test[] = new String[100];
		
		for(int i=0; i<test.length ; i++) {
			test[i] = Integer.toString(i);
			System.out.println(test[i]);
		}
	
		// Map 생성
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		// Map에  Array 복사
		for(int i=0; i<test.length; i++) {
			map.put(i, test[i]+"A");
		}
		
		// Iterator로 출력
		Set<Integer> keySet = map.keySet(); //Returns a Set view of the keys contained in this map
		Iterator<Integer> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			int key = keyIterator.next();
			String value = map.get(key);
			System.out.println("key : "+key + " value : "+value);
		}	
	}
	


		
}

