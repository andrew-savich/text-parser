package com.andrewsavich.textparser.model.composites;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.andrewsavich.textparser.model.Component;
import com.andrewsavich.textparser.model.CompositeComponent;

public class Paragraph implements CompositeComponent {

	private final String REGEX = "(?<=\\w[\\w\\)\\]][\\.\\?\\!]\\s)";
	private List<Sentence> sentences;

	public Paragraph() {
		sentences = new ArrayList<>();
	}

	public Paragraph(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	
	
	public List<Sentence> getSentences() {
		return sentences;
	}

	@Override
	public void parse(String paragraph) {
		String[] sentenceStrings = Pattern.compile(REGEX).split(paragraph);

		for (String sentence : sentenceStrings) {
			Sentence sentenceObj = new Sentence();
			sentenceObj.parse(sentence);
			sentences.add(sentenceObj);
		}
	}

	@Override
	public String build() {
		String paragraph = "";
		
		for (int i = 0; i < sentences.size(); i++) {
			paragraph += sentences.get(i).build();

		}
		return paragraph;
	}

	@Override
	public void add(Component component) {
		sentences.add((Sentence) component);

	}

	@Override
	public void remove(Component component) {
		sentences.remove((Sentence) component);
	}

	@Override
	public List<Component> getComponents() {
		return new ArrayList<>(sentences);
	}

	@Override
	public String toString() {
		String paragraph = "";

		for (Sentence sentence : sentences) {
			paragraph += sentence;
		}

		return paragraph;
	}

}
