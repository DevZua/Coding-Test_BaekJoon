package com.sparta.codingtest.week3.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q4_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 단어의 개수를 입력 받음
        int size = Integer.parseInt(br.readLine().trim());

        // 단어들을 저장할 문자열 배열을 생성
        String[] arr = new String[size];

        // 입력된 단어를 문자열 배열에 저장
        for (int i = 0; i < size; i++) {
            arr[i] = br.readLine().trim();
        }

        // 문자열 배열을 정렬
        // Comparator 를 사용하여 두 가지 기준으로 정렬
        // 1. 길이 순서 (길이가 짧은 단어가 앞에 오도록)
        // 2. 길이가 같으면 사전순으로 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    // 길이 순서로 비교
                    return Integer.compare(s1.length(), s2.length());
                } else {
                    // 길이가 같으면 사전순으로 비교
                    return s1.compareTo(s2);
                }
            }
        });

        // 중복된 문자열을 제거하고 결과를 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            // 현재 문자열이 마지막 문자열이거나, 다음 문자열과 다를 경우에만 결과에 추가
            // 즉, 현재 문자열이 이전 문자열과 다를 때만 출력하여 중복을 제거
            if (i == size - 1 || !arr[i].equals(arr[i + 1])) {
                sb.append(arr[i]).append("\n");
            }
        }

        // 결과를 출력
        // StringBuilder 를 사용하여 한 번에 결과를 출력함으로써 I/O 효율성을 높이기
        System.out.print(sb.toString());
    }
}
/*
23252 KB / 348 ms
 */