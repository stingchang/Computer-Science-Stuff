/*
 * Author: Sting Chang
 * Date: 07/07/2016
 * */

package com.sting.test.tree;

public class Tree<T extends Comparable<T>> {
	private T value;
	private Tree<T> left;
	private Tree<T> right;

	public Tree(T value) {
		this.setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Tree<T> getLeft() {
		return left;
	}

	public void setLeft(Tree<T> left) {
		this.left = left;
	}

	public Tree<T> getRight() {
		return right;
	}

	public void setRight(Tree<T> right) {
		this.right = right;
	}
}
