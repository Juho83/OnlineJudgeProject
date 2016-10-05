package n9507;

import java.util.Scanner;

public class FibonacciTestV2 {
	
	private static long[] fibonacci = new long[69];
	private static int[] inputData;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		fibonacci[2] = 2;
		fibonacci[3] = 4;

		scanner = new Scanner(System.in);
		int count = scanner.nextInt();
				
		AddFibo();
		
		inputData = new int[count];
		
		for (int i = 0; i < count; i++) {
			inputData[i] = scanner.nextInt();
//			System.out.println("input : "+inputData[i]);
		}
		
		for (int i = 0; i < inputData.length; i++) {
			System.out.println(fibonacci[inputData[i]]);
		}
	}
	
	public static void AddFibo() {
		for (int i = 4; i < fibonacci.length; i++) {
			calFibo(i);
		}
		
	}
	
	public static void calFibo(int number) {
		long sum = 0;
		for (int i = number-1; i >= number-4; i--) {
			sum += fibonacci[i]; 
		}
		fibonacci[number] = sum;
	}
}
