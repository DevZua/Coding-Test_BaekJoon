package com.sparta.codingtest.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_24417 {
    // 모듈러 연산을 위한 상수 정의 (문제에서 요구하는 1,000,000,007)
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력된 값을 정수형으로 변환합니다.
        int N = Integer.parseInt(br.readLine().trim());

        // 피보나치 수열의 첫 두 항을 초기화합니다.
        long temp1 = 1;
        long temp2 = 1;
        long temp3 = 0;

        // N이 1 또는 2인 경우, 피보나치 수는 1이므로 temp3를 1로 설정
        if (N == 1 || N == 2) {
            temp3 = 1;
        } else {
            // 피보나치 수열을 반복문을 통해 계산
            for (int i = 3; i <= N; i++) {
                // 현재 항을 이전 두 항의 합으로 계산하고, MOD로 나눈 나머지를 저장
                temp3 = (temp1 + temp2) % MOD;
                // 다음 반복을 위해 이전 두 항을 업데이트합니다.
                temp1 = temp2;
                temp2 = temp3;
            }
        }

        // n번째 피보나치 수와 반복문 사용 횟수를 출력
        long fibo1 = temp3;
        long fibo2 = N - 2;
        System.out.println(fibo1 + " " + fibo2);
    }
}
