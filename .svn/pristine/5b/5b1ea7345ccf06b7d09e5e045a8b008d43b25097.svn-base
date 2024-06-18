package algorithm;

import java.util.Scanner;

// Q4. 1부터 n까지 연속한 정수의 곱을 구하는 알고리즘을 만들어 보세요.
// 1 부터 n 까지의 곱, 즉 팩토리얼을 구하는 문제입니다.
// 재귀함수를 사용하세요.

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fac(n));
	}
	
	static int fac(int n) {
		if(n==0) {
			return 1;
		} else {
			return n * fac(n-1);
		}
	}
}
