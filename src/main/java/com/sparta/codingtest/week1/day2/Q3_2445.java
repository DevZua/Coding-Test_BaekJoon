package com.sparta.codingtest.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3_2445 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // StringBuilder를 사용하여 출력 내용을 누적
        StringBuilder sb = new StringBuilder();

        // 첫번째부터 N번째 줄까지
        for (int i = 1; i <= N; i++) {
            sb.append("*".repeat(i))
                    .append(" ".repeat(2 * (N - i)))
                    .append("*".repeat(i))
                    .append('\n');
        }

        // N+1번째부터 2N-1번째 줄까지
        for (int i = N - 1; i >= 1; i--) {
            sb.append("*".repeat(i))
                    .append(" ".repeat(2 * (N - i)))
                    .append("*".repeat(i))
                    .append('\n');
        }

        // 결과를 출력
        System.out.print(sb.toString());
    }
}
