package n1932;

import java.util.ArrayList;
import java.util.List;

public class TriangleForArrayAlgoTestV3 {

//	private static int[][] triList;
	private static int rootValue;
	private static int maxSum = 0;
	private static BinaryTree parent = new BinaryTree();
	private static List<BinaryTree> resultList = new ArrayList<BinaryTree>();
	
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
	
	private static void setParentBinaryTree(BinaryTree bt) throws Exception {
		BinaryTree pr = new BinaryTree();
		pr.
	}
	
	private static void inputBinaryTree(int[][] triList, int count) throws Exception {
		rootValue = triList[0][0];
		BinaryTree firstNode = new BinaryTree();
		firstNode.setParentTree(null);
		firstNode.setLeftValue(triList[1][0]);
		firstNode.setRightValue(triList[1][1]);
		parent = firstNode;
		
		for (int i = 2; i <= count; i++) {
//			int[] intArr = new int[i+1];
			for (int j = 0; j < i+1; j++) {
				BinaryTree current = new BinaryTree();
				setParentBinaryTree(current);
				current.setLeftValue(triList[i][j]);
				current.setRightValue(triList[i][j+1]);
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

