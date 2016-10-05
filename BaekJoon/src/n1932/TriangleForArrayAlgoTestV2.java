package n1932;

import java.util.Scanner;

public class TriangleForArrayAlgoTestV2 {

	private static int[][] triList;
	private static int maxSum = 0;
	
	public static void main(String[] args) throws Exception {
		int count = 300;

		triList = new int[count][count];
		inputTriangleData(count);
//		inputTriangleDataTest(count);
		
//		long t1=System.currentTimeMillis();
//		start(count);
//		long t2=System.currentTimeMillis();
//		System.out.println("elapse time : "+(t2-t1));
	}
	
	private static void inputTriangleData(int count) throws Exception {
		for (int i = 0; i < count; i++) {
			int[] intArr = new int[i+1];
			for (int j = 0; j < i+1; j++) {
				intArr[j] = (int)(Math.random()*10000)%100;
			}
			triList[i] = intArr;
		}
	}
	
	private static void start(int count) throws Exception {
		int[] result = new int[count];
		push(result, 0, 0, count);
		
		System.out.println(maxSum);
	}
	
	private static void push(int[] result, int parentIndex, int triDataIndex, int count) throws Exception {
		int breakPoint = 0;
		int[] triData = triList[triDataIndex];
		for (int j = 0; j < triData.length; j++) {
			if(j == parentIndex || j == parentIndex+1) {
				result[triDataIndex] = triData[j];
				if(triDataIndex+1 == count) {
					int sum = 0;
					for (int k = 0; k < result.length; k++) {
						sum += result[k];
					}
					if(maxSum < sum) maxSum = sum;
					result[triDataIndex] = 0;
				} else {
					push(result, j, ++triDataIndex, count);
					result[--triDataIndex] = 0;
				}
			}
			breakPoint++;
			if(breakPoint == 2) {
				breakPoint = 0;
				break;
			}
		}
		
	}
	
	private static void inputTriangleDataTest(int count) throws Exception {
		for (int i = 0; i < count; i++) {
			int[] test = triList[i];
			for (int j = 0; j < test.length; j++) {
				System.out.print(test[j]+" ");
			}
			System.out.println();
		}
	}
	
}

