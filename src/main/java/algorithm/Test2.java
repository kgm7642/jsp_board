package algorithm;

import java.util.Scanner;

// Q2. 주어진 숫자 n 개 중 가장 큰 숫자를 찾는 알고리즘을 만들어보세요.
// 숫자는 무작위로 콘솔을 통해 입력받습니다.
// 데이터의 예는 다음과 같습니다.
// 17, 92, 18, 33, 58, 7, 33, 42 가 주어졌을 때, 가장 큰 수는 92

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        String src = sc.nextLine();
        String arr[] = src.split(", ");
        int answer = 0;
        
        for(String n : arr) {
        	if(Integer.parseInt(n) > answer) {
        		answer = Integer.parseInt(n);
        	}
        }
        System.out.println(answer);
	}
}