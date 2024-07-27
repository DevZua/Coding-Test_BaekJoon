package com.sparta.codingtest.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q4_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받기

        // 각 테스트 케이스 처리
        for (int i = 0; i < testCases; i++) {
            int costumeCount = Integer.parseInt(br.readLine()); // 의상 수 입력 받기
            Map<String, Integer> costumeMap = new HashMap<>(); // 의상 종류와 개수를 저장할 맵

            // 의상 정보 입력 받기
            for (int j = 0; j < costumeCount; j++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];
                costumeMap.put(type, costumeMap.getOrDefault(type, 0) + 1);
            }

            // 조합 계산
            int combinations = 1;
            for (int count : costumeMap.values()) {
                combinations *= (count + 1); // 입지 않는 경우를 포함하여 계산
            }
            sb.append(combinations - 1).append('\n'); // 최소 하나의 의상을 입어야 하므로 1을 뺌
        }

        System.out.print(sb); // 최종 결과 출력
    }
}
/*
14220 KB / 132 ms
 */
