package com.sparta.codingtest.week1.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_2739 {
    public static void main(String[] args) throws IOException {
        // BufferReader 객체를 생성하여 사용자로부터 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // 구구단 N단을 출력
        for (int i = 1; i <= 9 ; i++) {
            System.out.println(N + " * " + i + " = " + N * i);
        }
    }
}
