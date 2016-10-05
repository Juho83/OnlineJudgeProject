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

		//입력값을 배열에 담음
		inputTriangleData(count);
//		inputTriangleDataTest();	입력값 확인을 위한 테스트 메소드
		
		//계산 시작
		start(count);
	}
	
	private static void inputTriangleData(int count) throws Exception {
		//입력받은 수만큼 배열에 담음
		for (int i = 0; i < count; i++) {
			//각 라인별로 라인+1만큼 데이터를 입력 받기 때문에 배열로 저장
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < i+1; j++) {
				list.add(scanner.nextInt());
			}
			
			//전체 데이터를 담는 리스트에 해당 라인 리스트값을 저장. List안에 List가 담기는 상황
			triList.add(list);
		}
	}
	
	private static void start(int count) throws Exception {
		//데이터를 하나씩 담을 배열을 선언
		List<Integer> result = new ArrayList<Integer>();
		//첫번째 삽입이므로 초기값으로 0을 넣음.
		//push(결과데이터배열, 해당 라인 Index값, 입력 했던 라인 Index값, 배열에 담을 갯수)
		push(result, 0, 0, count);
		
		//결과값을 담은 배열을 루핑돌아 최고값을 추출, 출력함
		int maxSum = 0;
		for (int l = 0; l < resultList.size(); l++) {
			if(maxSum < resultList.get(l)) maxSum = resultList.get(l);
		}
		System.out.println(maxSum);
	}
	
	private static void push(List<Integer> result, int parentIndex, int triDataIndex, int count) throws Exception {
		//해당 라인 데이터를 추출
		List<Integer> triData = triList.get(triDataIndex);
		//해당 라인에서 입력한 숫자 갯수만큼 for문
		for (int j = 0; j < triData.size(); j++) {
			//이전 라인의 Index값 혹은 +1 값만 담을 수 있음
			if(j == parentIndex || j == parentIndex+1) {
				result.add(triData.get(j));
				//결과를 담은 배열의 크기가 최초 입력한 배열 갯수 크기와 같으면.. 해당 배열의 값들을 모두 더해 resultList에 담음
				if(result.size() == count) {
					int sum = 0;
					for (int k = 0; k < result.size(); k++) {
						sum += result.get(k);
					}
					resultList.add(sum);
					result.remove(triDataIndex);
				// 아니면 다음 라인으로 넘어감.
				} else {
					push(result, j, ++triDataIndex, count);
					//다음 라인 작업이 끝나 되돌아오면 해당 라인 데이터가 들어있는 result값을 뺌.
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

