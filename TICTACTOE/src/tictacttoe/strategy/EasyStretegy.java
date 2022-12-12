package tictacttoe.strategy;

import tictacttoe.entity.Board;
import tictacttoe.entity.Move;

public class EasyStretegy implements ComputerPlayingStrategy {

	@Override
	public Move getNextMove(Board board) {
		// TODO Auto-generated method stub
	Move move=new Move();
	//move.setCell(2);
	move.setCol(2);
	move.setRow(1);
	return move;
	}

}
