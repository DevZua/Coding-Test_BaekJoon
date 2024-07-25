package com.sparta.codingtest.week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        // 알파벳 대소문자를 구분하지 않으므로 모두 대문자로 변환
        input = input.toUpperCase();

        // 각 알파벳의 빈도를 저장할 배열 생성
        int[] freq = new int[26]; // A-Z는 26개의 알파벳

        // 주어진 문자열을 순회하면서 각 문자의 빈도 계산
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch - 'A']++;
        }

        // 최대 빈도 찾기
        int maxFreq = -1;
        char result = '?';
        boolean duplicate = false;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = (char) (i + 'A');
                duplicate = false;
            } else if (freq[i] == maxFreq) {
                duplicate =  true;
            }
        }

        // 결과 출력
        if (duplicate) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}

