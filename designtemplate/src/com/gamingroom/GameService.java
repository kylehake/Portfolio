package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	private static long nextTeamId = 1;

	private static long nextPlayerId = 1;


	/**
	 * The purpose of the singleton pattern is to create one instance of an object and only one
	 * instance. It achieves this by using the private type classes to make sure that thy can't
	 * be manipulated by outside code.  In this code, the singleton pattern makes sure that a single
	 * save 'instance' of the game is created.
	 */


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */

	private static GameService service = new GameService();

	private GameService() {

	}

	public static GameService getInstance () {
		return service;
	}

	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		int i = 0;

		while (i < getGameCount()) { // Loops through list of games and returns if matched, otherwise, makes a new
			if (name == games.get(i).name) { // Instance.  This is used to add a game if there isnt a match on the
				game = games.get(i); // current list.
				break;
			}
		}


			// if not found, make a new game instance and add to list of games
			if (game == null) {
				game = new Game(nextGameId++, name);
				games.add(game);
			}
		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;



		int i = 0;

		while(i < games.size()) { //Loops through list of games and searches for Id, returns game if matched
			if (id == games.get(i).getId()) { //This is used to search the game list by game ID
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;


		int i = 0;

		while(i < games.size()) {  // Loops through list of games and looks for name match, returns game if matched.
			if (name == games.get(i).getName()) { //This is used to search the list of games for a previous game
				game = games.get(i); //             Already added to the list.
			}
		}

		return game;
	}


	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	//Used to assign player id, increments after method is called
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	//Used to assign team id, increments after method is called
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
