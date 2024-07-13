package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeRotate {

    static Node startNode = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char mid = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(startNode, mid, left, right);
        }

        topRecursion(startNode);
        System.out.println();
        midRecursion(startNode);
        System.out.println();
        bottomRecursion(startNode);
    }

    static class Node {
        private char value;
        private Node left;
        private Node right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void insertNode(Node temp, char root, char left, char right) {
        if (temp.value == root) {
            temp.left = left == '.' ? null : new Node(left, null, null);
            temp.right = right == '.' ? null : new Node(right, null, null);
        }
        else {
            if (temp.left != null) insertNode(temp.left, root, left, right);
            if (temp.right != null) insertNode(temp.right, root, left, right);
        }
    }

    static void topRecursion(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        topRecursion(node.left);
        topRecursion(node.right);
    }

    static void midRecursion(Node node) {
        if (node == null) return;
        midRecursion(node.left);
        System.out.print(node.value);
        midRecursion(node.right);
    }

    static void bottomRecursion(Node node) {
        if (node == null) return;
        bottomRecursion(node.left);
        bottomRecursion(node.right);
        System.out.print(node.value);
    }
    
}
