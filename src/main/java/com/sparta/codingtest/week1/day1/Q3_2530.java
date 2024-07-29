package com.sparta.codingtest.week1.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 현재 시간 입력 받기
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        // 요리 시간 입력 받기
        int inputTime = Integer.parseInt(br.readLine());

        // 초 단위로 요리 시간 추가
        second += inputTime;

        // 초를 분으로 변환
        minute += second / 60;
        second %= 60;

        // 분을 시간으로 변환
        hour += minute / 60;
        minute %= 60;

        // 시간을 24시간 형식으로 변환
        hour %= 24;

        // 결과 출력
        System.out.println(hour + " " + minute + " " + second);
    }
}
/*
 16268 KB / 160 ms
 */

