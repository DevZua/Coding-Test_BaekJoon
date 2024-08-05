package com.sparta.codingtest.week3.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4_3184 {
    // 마당의 행과 열의 크기
    static int r, c;
    // 마당의 상태를 저장하는 2차원 배열
    static char[][] garden;
    // 이동방향을 나타내는 배열 ( 상, 하, 좌, 우 )
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄에서 마당의 행과 열 크기 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 마당의 상태를 저장할 배열 초기화
        garden = new char[r][c];

        // 마당의 각 행을 입력 받아 배열에 저장
        for (int i = 0; i < r; i++) {
            garden[i] = br.readLine().toCharArray();
        }

         // 총 살아남은 양과 늑대의 수를 저장할 변수 초기화
        int totalSheep = 0;
        int totalWolves = 0;

        // 모든 칸을 순회하며 양과 늑대의 수를 세기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 현재 칸이 양(o) 또는 늑대(v)인 경우 BFS 탐색 시작
                if (garden[i][j] == 'o' || garden[i][j] == 'v') {
                    // 현재 영역의 양과 늑대의 수를 계산
                    int[] result = bfs(i, j);
                    // 전체 양과 늑대의 수에 현재 영역의 결과를 합산
                    totalSheep += result[0];
                    totalWolves += result[1];
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolves);
    }

    private static int[] bfs(int startX, int startY) {
        // 현재 영역의 양과 늑대의 수를 저장할 변수 초기화
        int sheep = 0;
        int wolf = 0;

        // BFS 를 위한 큐 초기화
        Queue<int[]> queue = new LinkedList<>();
        // 시작 위치를 큐에 추가
        queue.offer(new int[]{startX, startY});

        // 시작점의 상태에 따라 양 또는 늑대의 수 증가
        if (garden[startX][startY] == 'o') {
            sheep++;
        } else if (garden[startX][startY] == 'v') {
            wolf++;
        }

        // 시작 위치를 방문 처리
        garden[startX][startY] = '#';

        // 큐가 빌 때까지 탐색
        while (!queue.isEmpty()) {
            // 큐에서 현재 위치를 꺼냄
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 네 방향으로 인접한 칸 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 위치인지, 그리고 울타리인지 확인
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && garden[nx][ny] != '#') {
                    // 인접한 칸이 양인지 늑대인지 확인하고 수 증가
                    if (garden[nx][ny] == 'o') {
                        sheep++;
                    } else if (garden[nx][ny] == 'v') {
                        wolf++;
                    }

                    // 인접한 칸을 방문 처리하고 큐에 추가
                    garden[nx][ny] = '#';
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        // 영역 내 양과 늑대의 수를 비교하여 결과 반환
        if (wolf >= sheep) {
            return new int[]{0, wolf};
        } else {
            return new int[]{sheep, 0};
        }
    }
}
/*
17612 KB / 164 ms
 */