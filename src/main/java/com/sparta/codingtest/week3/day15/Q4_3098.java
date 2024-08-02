package com.sparta.codingtest.week3.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q4_3098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수 N과 초기 친구 관계의 수 M을 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 초기 친구 관계의 수

        // 친구 관계를 나타내는 2차원 배열 초기화
        int[][] map = new int[51][51];
        int total = 0; // 총 친구 관계 수
        int val = 1; // 친구 관계 형성 단계

        // 초기 친구 관계 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = val;
            map[B][A] = val;
            total++;
        }

        List<Integer> newFriendshipsPerDay = new ArrayList<>();

        // 모든 사람들이 친구가 될 때까지 반복
        while (true) {
            int before = total; // 새로운 친구 관계 형성 전의 총 친구 관계 수
            val++; // 새로운 친구 관계 형성 단계 증가

            // 친구의 친구를 친구로 만드는 과정
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > 0 && map[i][j] < val && i != j) {
                        for (int z = 1; z <= N; z++) {
                            if (map[j][z] > 0 && map[j][z] < val && i < z) {
                                if (map[i][z] == 0) {
                                    map[i][z] = map[z][i] = val;
                                    total++;
                                }
                            }
                        }
                    }
                }
            } // 친구만들기 참 힘드네

            // 하루 동안 새로 형성된 친구 관계 수 계산
            int dayTotal = total - before;
            newFriendshipsPerDay.add(dayTotal);

            // 모든 사람들이 친구가 되는 경우 종료
            if (total == (N * (N - 1)) / 2) {
                break;
            }
        }

        // 결과 출력
        System.out.println(newFriendshipsPerDay.size());
        for (int day : newFriendshipsPerDay) {
            System.out.println(day);
        }
    }
}
/*
14264 KB / 108 ms
 */