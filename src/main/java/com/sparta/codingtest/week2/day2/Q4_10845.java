package com.sparta.codingtest.week2.day2;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q4_10845 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 출력을 위한 BufferedWriter 초기화
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수를 저장할 큐(Deque) 초기화
        Deque<Integer> queue = new LinkedList<>();

        // 명령의 수 입력
        int N = Integer.parseInt(reader.readLine());

        // 각 명령어 처리
        for (int i = 0; i < N; i++) {
            // 명령어와 인자를 분리하기 위한 StringTokenizer
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String command = st.nextToken(); // 명령어

            switch (command) {
                case "push":
                    // push 명령어의 경우, 큐에 정수를 추가
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    // pop 명령어의 경우, 큐에서 가장 앞에 있는 정수를 제거하고 출력
                    // 큐가 비어있으면 -1 출력
                    writer.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
                    break;
                case "size":
                    // size 명령어의 경우, 큐의 크기 출력
                    writer.write(queue.size() + "\n");
                    break;
                case "empty":
                    // empty 명령어의 경우, 큐가 비어있으면 1, 아니면 0 출력
                    writer.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    // front 명령어의 경우, 큐의 앞쪽 정수 출력
                    // 큐가 비어있으면 -1 출력
                    writer.write((queue.isEmpty() ? -1 : queue.peek()) + "\n");
                    break;
                case "back":
                    // back 명령어의 경우, 큐의 뒤쪽 정수 출력
                    // 큐가 비어있으면 -1 출력
                    writer.write((queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
                    break;
                default:
                    break;
            }
        }

        // BufferedWriter를 사용한 출력 최적화
        writer.flush();
        writer.close();
        reader.close();
    }
}
/*
20186 KB / 192 ms
 */
