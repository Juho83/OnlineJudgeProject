/*
 * 백준 온라인 2229번 ( https://www.acmicpc.net/problem/2229 )
 * 조 짜기
 * 
 * 문제
 * 알고스팟 캠프에 N(1≤N≤1,000)명의 학생들이 참여하였다. 학생들은 열심히 공부를 하고 있었는데, 어느 날 조별 수업을 진행하기로 하였다. 
 * 조별 수업의 목적은 잘 하는 학생들과 덜 잘 하는 학생들을 같은 조로 묶어서 서로 자극을 받으며 공부하도록 만들기 위함이다. 따라서 가급적이면 실력 차이가 많이 나도록 조를 편성하는 것이 유리하다.
 * 하지만 조를 편성할 때 같은 조에 속하게 된 학생들의 나이 차이가 많이 날 경우에는 오히려 부정적인 효과가 나타날 수도 있다. 
 * 따라서 선생님들은 우선 학생들을 나이 순서대로 정렬한 다음에, 적당히 학생들을 나누는 방식으로 조를 짜기로 하였다. 조의 개수는 상관이 없다.
 * 각각의 조가 잘 짜여진 정도는 그 조에 속해있는 가장 점수가 높은 학생의 점수와 가장 점수가 낮은 학생의 점수의 차이가 된다. 
 * 또한 전체적으로 조가 잘 짜여진 정도는, 각각의 조가 잘 짜여진 정도의 합으로 나타난다. 
 * 한 명으로 조가 구성되는 경우에는 그 조의 잘 짜여진 정도가 0이 된다(가장 높은 점수와 가장 낮은 점수가 같으므로).
 * 학생들의 점수가 주어졌을 때, 조가 잘 짜여진 정도의 최대값을 구하는 프로그램을 작성하시오.
 * 
 * 입력
 * 첫째 줄에 N이 주어진다. 다음 줄에는 N명의 학생들의 점수가 나이 순서대로 주어진다. 각 학생의 점수는 0 이상 10,000 이하의 정수이다.
 * 
 * 출력
 * 첫째 줄에 답을 출력한다.
 * 
 * 예제) 
 * 입력
 * 10
 * 2 5 7 1 3 4 8 6 9 3
 * 
 * 출력
 * 20
 */

package n2229;

public class Main {
	/*
	 * for문이 3개 들어가야 할 것으로 예상
	 * 첫번째 for문은 모든 경우의 수를 체크하기 위한 for문 (처음부터 마지막숫자까지)
	 * 1명의 잘짜여진 정도는 0이므로 기본베이스는 2명부터로 함.
	 * 다이나믹 프로그래밍이므로 2명일때부터 마지막까지 각각의 최적의 합을 저장해 놓음.
	 * 
	 * 두번째 for문은 조를 짜기 위해 학생이 늘어날 때마다 새로운 경우의수를 계산해야 함.
	 * 예) 5명일때 3:2, 2:3 을 계산하기 위한 for문.. 앞의 숫자인 3과 2는 이전에 계산 했던 값으로 대체 ( 다이나믹 프로그래밍 )
	 * 
	 */
	
	private static int[] sum;
	private static int[] students;
	
	public static void main(String[] args) throws Exception {
		
		students = new int[10];
		
		for (int i = 0; i < students.length; i++) {
			students[i] = (int)Math.random()*10000%100;
		}
		
		start();
	}
	
	public static void start() throws Exception {
		
		for (int i = 1; i < students.length; i++) {
			optiSum(i);
		}
	}
	
	public static void optiSum(int index) throws Exception {
		int minScore = 10001;
		int maxScore = -1;

		if(index == 1) {
			for (int i = 0; i <= index; i++) {
				if(students[i] < minScore) minScore = students[i];
				if(students[i] > maxScore) maxScore = students[i];
			}
			sum[index] = maxScore - minScore;
		} else {
			
		}
	}
	
}
