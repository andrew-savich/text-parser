package com.andrewsavich.textparser.textloaders;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextLoaderFromResourcesFile implements TextLoader {

	private String fileName;
	private ClassLoader classLoader;
	private String text;

	private static final Logger LOGGER = LoggerFactory.getLogger(TextLoaderFromResourcesFile.class);

	public TextLoaderFromResourcesFile(String fileName) {
		this.fileName = fileName;
		classLoader = getClass().getClassLoader();
	}

	@Override
	public String getTextd() {
		File file = new File(classLoader.getResource(fileName).getFile());

		try {
			text = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}

		LOGGER.info("Loaded text from file" + "\n");
		return text;

	}

}
