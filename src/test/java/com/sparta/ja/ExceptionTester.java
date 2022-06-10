package com.sparta.ja;

import com.sparta.ja.exceptions.ChildNotFoundException;
import com.sparta.ja.exceptions.NodeNotFoundException;
import com.sparta.ja.exceptions.SorterNotFoundException;
import com.sparta.ja.sorters.binarytree.BinaryTree;
import com.sparta.ja.start.SortManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTester {

    @Test
    @DisplayName("Check ChildNotFoundException is thrown")
    void checkChildNotFoundExceptionThrown(){
        BinaryTree tree = new BinaryTree(10);
        assertThrows(ChildNotFoundException.class, () -> tree.getLeftChild(10));
    }

    @Test
    @DisplayName("Check ChildNotFoundException is not thrown")
    void checkChildNotFoundExceptionNotThrown(){
        BinaryTree tree = new BinaryTree(10);
        tree.addElement(5);
        assertDoesNotThrow(() -> tree.getLeftChild(10));
    }

    @Test
    @DisplayName("Check NodeNotFoundException is thrown")
    void checkNodeNotFoundExceptionThrown(){
        BinaryTree tree = new BinaryTree(10);
        assertThrows(NodeNotFoundException.class, () -> tree.getLeftChild(5));
    }

    @Test
    @DisplayName("Check NodeNotFoundException is not thrown")
    void checkNodeNotFoundExceptionNotThrown(){
        BinaryTree tree = new BinaryTree(10);
        tree.addElement(5);
        assertDoesNotThrow(() -> tree.getLeftChild(10));
    }

    @Test
    @DisplayName("Check SorterNotFoundException is thrown")
    void checkSorterNotFoundExceptionThrown(){
        assertThrows(SorterNotFoundException.class, () -> SortManager.getSorter(5));
    }

    @Test
    @DisplayName("Check SorterNotFoundException is not thrown")
    void checkSorterNotFoundExceptionNotThrown(){
        assertDoesNotThrow(() -> SortManager.getSorter(1));
    }
}
