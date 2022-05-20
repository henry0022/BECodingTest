package com.be.assessment;
public class Team {
	public  String name;
	public  int points;
	public  int index;
	public  Team() {
		this.name = "";
		this.points = 0;
	}
	public Team(String name, int points, int index) {
		this.name = name;
		this.points = points;
		this.index = index;
	}

	public void addPoints(int pointsToAdd) {
		this.points = points + pointsToAdd;
	}

	public String toString(){

		return this.name + ", " + this.points;
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
