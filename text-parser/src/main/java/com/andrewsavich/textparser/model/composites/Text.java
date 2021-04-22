package com.andrewsavich.textparser.model.composites;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andrewsavich.textparser.model.Component;
import com.andrewsavich.textparser.model.CompositeComponent;

public class Text implements CompositeComponent {
	private final String REGEX = "\n";
	private List<Paragraph> paragraphs;

	private static final Logger LOGGER = LoggerFactory.getLogger(Text.class);

	public Text() {
		paragraphs = new ArrayList<>();
	}

	public Text(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}

	@Override
	public void parse(String text) {
		String[] paragraphStrings = text.split(REGEX);

		LOGGER.info("count paragraphs: " + paragraphStrings.length + "\n");

		LOGGER.info("Starting to parse a text" + "\n");
		for (String paragraph : paragraphStrings) {
			Paragraph paragraphObj = new Paragraph();
			paragraphObj.parse(paragraph);
			paragraphs.add(paragraphObj);
		}

	}

	public void replaceFirstLastWordsInAllSentences() {
		for (Paragraph paragraph : paragraphs) {
			for (Sentence sentence : paragraph.getSentences()) {
				sentence.replaceFirstLastWordsInSentence();
			}
		}
	}

	@Override
	public String build() {
		String text = "";
		for (Paragraph paragraph : paragraphs) {
			text += paragraph.build();
		}
		return text;
	}

	@Override
	public void add(Component component) {
		paragraphs.add((Paragraph) component);

	}

	@Override
	public void remove(Component component) {
		paragraphs.remove((Paragraph) component);
	}

	@Override
	public List<Component> getComponents() {
		return new ArrayList<>(paragraphs);
	}

}
