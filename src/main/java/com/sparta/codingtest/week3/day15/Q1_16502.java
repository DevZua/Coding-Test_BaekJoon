package com.sparta.codingtest.week3.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1_16502 {
    // 인접 리스트와 결과 맵 초기화
    static Map<Character, List<Node>> adjList = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Double> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 움직일 수 있는 횟수 읽기
        int moveCnt = Integer.parseInt(br.readLine());

        // 두 번째 줄에서 간선의 개수 읽기
        int vertex = Integer.parseInt(br.readLine());

        // 매장 노드(A, B, C, D)와 결과 초기화
        // 각 매장 노드에 대한 인접 리스트 초기화
        adjList.put('A', new ArrayList<>());
        adjList.put('B', new ArrayList<>());
        adjList.put('C', new ArrayList<>());
        adjList.put('D', new ArrayList<>());

        // 각 매장 노드에 대한 초기 확률 결과 초기화
        result.put('A', 0.0);
        result.put('B', 0.0);
        result.put('C', 0.0);
        result.put('D', 0.0);

        // 간선 정보를 읽어들여 인접 리스트에 추가
        for (int i = 0; i < vertex; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char from = st.nextToken().charAt(0);  // 출발 노드
            char to = st.nextToken().charAt(0);    // 도착 노드
            double weight = Double.parseDouble(st.nextToken());  // 간선 가중치 (확률)

            // 인접 리스트에 간선 추가
            adjList.get(from).add(new Node(to, weight));
        }

        // 각 시작 정점(A, B, C, D)에서 DFS 를 호출하여 확률 계산
        dfs('A', moveCnt, 0.25);  // A에서 출발할 확률 0.25로 DFS 호출
        dfs('B', moveCnt, 0.25);  // B에서 출발할 확률 0.25로 DFS 호출
        dfs('C', moveCnt, 0.25);  // C에서 출발할 확률 0.25로 DFS 호출
        dfs('D', moveCnt, 0.25);  // D에서 출발할 확률 0.25로 DFS 호출

        // 결과 출력: 각 매장에 도착할 확률을 100을 곱하여 백분율로 변환
        sb.append(String.format("%.2f\n", result.get('A') * 100));
        sb.append(String.format("%.2f\n", result.get('B') * 100));
        sb.append(String.format("%.2f\n", result.get('C') * 100));
        sb.append(String.format("%.2f\n", result.get('D') * 100));
        System.out.println(sb.toString());
    }

    // DFS 메소드 정의
    static void dfs(char startNode, int moveCnt, double probability) {
        // 이동 횟수가 0이 되면 현재 노드에 대한 확률을 결과 맵에 누적
        if (moveCnt == 0) {
            result.put(startNode, result.getOrDefault(startNode, 0.0) + probability);
            return;
        }

        // 현재 노드에서 가능한 모든 이동에 대해 DFS 호출
        List<Node> edges = adjList.get(startNode);
        if (edges != null) {
            for (Node node : edges) {
                // 다음 노드로 이동하며 확률을 누적하고 DFS 호출
                dfs(node.to, moveCnt - 1, probability * node.weight);
            }
        }
    }

    // Node 클래스 정의
    static class Node {
        char to;      // 도착 노드
        double weight; // 간선 가중치 (확률)

        // Node 클래스의 생성자
        public Node(char to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
/*
14420 KB / 132 ms
 */