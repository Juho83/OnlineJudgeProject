package n1932;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleForListAlgoTest {

	private static List<List<Integer>> triList = new ArrayList<List<Integer>>();
	private static List<Integer> resultList = new ArrayList<Integer>();
	private static Scanner scanner;
	public static void main(String[] args) throws Exception {
		scanner = new Scanner(System.in);
		int count = scanner.nextInt();

		//�Է°��� �迭�� ����
		inputTriangleData(count);
//		inputTriangleDataTest();	�Է°� Ȯ���� ���� �׽�Ʈ �޼ҵ�
		
		//��� ����
		start(count);
	}
	
	private static void inputTriangleData(int count) throws Exception {
		//�Է¹��� ����ŭ �迭�� ����
		for (int i = 0; i < count; i++) {
			//�� ���κ��� ����+1��ŭ �����͸� �Է� �ޱ� ������ �迭�� ����
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < i+1; j++) {
				list.add(scanner.nextInt());
			}
			
			//��ü �����͸� ��� ����Ʈ�� �ش� ���� ����Ʈ���� ����. List�ȿ� List�� ���� ��Ȳ
			triList.add(list);
		}
	}
	
	private static void start(int count) throws Exception {
		//�����͸� �ϳ��� ���� �迭�� ����
		List<Integer> result = new ArrayList<Integer>();
		//ù��° �����̹Ƿ� �ʱⰪ���� 0�� ����.
		//push(��������͹迭, �ش� ���� Index��, �Է� �ߴ� ���� Index��, �迭�� ���� ����)
		push(result, 0, 0, count);
		
		//������� ���� �迭�� ���ε��� �ְ��� ����, �����
		int maxSum = 0;
		for (int l = 0; l < resultList.size(); l++) {
			if(maxSum < resultList.get(l)) maxSum = resultList.get(l);
		}
		System.out.println(maxSum);
	}
	
	private static void push(List<Integer> result, int parentIndex, int triDataIndex, int count) throws Exception {
		//�ش� ���� �����͸� ����
		List<Integer> triData = triList.get(triDataIndex);
		//�ش� ���ο��� �Է��� ���� ������ŭ for��
		for (int j = 0; j < triData.size(); j++) {
			//���� ������ Index�� Ȥ�� +1 ���� ���� �� ����
			if(j == parentIndex || j == parentIndex+1) {
				result.add(triData.get(j));
				//����� ���� �迭�� ũ�Ⱑ ���� �Է��� �迭 ���� ũ��� ������.. �ش� �迭�� ������ ��� ���� resultList�� ����
				if(result.size() == count) {
					int sum = 0;
					for (int k = 0; k < result.size(); k++) {
						sum += result.get(k);
					}
					resultList.add(sum);
					result.remove(triDataIndex);
				// �ƴϸ� ���� �������� �Ѿ.
				} else {
					push(result, j, ++triDataIndex, count);
					//���� ���� �۾��� ���� �ǵ��ƿ��� �ش� ���� �����Ͱ� ����ִ� result���� ��.
					result.remove(--triDataIndex);
				}
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

