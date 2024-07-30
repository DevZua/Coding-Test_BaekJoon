package com.sparta.codingtest.Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2_13975 {

    // 두 개의 파일을 합치는 최소 비용을 계산하는 메서드
    private static long calculateMinCost(PriorityQueue<Long> pq) {
        long totalCost = 0;

        // 파일이 2개 이상 남아 있알 때까지 반복
        while (pq.size() > 1) {
            // 두 개의 가장 작은 파일을 꺼냄
            long file1 = pq.poll();
            long file2 = pq.poll();
            long mergeCost = file1 + file2;

            //  현재 합치는 데 비용을 누적
            totalCost += mergeCost;
            // 합쳐진 파을 다시 큐에 추가
            pq.add(mergeCost);
        }
        return totalCost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine().trim()); // 파일의 개수
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 우선순위 큐를 생성(자동으로 최소 힙을 구현하기)
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken())); // 파일 크기를 큐에 추가
            }

            // 최소 비용을 계산
            long result = calculateMinCost(pq);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
/*
 278848 KB / 3188 ms
 */