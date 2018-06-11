package parseScript;

public class Main {

	public static void main(String[] args) {
		ParseScript parseScript = new ParseScript();
		
		// 미리 입력해 두는 script 
		parseScript.title = "ironman";
		parseScript.trim(Script.ironman);
		
		parseScript.title = "HarryPoter";
		parseScript.trim(Script.HarryPoter);
		
		// 프로그램 시작
		parseScript.start();
		
	}

}
