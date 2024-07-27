package com.sparta.codingtest.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q2_1927 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 결과를 저장할 StringBuilder를 생성
        StringBuilder sb = new StringBuilder();

        // 연산의 개수를 입력받기
        int num = Integer.parseInt(br.readLine());
        // 최소 힙을 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 연산의 개수만큼 반복
        for (int i = 0; i < num; i++) {
            // 연산을 입력받기
            int order = Integer.parseInt(br.readLine());

            if (order != 0) {
                // 0이 아닌 경우 최소 힙에 값을 추가
                pq.offer(order);
            } else {
                // 0인 경우 최소 힙에서 가장 작은 값을 출력
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            }
        }

        // 최종 결과를 출력
        System.out.println(sb);
    }
}
/*
26204 / 332 ms
 */
