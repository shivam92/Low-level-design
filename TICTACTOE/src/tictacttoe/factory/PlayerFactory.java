package tictacttoe.factory;

import tictacttoe.entity.ComputerPlayers;
import tictacttoe.entity.HumanPlayer;
import tictacttoe.entity.Symbol;

public class PlayerFactory {

	/*
	 * public static Players createPlayer(Constant.PlayerType type) {
	 * 
	 * switch (type) { case Human:return getHumanPlayer(); case Computer:return
	 * getComputerPlayer(); default:return null;
	 * 
	 * }
	 */

	public static HumanPlayer.Builder getHumanPlayer(Symbol symbol) {
		return new HumanPlayer.Builder(symbol);
	}

	public static ComputerPlayers.Builder getComputerPlayer(Symbol symbol) {
		return new ComputerPlayers.Builder(symbol);
	}
}
