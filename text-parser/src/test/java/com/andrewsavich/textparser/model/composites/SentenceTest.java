package com.andrewsavich.textparser.model.composites;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SentenceTest {
	private static Sentence underTest;
	
	@BeforeAll
	public static void init() {
		underTest = new Sentence();
		underTest.parse("Some testing sentence!");
	}
	
	@Test
	public void replaceFirstLastWordsInSentence_shouldBeSameLengthOfSentences() {
		int lengthBeforeReplace = underTest.getComponents().size();
		underTest.replaceFirstLastWordsInSentence();
		int lengthAfterReplace = underTest.getComponents().size();
		
		assertEquals(lengthBeforeReplace, lengthAfterReplace);
	}
	
	
}
