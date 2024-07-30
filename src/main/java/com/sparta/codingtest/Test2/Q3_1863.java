package com.sparta.codingtest.Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q3_1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int answer = 0;
        // 스카이라인 높이를 저장할 배열. 높이의 마지막 값으로 0을 추가하기 위해 n+1 크기로 생성
        int[] skylines = new int[n + 1];

        // n개의 스카이라인 좌표를 일어들여 heights 배열에 저장
        for (int i = 0; i < n; i++) {
            // 스카이라인 좌표 읽어오기
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // x 좌표는 사용하지 않으니까 무시
            skylines[i] = Integer.parseInt(st.nextToken()); // y 좌표르 읽어 배열에 저장
        }
        // 스카이라인 배열의 마지막에 0을 추가하여 모든 스카이라인을 처리
        skylines[n] = 0;

        // 스택을 사용하여 현재까지의 스카이라인 높이를 관리
        Stack<Integer> stk = new Stack<>();
        stk.push(0); // 초기 스택에 0을 추가

        // 각 스카이라인 높이를 순회하며 처리
        for (int p : skylines) {
            int height = p; // 현재 높이

            // 현재 스택의 top 값이 현재 높이 p보다 크면
            // 이는 현재 높이로 인해 새로운 건물의 구간이 시작된다는 것을 의미
            while (!stk.isEmpty() && stk.peek() > p) {
                if (stk.peek() != height) {
                    answer++; // 높이 변화가 있을 때마다 최소 건물 개수 증가
                    height = stk.peek(); // 현재 높이로 업데이트
                }
                stk.pop(); // 현재 스택에서 높이를 제거
            }
            stk.push(p); // 현재 높이를 스택에 추가
        }
        System.out.println(answer);
    }
}
/*
19816 KB / 224 ms
 */