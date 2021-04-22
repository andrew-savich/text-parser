package com.andrewsavich.textparser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andrewsavich.textparser.model.composites.Text;
import com.andrewsavich.textparser.textloaders.TextLoader;
import com.andrewsavich.textparser.textloaders.TextLoaderFromResourcesFile;

public class AppRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

	public static void main(String[] args) {
		String fileName = "SimpleTestText.txt";
		TextLoader textLoader = new TextLoaderFromResourcesFile(fileName);
		String inputText = textLoader.getTextd();

		Text text = new Text();

		text.parse(inputText);

		LOGGER.info("Original text:" + "\n" + inputText + "\n");

		LOGGER.info("After parse:" + "\n" + text.build() + "\n");

		text.replaceFirstLastWordsInAllSentences();

		LOGGER.info("After replace words:" + "\n" + text.build());

	}
}
