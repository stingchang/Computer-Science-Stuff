/**
 * @author	Sting Chang
 * @date 	July 7, 2016
 * */

package com.sting.test.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	private Map<Character, Trie> children;
	private char value;
	private boolean isWord;

	public Trie() {
		this(' ');
	}

	public Trie(char c) {
		this.setValue(c);
		children = new HashMap<>();
		setWord(false);
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public void addChild(char c) {
		if (!children.containsKey(c)) {
			children.put(c, new Trie(c));
		}
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
}
