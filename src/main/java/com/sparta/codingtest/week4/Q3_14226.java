package com.sparta.codingtest.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q3_14226 {
    // 최대 이모티콘 수를 1000으로 설정
    private static final int MAX = 1001;

    public static void main(String[] args) throws IOException {
        // 입력을 읽기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 목표 이모티콘 수 S를 입력받음
        int S = Integer.parseInt(br.readLine());

        // BFS를 위한 큐 생성 (화면 이모티콘 개수, 클립보드 이모티콘 개수, 연산 횟수)
        Deque<int[]> queue = new ArrayDeque<>();
        // 큐에 시작 상태 추가: [화면의 이모티콘 개수, 클립보드 이모티콘 개수, 연산 횟수]
        queue.add(new int[]{1, 0, 0});

        // 방문 상태를 체크하기 위한 2차원 배열 초기화
        // visited[i][j]는 화면에 i개, 클립보드에 j개 있는 상태를 방문했는지 여부를 나타냄
        boolean[][] visited = new boolean[MAX][MAX];
        visited[1][0] = true; // 초기 상태는 방문한 것으로 설정

        // 큐가 빌 때까지 BFS 탐색 수행
        while (!queue.isEmpty()) {
            // 큐에서 현재 상태를 꺼냄
            int[] current = queue.poll();
            int screen = current[0]; // 현재 화면의 이모티콘 개수
            int clipboard = current[1]; // 현재 클립보드의 이모티콘 개수
            int cnt = current[2]; // 현재까지의 연산 횟수

            // 현재 화면 이모티콘 개수가 목표 S와 같으면 연산 횟수 출력 후 종료
            if (screen == S) {
                System.out.println(cnt);
                return;
            }

            // 1. 화면에 있는 이모티콘을 클립보드에 복사
            if (screen < MAX && !visited[screen][screen]) {
                visited[screen][screen] = true; // 새 상태를 방문 처리
                queue.add(new int[]{screen, screen, cnt + 1}); // 새 상태를 큐에 추가
            }

            // 2. 클립보드의 이모티콘을 화면에 붙여넣기
            if (clipboard > 0 && screen + clipboard < MAX && !visited[screen + clipboard][clipboard]) {
                visited[screen + clipboard][clipboard] = true; // 새 상태를 방문 처리
                queue.add(new int[]{screen + clipboard, clipboard, cnt + 1}); // 새 상태를 큐에 추가
            }

            // 3. 화면에서 이모티콘 하나 삭제
            if (screen > 0 && !visited[screen - 1][clipboard]) {
                visited[screen - 1][clipboard] = true; // 새 상태를 방문 처리
                queue.add(new int[]{screen - 1, clipboard, cnt + 1}); // 새 상태를 큐에 추가
            }
        }
    }
}
/*
15652 KB / 112 ms
 */