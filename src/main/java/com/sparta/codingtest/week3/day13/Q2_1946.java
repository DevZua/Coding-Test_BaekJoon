package com.sparta.codingtest.week3.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int testCaseCount = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        while (testCaseCount-- > 0) {
            // 각 테스트 케이스의 지원자 수 입력
            int applicantCount = Integer.parseInt(br.readLine());

            // 서류 심사 순위를 인덱스로 하여 면접 심사 순위를 저장할 배열
            int[] interviewRanks = new int[applicantCount];

            // 지원자 정보 입력
            for (int i = 0; i < applicantCount; i++) {
                st = new StringTokenizer(br.readLine());
                int paperRank = Integer.parseInt(st.nextToken()); // 서류 심사 순위
                int interviewRank = Integer.parseInt(st.nextToken()); // 면접 심사 순위
                // 서류 심사 순위를 인덱스로 하여 면접 심사 순위를 저장
                interviewRanks[paperRank - 1] = interviewRank;
            }

            // 선발할 지원자의 수를 계산
            int selectedCount = 1; // 첫 번째 지원자는 무조건 선발
            int bestInterviewRank = interviewRanks[0]; // 첫 번째 지원자의 면접 순위

            // 선발할 지원자의 수를 계산
            for (int i = 1; i < applicantCount; i++) {
                // 현재 지원자의 면접 순위가 이전 지원자의 면접 순위보다 높으면 선발
                if (interviewRanks[i] < bestInterviewRank) {
                    selectedCount++;
                    bestInterviewRank = interviewRanks[i]; // 새로운 기존 면접 순위 업데이트
                }
            }
            // 결과를 StringBuilder 에 저장
            sb.append(selectedCount).append('\n');
        }
        System.out.println(sb.toString());
    }
}
/*
30324 KB / 888 ms
 */