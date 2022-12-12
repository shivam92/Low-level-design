package tictacttoe.strategy;

import tictacttoe.entity.Board;
import tictacttoe.entity.Move;


public interface ComputerPlayingStrategy {

	public Move getNextMove(Board board);
}
