package com.be.assessment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GameInputProcessorTest {
	@Test
	void testCase1() {
		GameInputProcessor tester = new GameInputProcessor();
		ArrayList<String> output = tester.GetOutputFromInputFile("test1Input.txt");
		ArrayList<String> expectedOutput = tester.GetExpectedOutoutFromTestFile("test1Expected.txt");
		assertArrayEquals(expectedOutput.toArray(), output.toArray(), "Test 1 Actual Output Incorrect");
	}

	@Test
	void testCase2() {
		GameInputProcessor tester = new GameInputProcessor();
		ArrayList<String> output = tester.GetOutputFromInputFile("test2Input.txt");
		ArrayList<String> expectedOutput = tester.GetExpectedOutoutFromTestFile("test2Expected.txt");
		assertArrayEquals(expectedOutput.toArray(), output.toArray(), "Test 2 Actual Output Incorrect");
	}

	@Test
	void testCase3() {
		GameInputProcessor tester = new GameInputProcessor();
		ArrayList<String> output = tester.GetOutputFromInputFile("test3Input.txt");
		ArrayList<String> expectedOutput = tester.GetExpectedOutoutFromTestFile("test3Expected.txt");
		assertArrayEquals(expectedOutput.toArray(), output.toArray(), "Test 3 Actual Output Incorrect");
	}

}
