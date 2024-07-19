package com.sparta.codingtest.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_2438 {
    public static void main(String[] args) throws IOException {
        // BufferedReader 객체를 생성하여 사용자로부터 입력을 받습니다.
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N을 입력받습니다.
        int N = Integer.parseInt(br.readLine());

        // StringBuilder를 사용하여 출력 내용을 누적합니다.
        StringBuilder sb = new StringBuilder();

        // N번 반복하여 각 줄에 해당하는 별을 추가합니다.
        for (int i = 1; i <= N; i++) {
            sb.append("*".repeat(i)).append('\n');
        }

        // 누적된 출력 내용을 한 번에 출력합니다.
        System.out.print(sb.toString());
    }
}
