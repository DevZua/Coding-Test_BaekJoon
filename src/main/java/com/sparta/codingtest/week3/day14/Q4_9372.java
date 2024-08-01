package com.sparta.codingtest.week3.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4_9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수를 입력함
        int test = Integer.parseInt(br.readLine().trim());

        // StringBuilder를 사용하여 결과를 모아서 한 번에 출력
        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스를 처리
        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            // 국가의 수와 비행기의 종류 수를 입력 받기
            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            // 주어진 비행기 경로는 읽기만 하고, 실제로 사용하지 않음
            for (int i = 0; i < edge; i++) {
                br.readLine();  // 비행기 경로 정보를 읽음
            }

            // 모든 국가를 여행하기 위해 필요한 최소한의 비행기 종류 수는 항상 node - 1 이다.
            sb.append(node - 1).append('\n');
        }
        System.out.print(sb.toString());
    }
}
/*
24080 KB / 232 ms
 */