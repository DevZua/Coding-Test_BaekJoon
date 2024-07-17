package com.sparta.codingtest.day1;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
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
