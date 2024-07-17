package com.sparta.codingtest.day1;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A, B, C를 입력받습니다.
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.close();

        // 첫째 줄: (A + B) % C
        int result1 = (A + B) % C;

        // 둘째 줄: ((A % C) + (B % C)) % C
        int result2 = ((A % C) + (B % C)) % C;

        // 셋째 줄: (A * B) % C
        int result3 = (A * B) % C;

        // 넷째 줄: ((A % C) * (B % C)) % C
        int result4 = ((A % C) * (B % C)) % C;

        // 결과 출력
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
