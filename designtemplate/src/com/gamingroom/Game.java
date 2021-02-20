package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	//creates a private list of teams
	private static List<Team> teams = new ArrayList<Team>();

	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}


	//Used to add a team to the list, or return the team if has already been added to the list
	public Team addTeam (String name) {

		//Creates a local instance of Team class
		Team team = null;
		int i = 0;// Iterator

		/**
		 * Loops through the size of the team list
		 * If name passed to loop is found, will return that instance back to the user
		 * If comes back null, creates a new team object and assigns ID from the GameService instance
		 * adds to list
		 *
		 * @return matched team
		 */

		while (i < getTeamCount()) {
			if (name == teams.get(i).name) {
				team = teams.get(i);
				break;
			}
			i++;
		}

			if (team == null) {
				GameService instance = GameService.getInstance();
				team = new Team(instance.getNextTeamId(), name);
				teams.add(team);
			}
		return team;
	}

	//Gets the size of teams list
	public int getTeamCount () {
		return teams.size();
	}

	@Override
	public String toString() {
		
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
