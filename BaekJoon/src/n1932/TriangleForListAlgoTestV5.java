package n1932;

import java.util.ArrayList;
import java.util.List;

public class TriangleForListAlgoTestV5 {

	private static List<List<Integer>> triList = new ArrayList<List<Integer>>();
	private static int sum = 0;
	private static int maxSum = 0;
	private static List<Integer> resultList = new ArrayList<Integer>();
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		count = 30;

		inputTriangleData();
//		inputTriangleDataTest();
		
		long t1=System.currentTimeMillis();
		start();
		long t2=System.currentTimeMillis();
		System.out.println("elapse time : "+(t2-t1));
	}

	private static void inputTriangleData() throws Exception {
		List<Integer> first = new ArrayList<Integer>();
		first.add((int)(Math.random()*10000%10));
		triList.add(first);
		
		for (int i = 1; i < count; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < i+1; j++) {
				row.add((int)(Math.random()*10000%10));
			}
			triList.add(row);
		}
	}

	private static void push(int rowIndex, int ColIndex) throws Exception {
		List<Integer> row = triList.get(rowIndex);
		for (int i = ColIndex; i < row.size(); i++) {
			
			if(i-ColIndex > 1) break;

			resultList.add(row.get(i));
			sum+=row.get(i);
			if(resultList.size() == count) {
				if(maxSum < sum) maxSum = sum;
			} else {
				push(rowIndex+1, i);
			}
			//current remove
			sum-=row.get(i);
			resultList.remove(resultList.size()-1);
			
			
		}
	}
	
	private static void start() throws Exception {
		resultList.add(triList.get(0).get(0));
		sum+=triList.get(0).get(0);
		push(1, 0);
		
		System.out.println(maxSum);
	}
	
	private static void inputTriangleDataTest() throws Exception {
		for (int i = 0; i < triList.size(); i++) {
			List<Integer> test = triList.get(i);
			for (int j = 0; j < test.size(); j++) {
				System.out.print(test.get(j)+" ");
			}
			System.out.println();
		}
	}
	
}

