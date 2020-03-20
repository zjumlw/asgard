package com.will.asgard.loki.model.structure.tree.avltree;

/**
 * @ClassName AVLTree
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-03-20 17:00
 * @Version 1.0
 **/
public class AVLTree<E extends Comparable<E>> {
	private AVLNode root;

	public AVLTree() {
		this.root = null;
	}

	public void insert(E e) {
		root = insert(e, root);
	}

	public AVLNode<E> insert(E e, AVLNode<E> t) {
		if (t == null) {
			return new AVLNode<>(e);
		}

		int compareResult = e.compareTo(t.element);
		if (compareResult < 0) {
			t.left = insert(e, t.left);
			if (height(t.left) - height(t.right) == 2) {
				if (e.compareTo(t.left.element) < 0) {
					t = rightRotate(t);
				} else {
					t = leftAndRightRotate(t);
				}
			}
		} else if (compareResult > 0) {
			t.right = insert(e, t.right);
			if (height(t.right) - height(t.left) == 2) {
				if (e.compareTo(t.right.element) > 0) {
					t = leftRotate(t);
				} else {
					t = rightAndLeftRotate(t);
				}
			}
		} else {
			// Already has the node
		}
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private AVLNode<E> rightRotate(AVLNode<E> t) {
		AVLNode<E> newTree = t.left;
		t.left = newTree.right;
		newTree.right = t;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		newTree.height = Math.max(height(newTree.left), height(newTree.right)) + 1;
		return newTree;
	}

	private AVLNode<E> leftRotate(AVLNode<E> t) {
		AVLNode<E> newTree = t.right;
		t.right = newTree.left;
		newTree.left = t;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		newTree.height = Math.max(height(newTree.left), height(newTree.right)) + 1;
		return newTree;
	}




	private int height(AVLNode<E> t) {
		return t == null ? -1 : t.height;
	}

	private static class AVLNode<E> {
		private E element;
		private AVLNode<E> left;
		private AVLNode<E> right;
		private int height;

		public AVLNode(E element) {
			this.element = element;
		}

		public AVLNode(E element, AVLNode<E> left, AVLNode<E> right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
}
