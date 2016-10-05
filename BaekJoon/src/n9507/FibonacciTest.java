package n9507;

import java.util.Scanner;

public class FibonacciTest {
	
	private static long[] fibonacci = new long[69];
	private static int[] inputData;
	
	public static void main(String[] args) {
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		fibonacci[2] = 2;
		fibonacci[3] = 4;
				
		long t1=System.currentTimeMillis();
		
		AddFibo();
		
		int count = 69;
		inputData = new int[count];
		
		for (int i = 0; i < count; i++) {
			inputData[i] = (int)(Math.random()*10000)%67;
			System.out.println("input : "+inputData[i]);
		}
		
		for (int i = 0; i < inputData.length; i++) {
			System.out.println("output : "+fibonacci[inputData[i]]);
		}
		long t2=System.currentTimeMillis();
		System.out.println("elapse time : "+(t2-t1));
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
