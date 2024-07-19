package com.sparta.codingtest.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int inputTime = Integer.parseInt(st.nextToken());

        second += inputTime;
        minute += second / 60;  // second 가 60초 이상 돼서 초를 60으로 나눈 몫을 minute 에 추가
        second %= 60;  // 초를 60으로 나눈 나머지 값으로 업데이트
        hour += minute / 60; // 시간에 분을 60으로 나눈 몫을 추가
        minute %= 60;  // 분을 60으로 나눈 나머지로 업데이트
        hour %= 24;  // 시간을 24로 나눈 나머지로 업데이트

        System.out.println(hour + " " + minute + " " + second);
    }
}

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 현재 시간 입력 받기
        int A = scanner.nextInt(); // 시
        int B = scanner.nextInt(); // 분
        int C = scanner.nextInt(); // 초

        // 요리 시간 입력 받기
        int D = scanner.nextInt(); // 요리 시간(초 단위)
        scanner.close();

        // 현재 시간을 초 단위로 변경
        int totalSeconds = A * 3600 + B * 60 + C + D;

        // 총 초를 시, 분, 초 단위로 변환
        int hours = (totalSeconds / 3600) % 24;
        int minutes = (totalSeconds / 60) % 60;
        int seconds = totalSeconds % 60;

        // 결과 출력
        System.out.println(hours + " " + minutes + " " + seconds);
    }
}

     */
