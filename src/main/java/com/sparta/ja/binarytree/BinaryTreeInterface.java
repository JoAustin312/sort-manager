package com.sparta.ja.binarytree;

import com.sparta.ja.exceptions.ChildNotFoundException;
import com.sparta.ja.exceptions.NodeNotFoundException;

public interface BinaryTreeInterface {

        int getRootElement();

        int getNumberOfElements();

        void addElement(int element);

        void addElements(final int[] elements);

        boolean findElement(int value);

        int getLeftChild(int element) throws ChildNotFoundException, NodeNotFoundException;

        int getRightChild(int element) throws ChildNotFoundException, NodeNotFoundException;

        int[] getSortedTreeAsc();

        int[] getSortedTreeDesc();
}
