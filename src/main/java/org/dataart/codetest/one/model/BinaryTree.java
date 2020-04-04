package org.dataart.codetest.one.model;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public BinaryTree addNode(String nodeName) {
        if (root == null) {
            root = new Node(nodeName);
            return this;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.peek();
            queue.remove();

            if (temp.leftChild == null) {
                temp.leftChild = new Node(nodeName);
                break;
            } else {
                queue.add(temp.leftChild);
            }

            if (temp.rightChild == null) {
                temp.rightChild = new Node(nodeName);
                break;
            } else {
                queue.add(temp.rightChild);
            }
        }

        return this;
    }

    public String inOrderTraversal() {
        return root != null ? root.inOrder(): "";
    }

    public String preOrderTraversal() {
        return root != null ? root.preOrder(): "";
    }

    public String postOrderTraversal() {
        return root != null ? root.postOrder(): "";
    }

    static class Node {
        final static String OUT_PUT_FORMAT = "%s%s%s";

        final String name;
        Node leftChild;
        Node rightChild;

        Node(String name) {
            this.name = name;
        }

        String inOrder() {
            return String.format(OUT_PUT_FORMAT,
                    leftChild != null ? leftChild.inOrder() : "",
                    name + " ",
                    rightChild != null ? rightChild.inOrder() : "");
        }

        String preOrder() {
            return String.format(OUT_PUT_FORMAT,
                    name + " ",
                    leftChild != null ? leftChild.preOrder() : "",
                    rightChild != null ? rightChild.preOrder() : "");
        }

        String postOrder() {
            return String.format(OUT_PUT_FORMAT,
                    leftChild != null ? leftChild.postOrder() : "",
                    rightChild != null ? rightChild.postOrder() : "",
                    name + " ");
        }
    }
}
