package com.sparta.codingtest.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_2675 {
    public static void main(String[] args) throws IOException {
        // BufferReader 를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에서 테스트 케이스의 개수를 입력받음
        // trim() 메서드를 사용하여 양 끝의 공백을 제거
        int T = Integer.parseInt(br.readLine().trim());

        // StringBuilder 를 사용하여 결과를 저장 -> 문자열을 효율적으로 저장
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스를 처리
        for (int i = 0; i < T; i++) {
            // 각 테스트 케이스의 입력을 받아 공백으로 분리
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]); // 반복횟수 R 추출
            String S = input[1]; // 문자열 S 추출

            // 각 문자를 반복하여 새로운 문자열을 만듦
            for (char c : S.toCharArray()) {
                for (int j = 0; j < R; j++) { // 문자열 'S'의 각 문자열을 'R'번 반복. StringBuilder 에 추가
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        // 최종 결과를 출력
        System.out.println(sb.toString());
    }
}

/*
[문제]
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

[입력]
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

[출력]
각 테스트 케이스에 대해 P를 출력한다.
 */