package org.dataart.codetest.one;

import org.dataart.codetest.one.model.BinaryTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BinaryTreeCodeChallenge {

    private static final String FILE_NAME = "solution.txt";

    public static void main(String[] args) throws IOException {
        PrintWriter printer = new PrintWriter(new FileWriter(String.format("%s%s%s", System.getProperty("user.dir"),
                File.separator, FILE_NAME)));
        final BinaryTree tree = new BinaryTree()
                .addNode("node_1")
                .addNode("node_2")
                .addNode("node_3")
                .addNode("node_4")
                .addNode("node_5")
                .addNode("node_6")
                .addNode("node_7")
                .addNode("node_8")
                .addNode("node_9")
                .addNode("node_10")
                .addNode("node_11")
                .addNode("node_12");

        printer.println("IN ORDER:");
        printer.println(tree.inOrderTraversal());
        printer.println("PRE ORDER:");
        printer.println(tree.preOrderTraversal());
        printer.println("POST ORDER:");
        printer.println(tree.postOrderTraversal());
        printer.close();
    }

}
