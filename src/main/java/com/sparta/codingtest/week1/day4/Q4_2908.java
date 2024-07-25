package com.sparta.codingtest.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 두 수를 공백을 기준으로 분리하여 문자열 배열에 저장
        String[] numbers = br.readLine().split(" ");

        // 첫 번째 수를 뒤집기
        String reversedA = new StringBuilder(numbers[0]).reverse().toString();
        // 두 번째 수를 뒤집기
        String reversedB = new StringBuilder(numbers[1]).reverse().toString();

        // 두 뒤집어진 수를 정수로 변환하여 비교
        int a = Integer.parseInt(reversedA);
        int b = Integer.parseInt(reversedB);

        // 더 큰 수를 출력
        System.out.println(Math.max(a, b));
    }
}
