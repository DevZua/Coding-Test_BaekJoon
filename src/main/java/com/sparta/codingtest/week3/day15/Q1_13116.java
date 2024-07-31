package com.sparta.codingtest.week3.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1_13116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 수를 읽어들임
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 각 테스트 케이스를 처리
        while (T-- > 0) {
            // 입력된 두 정수 a와 b를 읽어들임
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // 각 숫자의 경로를 저장할 Stack 객체 생성
            Stack<Integer> stackA = new Stack<>();
            Stack<Integer> stackB = new Stack<>();

            // 숫자 a의 경로를 스택에 저장(부모의 노드를 따라가며)
            while (a > 0) {
                stackA.push(a);
                a /= 2;
            }

            // 숫자 b의 경로를 스택에 저장(부모의 노드를 따라가며)
            while (b > 0) {
                stackB.push(b);
                b /= 2;
            }

            int ans = 1; // 공통 조상의 초기값(루트 노드인 1로 초기화)

            // 두 스택에서 공통 조상을 찾기 위해 스택의 최상단을 비교
            while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek().equals(stackB.peek())) {
                ans = stackA.peek(); // 공통 조상을 갱신
                stackA.pop(); // 스택에서 노드 제거
                stackB.pop(); // 스택에서 노드 제거
            }

            // 공통 조상의 10배 값을 결과에 추가
            sb.append(ans * 10).append("\n");
        }
        System.out.println(sb);
    }
}
/*
50612 KB / 492 ms
 */