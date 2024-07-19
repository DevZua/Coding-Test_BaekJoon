package com.sparta.codingtest.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_9184 {
    // 메모이제이션을 위한 3차원 배열 선언
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 한 줄씩 입력을 받아 공백을 기준으로 분리
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 입력이 "-1 -1 -1"인 경우, 반복문을 종료
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            // w(a, b, c)를 계산하고 결과를 StringBuilder에 추가
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }

        // 최종 결과를 출력
        System.out.print(sb.toString());
    }

    // 재귀적으로 w(a, b, c)를 계산하는 함수
    public static int w(int a, int b, int c) {
        // 기저 조건: a, b, c 중 하나라도 0 이하일 때 1을 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        // 기저 조건: a, b, c 중 하나라도 20을 초과할 때 w(20, 20, 20)을 호출
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        // 메모이제이션: 이미 계산된 값이 있는 경우 그 값을 반환
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        // a < b < c 인 경우의 재귀 호출
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            // 그 외의 경우에 대한 재귀 호출
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        // 계산된 값을 반환
        return dp[a][b][c];
    }
}
