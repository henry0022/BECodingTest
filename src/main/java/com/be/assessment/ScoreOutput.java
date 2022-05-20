package com.be.assessment;

import java.util.ArrayList;

public class ScoreOutput {
	public int position;
	public int points;
	public ArrayList<Team>  teams;
	public ScoreOutput(int points, Team i, int position) {
		this.points = points;
		this.teams = new ArrayList<Team>();
		this.teams.add(i);
		this.position = position;
	}
	public void addTeam(Team add, int position) {
		this.position = position;
		this.teams.add(add);
	}
	public String[] printAlphabetically() {
		Object[] a = this.teams.toArray();
		int n = a.length;
		for(int i = 0; i<n; i++)   
		{  
			for (int j = i+1; j<n; j++) 
			{  
				if(((Team)(a[i])).name.compareTo(((Team)(a[j])).name)>0)   
				{  
					Object temp = a[i];  
					a[i] = a[j];  
					a[j] = temp;  
				}  
			}  
		} 
		String[] returnArray = new String[n];
		for(int i = 0; i<n; i++)   //Holds each element
		{  	
			String ptOrPts = this.points==1?" pt":" pts";
			returnArray[i]=(this.position + ". " + ((Team)(a[i])).toString() + ptOrPts);
		}
		return returnArray;
	}


}
