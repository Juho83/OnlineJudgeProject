/*
 * 키로거
 * 
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 
 * 각 테스트 케이스는 한줄로 이루어져 있고, 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L의 길이 ≤ 1,000,000) 
 * 강산이가 백스페이스를 입력했다면, '-'가 주어진다. 이 때는 커서의 위치 바로 앞에 있는 글자를 지운다. 
 * 화살표의 입력은 '<'와 '>'로 주어진다. 이 때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 
 * 나머지 문자는 비밀번호의 일부이다. 물론, 나중에 백스페이스를 통해서 지울 수는 있다. 
 * 만약 커서의 위치가 줄의 마지막이 아니라면, 그 문자를 입력하고, 커서는 오른쪽으로 한 칸 이동한다. 
 */


package n5397;

import java.util.Scanner;

public class MainV2 {
	
	private static Scanner scanner;
	
	public static void main(String[] args) throws Exception {
		
		scanner = new Scanner(System.in);
		String strCount = scanner.nextLine();
		int count = Integer.parseInt(strCount);
		
		for (int i = 0; i < count; i++) {
			start();
		}
	}
	
	public static void start() throws Exception {
		StringBuffer result = new StringBuffer();
		String inputData = scanner.nextLine();
		int cursorIndex = 0;
		
		for (int i = 0; i < inputData.length(); i++) {
			String popData = inputData.substring(i, i+1);
			
			if(popData.equals("<")) {
				if(cursorIndex == 0) continue;
				else {
					cursorIndex--;
					continue;
				}
			}else if(popData.equals(">")) {
				if(cursorIndex == result.length()) continue;
				else {
					cursorIndex++;
					continue;
				}
			}else if(popData.equals("-")) {
				if(cursorIndex == 0) continue;
				else {
					result.deleteCharAt(cursorIndex-1);
					cursorIndex--;
					continue;
				}
			}else {
				result.insert(cursorIndex, popData);
				cursorIndex++;
			}
		}
		
		System.out.println(result.toString());
	}
}
