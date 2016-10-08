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

import java.util.ArrayList;
import java.util.List;

public class MainTest {
	
	private static int strLength = 0;
	private static List<String> result = new ArrayList<String>();
	private static List<String> inputData = new ArrayList<String>();
	private static int cursorIndex = 0;
	
	public static void main(String[] args) throws Exception {
		
		makeInputData();
		start();
//		testData();
	}
	
	public static void start() throws Exception {
		for (int i = 0; i < inputData.size(); i++) {
			String popData = inputData.get(i);
			
			if(popData.equals("<")) {
				if(cursorIndex == 0) continue;
				else {
					cursorIndex--;
					continue;
				}
			}else if(popData.equals(">")) {
				if(cursorIndex == result.size()) continue;
				else {
					cursorIndex++;
					continue;
				}
			}else if(popData.equals("-")) {
				if(cursorIndex == 0) continue;
				else {
					result.remove(cursorIndex-1);
					cursorIndex--;
					continue;
				}
			}else {
				result.add(cursorIndex, popData);
				cursorIndex++;
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
		System.out.println();
	}
	
	public static void makeInputData() throws Exception {
//		inputData.add("A");
//		inputData.add("B");
//		inputData.add("C");
//		inputData.add("<");
//		inputData.add("<");
//		inputData.add("D");
//		inputData.add("F");
//		inputData.add(">");
//		inputData.add("-");
//		inputData.add("-");
//		inputData.add("E");
		
		inputData.add("<");
		inputData.add("<");
		inputData.add("B");
		inputData.add("P");
		inputData.add("<");
		inputData.add("A");
		inputData.add(">");
		inputData.add(">");
		inputData.add("C");
		inputData.add("d");
		inputData.add("-");
	}
	
	public static void testData() throws Exception {
		inputData.add("A");		//A
		inputData.add("B");		//AB
		inputData.add("C");		//ABC
		inputData.add(1, "D");	//ADBC
		inputData.add(2, "F");	//ADFBC
		inputData.remove(3);	//ADFC
		inputData.remove(2);	//ADC
		inputData.add(2, "E");	//ADEC
		
		for (int i = 0; i < inputData.size(); i++) {
			System.out.print(inputData.get(i));
		}
		System.out.println();
	}
}
