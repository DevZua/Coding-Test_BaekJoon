package com.sparta.codingtest.week3.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_21938 {
    // 화면의 세로 크기, 가로 크기, 경계값 T
    static int N, M, T;
    // 이동 방향을 나타내는 배열(상, 하, 좌, 우)
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    // 평균 값을 저장할 2차원 배열
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로 크기 N과 가로 크기 M을 입력받음
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // graph 배열 초기화
        graph = new int[N][M];

        // N개의 줄에 걸쳐 픽셀 값 입력 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 각 픽셀의 R, G, B 값을 읽어서 평균을 계산
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int avg = (R + G + B) / 3;
                graph[i][j] = avg; // 평균 값을 graph 배열에 저장
            }
        }
        // 마지막 줄에서 경계값 T를 입력받음
        T = Integer.parseInt(br.readLine());

        // 경계값 T에 따라 픽셀 값을 255 또는 0으로 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 평균값이 T 이상이면 255 아니면 0
                graph[i][j] = (graph[i][j] >= T) ? 255 : 0;
            }
        }

        // 물체의 개수를 세기 위한 변수 초기화
        int objectCount = 0;
        // 화면의 모든 픽셀을 순회하며 물체의 개수를 셈
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                // 현재 픽셀이 물체(255)인 경우
                if (graph[x][y] == 255) {
                    // DFS 를 통해 연결된 물체를 찾음
                    dfs(x, y);
                    // 물체의 개수 증가
                    objectCount++;
                }
            }
        }
        System.out.println(objectCount);
    }

    private static void dfs(int y, int x) {
        // 방문 처리: 255 -> -1  graph 배열의 값이 255인 경우 방문한 것으로 처리하기 위해 -1로 변경.
        graph[y][x] = -1;

        // 네 방향으로 인접한 칸 탐색
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 유효한 위치인지, 그리고 물체(255)인지 확인
            if (ny >= 0 && ny < N && nx >= 0 && nx < M && graph[nx][ny] == 255) {
                // DFS 로 재귀호출하여 연결된 모든 칸 방문 처리
                dfs(ny, nx);
            }
        }
    }
}
/*
112272 KB / 552 ms
 */