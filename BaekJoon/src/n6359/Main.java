package n6359;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static List<List<String>> testCaseList = new ArrayList<List<String>>();
	private static List<Integer> resultList = new ArrayList<Integer>();
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		
		makeData(count);
		start();
	}
	
	public static void makeData(int count) {
		for (int i = 0; i < count; i++) {
			int data = scanner.nextInt();
			
			List<String> inputData = new ArrayList<String>();
			for (int j = 0; j < data; j++) {
				inputData.add("close");
			}
			testCaseList.add(inputData);
		}
	}
	
	public static void start() {
		for (int i = 0; i < testCaseList.size(); i++) {
			int inputData = testCaseList.get(i);
			
			for (int j = 1; j <= inputData; j++) {
				for (int k = 0; k < inputData; k+j) {
					
				}
			}
		}
	}
}
