package com.sparta.codingtest.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_2475 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader 를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 한 줄을 공백으로 분리하여 배열에 저장
        String[] input = br.readLine().split(" ");

        int sum = 0; // 숫자들의 제곱합을 저장할 변수

        // 각 숫자를 제곱하여 합산
        for (String s : input) {
            int number = Integer.parseInt(s); // 문자열을 정수로 변환
            sum += number * number; // 숫자를 제곱하여 합산
        }

        // 제곱합을 10으로 나눈 나머지를 계산하여 검증수를 구함
        int checkDigit = sum % 10;

        // 검증수를 출력
        System.out.println(checkDigit);
    }
}
/*
14160 KB / 128 ms
 */