package com.sparta.codingtest.week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1_17608 {
    // StickCounter 인터페이스 정의: 막대기의 높이를 받아 보이는 막대기의 수를 반환하는 메서드를 포함
    interface StickCounter {
        int countVisibleSticks(int[] heights);
    }

    // StickCounterImpl 클래스는 StickCounter 인터페이스를 구현
    // 오른쪽에서 보이는 막대기의 수를 세는 로직을 포함
    static class StickCounterImpl implements StickCounter {
        @Override
        public int countVisibleSticks(int[] heights) {
            int max = heights[heights.length - 1]; // 배열의 마지막 원소를 초기 최대값으로 설정
            int count = 1; // 마지막 막대기는 항상 보이므로 초기값 1

            // 배열을 뒤에서부터 앞으로 순회하면서 보이는 막대기 수를 셈
            for (int i = heights.length - 2; i >= 0; i--) {
                if (heights[i] > max) { // 현재 막대기가 최대값보다 크면
                    max = heights[i]; // 최대값 갱신
                    count++; // 보이는 막대기 수 증가
                }
            }
            return count; // 보이는 막대기 수 반환
        }
    }

    private final StickCounter stickCounter; // StickCounter 인터페이스 타입의 필드

    // 의존성 주입을 위한 생성자
    public Q1_17608(StickCounter stickCounter) {
        this.stickCounter = stickCounter;
    }

    // 프로그램 실행 메서드
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 읽기 위한 BufferedReader
        int N = Integer.parseInt(br.readLine()); // 막대기의 개수를 입력받음

        int[] heights = new int[N]; // 막대기의 높이를 저장할 배열
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine()); // 각 막대기의 높이를 배열에 저장
        }

        int result = stickCounter.countVisibleSticks(heights); // 보이는 막대기 수 계산
        System.out.println(result); // 결과 출력
    }

    // 프로그램의 진입점
    public static void main(String[] args) throws IOException {
        Q1_17608 App = new Q1_17608(new StickCounterImpl()); // StickCounterImpl 객체를 생성하고 Main 클래스에 주입
        App.run(); // 프로그램 실행
    }

    /*
    22172 KB / 252 ms
     */
}
