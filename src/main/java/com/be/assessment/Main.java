package com.be.assessment;


//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	static GameInputProcessor gip = new GameInputProcessor();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		while(userInput != 3) {
		    Scanner myObj = new Scanner(System.in);
		    System.out.println("1. Run Test  2. Run Default Input  3. Exit");
		    try {
		    	userInput = Integer.parseInt(myObj.nextLine());
		    	if(userInput == 1) {
		    		runTests();
		    	}
		    	if(userInput == 2 ) {
					System.out.println("Default Output:");
					System.out.println("------------------------------------------------");
		    		ArrayList<String> actualOutput = gip.GetOutputFromInputFile("test1Input.txt");
		    		for(String output: actualOutput) {
		    			System.out.println(output);
		    		}
					System.out.println("------------------------------------------------");
					System.out.println("------------------------------------------------");
		    	}
		    }catch(Exception e) {}
		}
		System.exit(0);
	}
	private static void runTests() {
		
		
				//TEST 1
				System.out.println("Test 1 Input");
				System.out.println("------------------------------------------------");
				for(String input: gip.GetExpectedOutoutFromTestFile("test1Input.txt")) {
					System.out.println(input);
				}
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 1 Expected Output:");
				System.out.println("------------------------------------------------");
				ArrayList<String> expectedOutput = gip.GetExpectedOutoutFromTestFile("test1Expected.txt");
				for(String output: expectedOutput) {
					System.out.println(output);
				}
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 1 Actual Output:");
				System.out.println("------------------------------------------------");
				ArrayList<String> actualOutput = gip.GetOutputFromInputFile("test1Input.txt");
				boolean t1Result = true;
				int count = 0;
				for(String output: actualOutput) {
					System.out.println(output);
					if(!output.equals(expectedOutput.get(count))) {
						t1Result=false;
					}
					count++;
				}
				//TEST 2
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 2 Input");
				System.out.println("------------------------------------------------");
				for(String input: gip.GetExpectedOutoutFromTestFile("test2Input.txt")) {
					System.out.println(input);
				}
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 2 Expected Output:");
				System.out.println("------------------------------------------------");
				expectedOutput = gip.GetExpectedOutoutFromTestFile("test2Expected.txt");
				for(String output: expectedOutput) {
					System.out.println(output);
				}
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 2 Actual Output:");
				System.out.println("------------------------------------------------");
				actualOutput = gip.GetOutputFromInputFile("test2Input.txt");
				for(String output: actualOutput) {
					System.out.println(output);
				}
				boolean t2Result = true;
				 count = 0;
				for(String output: actualOutput) {
					System.out.println(output);
					if(!output.equals(expectedOutput.get(count))) {
						t2Result=false;
					}
					count++;
				}
				//TEST 3
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 3 Input");
				System.out.println("------------------------------------------------");
				for(String input: gip.GetExpectedOutoutFromTestFile("test3Input.txt")) {
					System.out.println(input);
				}

				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 3 Expected Output:");
				System.out.println("------------------------------------------------");
				expectedOutput = gip.GetExpectedOutoutFromTestFile("test3Expected.txt");
				for(String output: expectedOutput) {
					System.out.println(output);
				}

				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("Test 3 Actual Output:");
				System.out.println("------------------------------------------------");
				actualOutput = gip.GetOutputFromInputFile("test3Input.txt");
				for(String output: actualOutput) {
					System.out.println(output);
				}
				boolean t3Result = true;
				 count = 0;
				for(String output: actualOutput) {
					System.out.println(output);
					if(!output.equals(expectedOutput.get(count))) {
						t3Result=false;
					}
					count++;
				}
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				System.out.println("TEST 1:" + (t1Result?ANSI_GREEN + " SUCCESS " + ANSI_RESET:ANSI_RED + " FAILURE "+ ANSI_RESET));
				System.out.println("TEST 2:" + (t2Result?ANSI_GREEN + " SUCCESS " + ANSI_RESET:ANSI_RED + " FAILURE "+ ANSI_RESET));
				System.out.println("TEST 3:" + (t3Result?ANSI_GREEN + " SUCCESS " + ANSI_RESET:ANSI_RED + " FAILURE "+ ANSI_RESET));
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
	}
}
