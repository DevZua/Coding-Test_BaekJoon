package com.sparta.codingtest.week2.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 수를 입력받음
        int num = Integer.parseInt(br.readLine());

        // 각 테스트 케이스를 처리
        for (int i = 0; i < num; i++) {
            // 테스트 케이스 사 이의 빈 줄을 읽음(사실 필요 없음)
            br.readLine();
            // 세준과 세비의 병사 수를 읽어옴
            String[] count = br.readLine().split(" ");
            int seJunCount = Integer.parseInt(count[0]);
            int seBiCount = Integer.parseInt(count[1]);

            // 세준과 세비의 벼 ㅇ사들 중에서 최댓값을 저장할 변수
            int seJunMax = 0;
            int seBiMax = 0;

            // 세준 병사들의 힘을 입력받고 최댓값을 계산
            String[] seJunPowers = br.readLine().split(" ");
            for (int j = 0; j < seJunCount; j++) {
                int power = Integer.parseInt(seJunPowers[j]);
                seJunMax = Math.max(seJunMax, power);
            }

            // 세비 병사들의 힘을 입력받고 최댓값을 계산
            String[] seBiPowers = br.readLine().split(" ");
            for (int j = 0; j < seBiCount; j++) {
                int power = Integer.parseInt(seBiPowers[j]);
                seBiMax = Math.max(seBiMax, power);
            }

            // 세준과 세비의 최대 힘을 비교하여 승자를 결정
            if (seJunMax > seBiMax) {
                sb.append('S').append('\n'); // 세준이 승리
            } else if (seJunMax < seBiMax) {
                sb.append('B').append('\n'); // 세비가 승리
            } else {
                sb.append('S').append('\n'); // 힘이 같을 경우 세준이 승리
            }
        }
        // 모든 결과를 한 번에 출력
        System.out.println(sb);
    }
}
/*
63712 KB / 484 ms
 */
