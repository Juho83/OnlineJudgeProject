package n1932;

import java.util.ArrayList;
import java.util.List;

public class TriangleForListAlgoTestV2 {

	private static List<List<Integer>> triList = new ArrayList<List<Integer>>();
	private static int rootValue;
	private static int maxSum = 0;
	private static BinaryTree parent = new BinaryTree();
	private static List<Integer> resultList = new ArrayList<Integer>();
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		count = 10;

//		triList = new int[count][count];
		inputTriangleData(count);
		inputTriangleDataTest();
		
		long t1=System.currentTimeMillis();
		start();
		long t2=System.currentTimeMillis();
		System.out.println("elapse time : "+(t2-t1));
	}

	private static void inputTriangleData(int count) throws Exception {
		List<Integer> first = new ArrayList<Integer>();
		first.add((int)(Math.random()*10000%100));
		triList.add(first);
		
		for (int i = 1; i < count; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < i+1; j++) {
				row.add((int)(Math.random()*10000%100));
			}
			triList.add(row);
		}
	}
	/*
	private static void binaryPush(int rowIndex, int colIndex) throws Exception {
		List<Integer> row = triList.get(rowIndex);
		for (int i = colIndex; i <= colIndex+1; i++) {
			resultList.add(row.get(i));
			if(resultList.size() == count) {
				sum();
			} else {
				binaryPush(++rowIndex, i);
			}
			//current remove
			resultList.remove(resultList.size()-1);
			if(row.size() == 1) break;
		}
	}*/

	private static void sum() throws Exception {
		int sum = 0;
		for (int i = 0; i < resultList.size(); i++) {
			sum += resultList.get(i);
		}
		
		if(maxSum < sum) maxSum = sum;
	}
	
	private static void push(int rowIndex, int ColIndex) throws Exception {
		List<Integer> row = triList.get(rowIndex);
		for (int i = ColIndex; i < row.size(); i++) {
			resultList.add(row.get(i));
			if(resultList.size() == count) {
				sum();
				if(i-ColIndex > 1) break;
			} else {
				push(++rowIndex, i);
			}
			//current remove
			resultList.remove(resultList.size()-1);
		}
	}
	
	private static void start() throws Exception {
//		int[] result = new int[count];
		
		resultList.add(triList.get(0).get(0));
		push(1, 0);
		
		System.out.println(maxSum);
	}
	
	private static void inputBinaryTree(int[][] triList, int count) throws Exception {
		rootValue = (int)(Math.random()*10000)%100;
		BinaryTree firstNode = new BinaryTree();
		firstNode.setData(rootValue);
		parent = firstNode;
		
		int secondValue = (int)(Math.random()*10000)%100;
		int thirdValue = (int)(Math.random()*10000)%100;
		BinaryTree secondNode = new BinaryTree();
		BinaryTree thirdNode = new BinaryTree();
		
		secondNode.setData(secondValue);
		thirdNode.setData(secondValue);
		
		for (int i = 1; i <= count; i++) {
//			int[] intArr = new int[i+1];
			for (int j = 0; j < i; j++) {
				BinaryTree leftNode = new BinaryTree();
				current.setData((int)(Math.random()*10000)%100);
				setParentBinaryTree(current);
				current.setLeftValue(triList[i][j]);
				current.setRightValue(triList[i][j+1]);
			}
			triList[i] = intArr;
		}
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

