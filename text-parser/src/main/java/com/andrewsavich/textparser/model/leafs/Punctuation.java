package com.andrewsavich.textparser.model.leafs;

import com.andrewsavich.textparser.model.LeafComponent;

public class Punctuation implements LeafComponent{
	private String punctuation;

	public Punctuation(String punctuation) {
		this.punctuation = punctuation;
	}

	public String build() {
		return punctuation;
	}
	
	
	public String getPunctuation() {
		return punctuation;
	}

	@Override
	public String toString() {
		return punctuation;
	}

}
