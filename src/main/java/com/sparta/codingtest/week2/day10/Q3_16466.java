package com.sparta.codingtest.week2.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_16466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 팔린 티켓의 수를 입력
        int length = Integer.parseInt(br.readLine().trim());
        // 조건에서 주어진 것처럼 최대 티켓 번호를 1,000,000으로 가정하여 boolean 배열을 생성
        boolean[] sold = new boolean[1000001];
        // 한 줄의 입력에서 팔린 티켓 번호들을 공백으로 구분하여 읽어옴
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 팔린 티켓 번호를 배열에 기록
        for (int i = 0; i < length; i++) {
            sold[Integer.parseInt(st.nextToken())] = true; // 팔린 티켓 번호를 기록하는 데 사용
        }
        // 1부터 시작하여 미판매 티켓 번호를 찾음
        for (int i = 1; i < 1000001; i++) {
            if (!sold[i]) { // 미판매 티켓 번호를 발견하면 출력하고 종료
                System.out.println(i);
                break;
            }
        }
    }
}
/*
88272 KB / 464 ms
 */