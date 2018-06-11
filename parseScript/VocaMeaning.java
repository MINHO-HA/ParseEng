package parseScript;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class VocaMeaning {
	String wordListName = null;

	public void vocaMeaningInput() {
		// 저장한 Article의 title 리스트 출력
		Article.articleList();

		System.out.println("원하시는 title의 제목을 입력해주세요.\n>");
		String choice = ParseScript.sc.next();

		ArrayList<Word> thisWordList = Article.articleMap.get(choice);
		System.out.println("====== 전체 단어 리스트 ======");
		for (int i = 0; i < thisWordList.size(); i++) {
			String word = thisWordList.get(i).wordname;
			int count = thisWordList.get(i).wordcount;
			System.out.println(i + "번 " + word + " : " + thisWordList.get(i).meaning);
		}
		System.out.println("====== 전체 단어  리스트 끝 ======");
		System.out.println();

		try {
			do {
				System.out.println(" ==== 뜻을 입력하고 싶은 단어의 번호를 입력하세요.(입력 종료는  q 입력) ====");
				String sel = ParseScript.sc.next();
				if (Integer.parseInt(sel) >= thisWordList.size()) {
					System.out.println("존재하지 않는 번호 입니다.");
				} else if (sel.equals("q")) {
					System.out.println("단어 입력을 종료합니다.");
					break;
				} else {
					int selNum = Integer.parseInt(sel);
					System.out.println(selNum + "번 단어는 " + thisWordList.get(selNum).wordname + "입니다.");
					System.out.println(thisWordList.get(selNum).wordname + "의 뜻을 입력해 주세요.\n>");
					String meaning = ParseScript.sc.next();
					thisWordList.get(selNum).meaning = meaning;
					System.out.println(thisWordList.get(selNum).wordname + "의 의미가 " + thisWordList.get(selNum).meaning
							+ "으로 설정되었습니다.");

				}
			} while (true);
		} catch (NumberFormatException e) {
			System.out.println("단어 입력을 종료합니다.");
			//	System.out.println(e.getMessage());
		}

	}

}
