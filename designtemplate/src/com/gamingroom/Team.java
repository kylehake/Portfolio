package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{

	//An array list of player objects
	private static List<Player> players = new ArrayList<Player>();

	//Used to make a unique ID to each player object that is created
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	public Player addPlayer (String name) {

		//Creates local instance of player class
		Player player = null;
		int i = 0;

		/**
		 * While use that iterates the length of the player list
		 * IF name passed to method is found, it returns the matching player name
		 * If not found, instance from GameService is called and new player onject is created using the name and id
		 * pulled from the instance
		 * Adds player to list
		 *
		 * @returns matched player
		 */
		while (i < getPlayerCount()) {
			if (name == players.get(i).name) {
				player = players.get(i);
				break;
			}
			i++;
		}

			if (player == null) {
				GameService instance = GameService.getInstance();
				player = new Player(instance.getNextPlayerId(), name);
				players.add(player);
			}
		return player;
	}

	//Gets the size of the players list
	public int getPlayerCount () {
		return players.size();
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
