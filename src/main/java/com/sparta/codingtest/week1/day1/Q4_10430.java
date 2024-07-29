package com.sparta.codingtest.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 값을 읽어옴
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // (A+B)%C를 계산
        int result1 = (A + B) % C;

        // ((A%C) + (B%C))%C를 계산
        int result2 = ((A % C) + (B % C)) % C;

        // (A*B)%C를 계산
        int result3 = (A * B) % C;

        // ((A%C) * (B%C))%C를 계산
        int result4 = ((A % C) * (B % C)) % C;

        // 결과를 출력합니다.
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
/*
14380 KB / 128 ms
 */