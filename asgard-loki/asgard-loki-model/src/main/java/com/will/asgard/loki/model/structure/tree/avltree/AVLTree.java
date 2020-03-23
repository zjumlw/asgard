package com.will.asgard.loki.model.structure.tree.avltree;

/**
 * @ClassName AVLTree
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-03-20 17:00
 * @Version 1.0
 **/
public class AVLTree<E extends Comparable<E>> {
	private AVLNode<E> root;

	public AVLTree() {
		this.root = null;
	}

	public void insert(E e) {
		root = insert(e, root);
	}

	public void remove(E e) {
		remove(e, root);
	}

	private AVLNode<E> insert(E e, AVLNode<E> t) {
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

	private AVLNode<E> remove(E e, AVLNode<E> t) {
		if (t == null || e == null) {
			return null;
		}

		int compareResult = e.compareTo(t.element);
		if (compareResult < 0) {
			t.left = remove(e, t.left);
			// 删除节点后，如果avl树失去平衡，则进行相应的调整
			if (height(t.right) - height(t.left) == 2) {
				AVLNode<E> r = t.right;
				if (height(r.left) > height(r.right)) {
					t = rightAndLeftRotate(t);
				} else {
					t = leftRotate(t);
				}
			}
		} else if (compareResult > 0) {
			t.right = remove(e, t.right);
			if (height(t.left) - height(t.right) == 2) {
				AVLNode<E> l = t.left;
				if (height(l.right) > height(l.left)) {
					t = leftAndRightRotate(t);
				} else {
					t = rightRotate(t);
				}
			}
		} else {
			if (t.left != null && t.right != null) {
				if (height(t.left) > height(t.right)) {
					AVLNode<E> max = maximum(t.left);
					assert max != null;
					t.element = max.element;
					t.left = remove(max.element, t.left);
				} else {
					AVLNode<E> min = minimum(t.right);
					assert min != null;
					t.element = min.element;
					t.right = remove(min.element, t.right);
				}
			} else {
				t = (t.left != null) ? t.left : t.right;
			}
		}

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

	private AVLNode<E> leftAndRightRotate(AVLNode<E> t) {
		t.left = leftRotate(t.left);
		return rightRotate(t);
	}

	private AVLNode<E> rightAndLeftRotate(AVLNode<E> t) {
		System.out.println("rightAndLeftRotate: " + t.element);
		t.right = rightRotate(t.right);
		return leftRotate(t);
	}

	public int height() {
		return height(root);
	}

	private int height(AVLNode<E> t) {
		return t == null ? -1 : t.height;
	}

	public void preOrder() {
		preOrder(root);
		System.out.println();
	}

	private void preOrder(AVLNode<E> tree) {
		if (tree != null) {
			System.out.print(tree.element + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	private void inOrder(AVLNode<E> tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.element + " ");
			inOrder(tree.right);
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println();
	}

	private void postOrder(AVLNode<E> tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.element + " ");
		}
	}

	public AVLNode<E> search(E key) {
		return search(root, key);
	}

	private AVLNode<E> search(AVLNode<E> x, E key) {
		if (x == null) {
			return x;
		}

		int cmp = key.compareTo(x.element);
		if (cmp < 0) {
			return search(x.left, key);
		} else if (cmp > 0) {
			return search(x.right, key);
		} else {
			return x;
		}
	}

	public AVLNode<E> iterativeSearch(E key) {
		return iterativeSearch(root, key);
	}

	private AVLNode<E> iterativeSearch(AVLNode<E> tree, E key) {
		while (tree != null) {
			int cmp = key.compareTo(tree.element);
			if (cmp < 0) {
				tree = tree.left;
			} else if (cmp > 0) {
				tree = tree.right;
			} else {
				return tree;
			}
		}
		return null;
	}

	public AVLNode<E> minimum() {
		return minimum(root);
	}

	private AVLNode<E> minimum(AVLNode<E> tree) {
		if (tree == null) {
			return null;
		}
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}


	public AVLNode<E> maximum() {
		return maximum(root);
	}

	private AVLNode<E> maximum(AVLNode<E> tree) {
		if (tree == null) {
			return null;
		}
		while (tree.right != null) {
			tree = tree.right;
		}
		return tree;
	}

	public void printTree() {
		printTree(root);
	}

	private void printTree(AVLNode<E> tree) {
		if (tree == null) {
			return;
		}
		System.out.print(tree.element + " ");
		printTree(tree.left);
		printTree(tree.right);
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
