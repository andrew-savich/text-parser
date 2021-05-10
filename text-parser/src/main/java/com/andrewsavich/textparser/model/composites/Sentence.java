package com.andrewsavich.textparser.model.composites;

import java.util.ArrayList;
import java.util.List;

import com.andrewsavich.textparser.model.Component;
import com.andrewsavich.textparser.model.CompositeComponent;
import com.andrewsavich.textparser.model.LeafComponent;
import com.andrewsavich.textparser.model.leafs.Punctuation;
import com.andrewsavich.textparser.model.leafs.Word;

public class Sentence implements CompositeComponent {

	private final String REGEX = "\\b";
	private List<LeafComponent> leafComponents;

	public Sentence() {
		leafComponents = new ArrayList<>();
	}

	public Sentence(List<LeafComponent> leafs) {
		this.leafComponents = leafs;
	}
	
	public void replaceFirstLastWordsInSentence() {
		int indexOfLastWord = leafComponents.size() - 2;
		
		LeafComponent firstWord = leafComponents.get(0);
		LeafComponent lastWord = leafComponents.get(indexOfLastWord);
		
		leafComponents.set(0, lastWord);
		leafComponents.set(indexOfLastWord, firstWord);
		
	}
	
	public List<LeafComponent> getLeafComponents() {
		return leafComponents;
	}

	@Override
	public void parse(String sentence) {
		String[] leafStings = sentence.split(REGEX);

		for (String leaf : leafStings) {
			if (leaf.equals(" ") || leaf.equals(".") || leaf.equals(",") || leaf.equals("!") || leaf.equals("?")) {
				leafComponents.add(new Punctuation(leaf));
			} else {
				leafComponents.add(new Word(leaf));
			}

		}
	}

	@Override
	public String build() {
		String sentence = "";
		for (LeafComponent leaf : leafComponents) {
			sentence += leaf.build();
		}

		return sentence;
	}

	@Override
	public void add(Component component) {
		leafComponents.add((LeafComponent) component);

	}

	@Override
	public void remove(Component component) {
		leafComponents.remove((LeafComponent) component);
	}

	@Override
	public List<Component> getComponents() {
		return new ArrayList<>(leafComponents);
	}

	@Override
	public String toString() {
		String sentence = "";

		for (LeafComponent leaf : leafComponents) {
			sentence += leaf;
		}

		return sentence;
	}

}
