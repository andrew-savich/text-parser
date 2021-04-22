package com.andrewsavich.textparser.model.leafs;

import com.andrewsavich.textparser.model.LeafComponent;

public class Word implements LeafComponent {

	private String word;

	public Word(String word) {
		this.word = word;
	}

	@Override
	public String build() {
		return word;
	}

	public String getWord() {
		return word;
	}

	@Override
	public String toString() {
		return word;
	}

}
