package com.will.asgard.loki.model.structure.tree.avltree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName AVLTreeTest
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-03-23 15:28
 * @Version 1.0
 **/
public class AVLTreeTest {

	@Test
	public void testInsertNode() {
		AVLTree<Integer> avlTree = new AVLTree<>();
		avlTree.insert(3);
		avlTree.insert(2);
		avlTree.insert(1);
		avlTree.insert(4);
		avlTree.insert(5);
		avlTree.insert(6);
		avlTree.insert(7);
		avlTree.insert(16);
		avlTree.insert(15);
		avlTree.insert(14);
		avlTree.insert(13);
		avlTree.insert(12);
		avlTree.insert(11);
		avlTree.insert(10);
		avlTree.insert(8);
		avlTree.insert(9);
		avlTree.remove(8);

		System.out.println("height: " + avlTree.height());
		System.out.print("前序遍历: ");
		avlTree.preOrder();
		System.out.print("中序遍历: ");
		avlTree.inOrder();
		System.out.print("后序遍历: ");
		avlTree.postOrder();
	}
}