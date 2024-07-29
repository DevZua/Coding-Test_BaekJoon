package com.sparta.codingtest.week2.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2_11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 테스트 케이스의 수 T를 입력받음
        int T = Integer.parseInt(br.readLine());

        // 각 테스트 케이스를 처리
        while (T-- > 0) {
            // 각 테스트 케이스의 첫 줄에서 학교의 수 N을 입력받음
            int N = Integer.parseInt(br.readLine());

            // 술 소비량이 가장 많은 학교의 이름과 해당 소비량을 저장할 변수 초기화
            String topSchool = ""; // 가장 많은 술 소비량을 기록한 학교 이름
            int maxConsumption = -1; // 가장 많은 술 소비량(초기 값은 -1로 설정하여 이후 모든 값과 비교 가능)

            // 학교의 정보를 N줄 입력받아 처리
            for (int i = 0; i < N; i++) {
                // 한 줄의 입력을 공백 기준으로 나눠서 학교 이름과 술 소비량을 추출
                String[] input = br.readLine().split(" ");
                String schoolName = input[0]; // 학교 이름
                int consumption = Integer.parseInt(input[1]); // 술 소비량

                // 현재 학교의 술 소비량이 지금까지 기록한 최대 소비량보다 크면 갱신
                if (consumption > maxConsumption) {
                    topSchool = schoolName;  // 가장 많은 소비량을 기록한 학교 이름 업데이트
                    maxConsumption = consumption; // 최대 소비량 업데이트
                }
            }
            System.out.println(topSchool);
        }
    }
}
/*
13928 KB / 120 ms
 */
