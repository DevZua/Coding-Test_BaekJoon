package com.sparta.codingtest.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q2_1417 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader 를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 우선순위 큐를 생성. 득표수가 많은 후보가 먼저 나오도록 설정
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // 첫 줄에서 후보의 수를 입력받기
        int num = Integer.parseInt(br.readLine());
        int[] dasom = new int[2];  // 다솜의 번호와 득표수를 저장할 배열

        // 각 후보의 득표수를 입력받기
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                // 첫 번째 입력은 다솜의 득표수
                dasom = new int[]{i + 1, Integer.parseInt(br.readLine())};
            } else {
                // 나머지 후보들은 우선순위 큐에 추가
                maxHeap.offer(new int[]{i + 1, Integer.parseInt(br.readLine())});
            }
        }

        int count = 0;  // 매수한 사람의 수를 세기 위한 변수
        // 다솜의 득표수가 가장 많은 후보의 득표수보다 작거나 같으면 반복
        while (!maxHeap.isEmpty() && dasom[1] <= maxHeap.peek()[1]) {
            // 가장 득표수가 많은 후보를 우선순위 큐에서 꺼냅니다.
            int[] target = maxHeap.poll();

            // 그 후보의 득표수를 하나 줄이고 다솜의 득표수를 하나 증가
            target[1] -= 1;
            dasom[1] += 1;
            count++;  // 매수한 사람의 수를 증가시킵니다.

            // 후보를 다시 우선순위 큐에 추가
            maxHeap.offer(target);
        }

        // 다솜이 매수해야 하는 사람의 최소값을 출력
        System.out.println(count);
    }
}
/*
 14628 KB / 128 ms
 */
