package com.sparta.codingtest.Test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1_26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>(); // 학생들이 대기하는 큐를 생성
        int maxWaitCount = 0; // 최대 대기 학생수를 저장할 변수
        int maxWaitStudent = 0; // 최대 대기 학생 수 일 때 맨 뒤에 있는 학생 번호를 저장할 수

        // n개의 정보를 순서대로 처리
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) { // 유형 1: 학생 도착
                int studentNumber = Integer.parseInt(st.nextToken()); // 두 번째 값은 학생 번호
                queue.offerLast(studentNumber);  // 큐의 맨 뒤에 학생 추가

                // 현재 대기 학생 수와 최대 대기 학생 수를 비교하여 갱신
                int currentWaitCount = queue.size();
                if (currentWaitCount > maxWaitCount ||
                        (currentWaitCount == maxWaitCount && queue.peekLast() < maxWaitStudent)) {
                    maxWaitCount = currentWaitCount; // 최대 대기 학생 수 갱신
                    maxWaitStudent = queue.peekLast(); // 최대 대기 학생 수일 때 맨 뒤 학생번호 갱신
                }
            } else if (type == 2) { // 유형 2: 식사 준비 완료
                if (!queue.isEmpty()) {
                    queue.pollFirst(); // 큐의 맨 앞 학생 제거(식사 시작)
                }
            }
        }
        // 최대 대기 상태를 출력
        System.out.println(maxWaitCount + " " + maxWaitStudent);
    }
}
/*
39952 KB / 384 ms
 */