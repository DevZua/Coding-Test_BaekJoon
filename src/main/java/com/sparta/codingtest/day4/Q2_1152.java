package com.sparta.codingtest.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_1152 {
    public static void main(String[] args) throws IOException {
        // BufferReader 를 사용하여 입력을 받음(빠른 입력 처리)
        // InputStreamReadr 를 통해 표준입력(System.in) 을 BufferReadr 에 연결
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // br.readLine()을 사용하여 한 줄의 입력을 읽어오고, trim()을 사용하여 양 끝의 공백을 제거
        String input = br.readLine().trim();

        // 입력이 빈 문자일일 경우 단어의 개수는 0이므로 0을 출력하고 프로그램을 종료
        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }

        // 단어의 개수를 셀 변수를 초기화. 최소하나 하나의 단어가 있다고 가정
        int wordCount = 1;

        // 입력 문자열의 각 문자를 순회
        for (int i = 0; i < input.length(); i++) {
            // 현재 문자가 공백인 경우에
            if (input.charAt(i) == ' ') {
                // 단어의 개수를 증가시킴
                wordCount++;
                // 연속된 공백을 건너뛰기 위해 반복문을 추가로 진행
                while (i < input.length() - 1 && input.charAt(i + 1) == ' ') {
                    i++;
                }
                /*
                while 문 설명
                - i < input.length() - 1 : 현재 인덱스 'i'가 문자열의 끝에 도달하지 않았는지 확인
                - input.chatAt(i + 1) == ' ' : 다음 인덱스('i+1')의 문자가 공백인지 확인
                 */
            }
        }

        // 최종 단어의 개수를 출력
        System.out.println(wordCount);
    }
}
