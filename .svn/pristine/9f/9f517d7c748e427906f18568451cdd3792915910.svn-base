package algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Q3. n 명의 사람 이름 중에서 같은 이름(동명이인)을 찾아 집합으로 만들어 돌려주는 알고리즘을 만들어보세요.
// 사람의 이름은 무작위로 콘솔을 통해 입력받습니다.

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String src = sc.nextLine();
        String arr[] = src.split(" ");
        System.out.println(getSet(arr));
	}
	
	public static Set getSet(String[] arr) {
		int n = arr.length;
		Set<String> answer = new HashSet<String>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i].equals(arr[j])) {
					answer.add(arr[i]);
				}
			}
		}
		return answer;
	}
}
