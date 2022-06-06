package com.sparta.ja.controller;

import com.sparta.ja.model.BinaryTree;

public class App
{
    public static void main( String[] args )
    {
        BinaryTree tree = new BinaryTree(20);
        tree.addElement(25);
        tree.addElement(11);
        tree.addElement(89);
        tree.addElement(47);
        tree.addElement(3);
        tree.addElement(64);
        tree.addElement(112);

        System.out.println(tree.findElement(89));
    }
}
