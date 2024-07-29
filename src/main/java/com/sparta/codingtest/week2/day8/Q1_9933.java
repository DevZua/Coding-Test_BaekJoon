package com.sparta.codingtest.week2.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q1_9933 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 단어의 수를 입력받기
        int num = Integer.parseInt(br.readLine());

        // 단어를 저장할 HashSet을 생생
        Set<String> set = new HashSet<>();

        // 최소 힙을 사용하기 위해 PriorityQueue를 생성
        PriorityQueue<String> minHeap = new PriorityQueue<>();

        // 입력된 단어를 저장할 배열을 생성
        String[] arr = new String[num];

        // 비밀번호를 저장할 변수를 만듦
        String answer = "";

        // 각 단어를 입력받아 처리
        for (int i = 0; i < num; i++) {
            // 단어를 읽습니다.
            String str = br.readLine();

            // HashSet에 단어를 추가
            set.add(str);

            // 최소 힙에 단어를 추가
            minHeap.offer(str);

            // 배열에도 단어를 저장
            arr[i] = str;
        }

        // 최소 힙이 빌 때까지 반복
        while (!minHeap.isEmpty()) {
            // 최소 힙에서 가장 작은 단어를 꺼낸다
            String original = minHeap.poll();

            // 단어를 뒤집어서 reversed 변수에 저장
            String reversed = new StringBuilder(original).reverse().toString();

            /*
             * 1. 뒤집은 문자열(reversed)이 HashSet에 있는지 확인
             * 2. 있다면 비밀번호로 간주하고, 문자열의 길이와 가운데 글자를 answer 변수에 저장
             */
            if (set.contains(reversed)) {
                // 비밀번호의 길이와 가운데 글자를 저장
                answer = reversed.length() + " " + reversed.charAt(reversed.length() / 2);
                break;  // 비밀번호를 찾았으므로 반복을 종료
            }
        }

        // 최종 결과를 출력
        System.out.print(answer);
    }
}
/*
15972 KB / 152 ms
 */
