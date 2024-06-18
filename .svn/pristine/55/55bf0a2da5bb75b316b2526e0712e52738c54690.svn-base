package algorithm;

import java.util.Scanner;

// Q5. 두 자연수 a 와 b 의 최대공약수를 구하는 알고리즘을 만들어보세요.
// 두 수의 약수 중에서 공통된 것을 찾아 그 값중 최댓값인것을 찾아야 합니다.
// 약수란 나누어 떨어지는 값입니다.
// 유클리드 알고리즘 : a 와 b 의 최대공약수는 'b' 와 'a 를 b 로 나눈 나머지' 의 최대 공약수와 같다. gcd(a, b) = gcd(b, a % b)
// 재귀함수를 사용하세요

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();	
		System.out.println(gcd(a, b));
	}
	
	static int gcd(int a, int b) {
		// 둘중 더 큰수를 a에 저장
		if(b>a) {
			a = a+b;
			b = a-b;
			a = a-b;
		}
		
		// 큰수를 작은수로 나눈 나머지
		int n = a%b;
		// 나머지가 0 일때 작은수를 리턴(이 값이 최대 공약수임)
		if(n == 0) {
			return b;
		} else {
			return gcd(n, b);
		}
	}
}
