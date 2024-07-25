package com.sparta.codingtest.week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_12605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 읽기 위한 BufferedReader
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        // 각 테스트 케이스 처리
        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().split(" "); // 입력을 단어 배열로 분리
            sb.append("Case #").append(i + 1).append(": "); // 케이스 번호 출력

            // 단어들을 역순으로 StringBuilder 에 추가
            for (int j = words.length - 1; j >= 0; j--) {
                sb.append(words[j]);
                if (j > 0) {
                    sb.append(" "); // 단어 사이에 공백 추가
                }
            }
            sb.append("\n"); // 각 케이스의 결과 끝에 줄바꿈 추가
        }

        System.out.print(sb); // 최종 결과 출력
    }
}
/*
14060 KB / 104 ms
 */