package com.be.assessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.be.assessment.*;

public class GameInputProcessor {

	public static ArrayList<Team> teams;
	public static ArrayList<String> output;
	private static Scanner sc;
	static Team teamToAdd = new Team();
	
	public static ArrayList<String> GetOutputFromInputFile(String filePath) {
		
		teams = new ArrayList<Team>();
		output = new ArrayList<String>();
		try {
			sc = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(sc.hasNext()) {
			String inputLine = sc.nextLine();
			String [] t1Input = inputLine.split(",")[0].split(" ");
			String [] t2Input = inputLine.split(",")[1].split(" ");
			int t1score= Integer.parseInt(t1Input[t1Input.length-1]);
			int t2score= Integer.parseInt(t2Input[t2Input.length-1]);
			String t1Name = "";
			String t2Name = "";
			for(int i = 0 ; i< t1Input.length-1; i++) {
				if(t1Input[i].isBlank() || t1Input[i].isEmpty()) {

				}else {
					t1Name = t1Name + t1Input[i];
				}
				if(i!=0 && i != t1Input.length-2) {
					t1Name = t1Name + " ";
				}
			}
			for(int i = 0 ; i< t2Input.length-1; i++) {
				if(t2Input[i].isBlank() || t2Input[i].isEmpty()) {

				}else {
					t2Name = t2Name + t2Input[i];
				}
				if(i!=0 && i != t2Input.length-2) {
					t2Name = t2Name + " ";
				}
			}
			boolean t1Exists = false;
			boolean t2Exists = false;
			int t1Points = 0;
			int t2Points = 0;
			if(t1score > t2score ) {
				t1Points = 3; 
			}
			if(t1score < t2score ) {
				t2Points = 3; 
			}
			if(t1score == t2score ) {
				t1Points = 1; 
				t2Points = 1; 
			}
			for (Team t : teams) 
			{ 
				if(t.getName().equals(t1Name)) {
					t1Exists = true;
					t.addPoints(t1Points);
				}
				if(t.getName().equals(t2Name)) {
					t2Exists = true;
					t.addPoints(t2Points);
				}
			}
			if(!t1Exists) {
				teamToAdd = new Team(t1Name, t1Points, teams.size());
				teams.add(teamToAdd);
			}
			if(!t2Exists) {
				teamToAdd = new Team(t2Name, t2Points,teams.size());
				teams.add(teamToAdd);
			}
		}
		teams = sortTeamsByPoints(teams);
		ArrayList<ScoreOutput> output = new ArrayList<ScoreOutput>();
		int positionCounter = 1;
		for (Team i : teams) 
		{	
			boolean scoreExists = false;
			for(ScoreOutput out: output) {
				if(out.points==i.points) {
					scoreExists = true;
					out.addTeam(i, out.position);
				}
			}
			if(!scoreExists) {
				output.add(new ScoreOutput(i.points, i, positionCounter));
			}
			positionCounter++;
		}
		ArrayList<String> returnArray = new ArrayList<String>();
		for (ScoreOutput i : output) 
		{	
			String[] a = i.printAlphabetically();
			for(int j = 0; j<a.length;j++) {
				returnArray.add(a[j]);
			}
		}
		return returnArray;
	}
	private static ArrayList<Team> sortTeamsByPoints(ArrayList<Team> team) {
		ArrayList<Team> sortedTeams;
		Object[] a = team.toArray();
		int n = a.length;
		for(int i = 0; i<n; i++)  
		{  
			for (int j = i+1; j<n; j++)  
			{  
				if(((Team)a[i]).points<((Team)a[j]).points) 
				{  
					Object temp = a[i];  
					a[i] = a[j];  
					a[j] = temp;  
				}  
			}  
		} 
		sortedTeams = new ArrayList<Team>();

		for(int i = 0; i<n; i++)
		{  
			sortedTeams.add(((Team)a[i]));
		}
		return sortedTeams;
	}
	public ArrayList<String> GetExpectedOutoutFromTestFile(String filePath) {
		try {
			sc = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<String> ar = new ArrayList<String>();
		while(sc.hasNext()) {
			String inputLine = sc.nextLine();
			ar.add(inputLine);		
		}
		return ar;
	}

	
}
