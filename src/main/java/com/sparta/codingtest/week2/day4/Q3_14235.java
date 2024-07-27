package com.sparta.codingtest.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q3_14235 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 결과를 저장할 StringBuilder를 생성
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄에서 연산의 개수를 입력받음
        int num = Integer.parseInt(br.readLine());
        // 내림차순으로 정렬되는 PriorityQueue를 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // 연산의 개수만큼 반복합니다.
        for (int i = 0; i < num; i++) {
            // 각 줄의 입력을 공백으로 구분하여 배열에 저장
            String[] arr = br.readLine().split(" ");
            // 첫 번째 값인 order를 정수로 변환
            int order = Integer.parseInt(arr[0]);

            // order가 0이 아닌 경우 (선물 추가)
            if (order != 0) {
                // 두 번째 값부터 순서대로 선물의 가치를 PriorityQueue에 추가
                for (int j = 1; j < arr.length; j++) {
                    pq.offer(Integer.parseInt(arr[j]));
                }
            } else {
                // order가 0인 경우 (가장 큰 선물 제거)
                // PriorityQueue가 비어 있으면 -1을, 비어 있지 않으면 가장 큰 값을 꺼낸다.
                sb.append(pq.isEmpty() ? "-1" : pq.poll()).append('\n');
            }
        }

        // 최종 결과를 출력
        System.out.print(sb);
    }
}
/*
40144 KB / 408 ms
 */