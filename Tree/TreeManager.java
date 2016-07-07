/*
 * Author: Sting Chang
 * Date: 07/07/2016
 * */

package com.sting.test.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeManager<T extends Comparable<T>> {
	private Tree<T> root;

	public TreeManager() {
	}

	public void insert(T t) {
		if (root == null) {
			root = new Tree<>(t);
		} else {
			insert(root, t);
		}

	}

	private void insert(Tree<T> n, T t) {
		if (t.compareTo(n.getValue()) <= 0) {
			if (n.getLeft() == null) {
				n.setLeft(new Tree<>(t));
			} else {
				insert(n.getLeft(), t);
			}
		} else {
			if (n.getRight() == null) {
				n.setRight(new Tree<>(t));
			} else {
				insert(n.getRight(), t);
			}
		}
	}

	// Use a queue
	public List<T> bfsTraversal() {
		List<T> list = new ArrayList<>();
		Deque<Tree<T>> queue = new ArrayDeque<>();
		if (root == null)
			return list;
		queue.addLast(root);
		bfsHelper(list, queue);

		return list;
	}

	private void bfsHelper(List<T> list, Deque<Tree<T>> queue) {
		if (queue.isEmpty())
			return;
		Tree<T> t = queue.removeFirst();
		list.add(t.getValue());
		if (t.getLeft() != null)
			queue.addLast(t.getLeft());
		if (t.getRight() != null)
			queue.addLast(t.getRight());
		bfsHelper(list, queue);
	}

	// Use a stack
	public List<T> dfsTraversal() {
		List<T> list = new ArrayList<>();
		if (root == null)
			return list;

		Deque<Tree<T>> stack = new ArrayDeque<>();
		stack.addFirst(root);
		dfsHelper(list, stack);
		return list;
	}

	private void dfsHelper(List<T> list, Deque<Tree<T>> stack) {
		if (stack.isEmpty())
			return;
		Tree<T> t = stack.removeFirst();
		list.add(t.getValue());
		if (t.getRight() != null) {
			stack.addFirst(t.getRight());
		}
		if (t.getLeft() != null) {
			stack.addFirst(t.getLeft());
		}
		dfsHelper(list, stack);
	}

	public List<T> inorderTraversal() {
		List<T> list = new ArrayList<>();
		if (root == null)
			return list;

		inorderHelper(root, list);
		return list;
	}

	private void inorderHelper(Tree<T> t, List<T> list) {
		if (t.getLeft() != null)
			inorderHelper(t.getLeft(), list);

		list.add(t.getValue());

		if (t.getRight() != null)
			inorderHelper(t.getRight(), list);
	}

	public List<T> preorderTraversal() {
		List<T> list = new ArrayList<>();
		if (root == null)
			return list;

		preorderHelper(root, list);
		return list;
	}

	private void preorderHelper(Tree<T> t, List<T> list) {

		list.add(t.getValue());

		if (t.getLeft() != null)
			preorderHelper(t.getLeft(), list);

		if (t.getRight() != null)
			preorderHelper(t.getRight(), list);
	}

	public List<T> postorderTraversal() {
		List<T> list = new ArrayList<>();
		if (root == null)
			return list;

		postorderHelper(root, list);
		return list;
	}

	private void postorderHelper(Tree<T> t, List<T> list) {

		if (t.getLeft() != null)
			postorderHelper(t.getLeft(), list);

		if (t.getRight() != null)
			postorderHelper(t.getRight(), list);

		list.add(t.getValue());
	}
}
