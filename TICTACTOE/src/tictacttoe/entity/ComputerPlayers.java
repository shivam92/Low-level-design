package tictacttoe.entity;

import tictacttoe.constant.Constant;
import tictacttoe.constant.Constant.PlayerType;
import tictacttoe.strategy.ComputerPlayingStrategy;

public class ComputerPlayers extends Players {

	public ComputerPlayers(Symbol symbol ) {
		super(symbol, Constant.PlayerType.Computer);
		
	}

	private ComputerPlayingStrategy stretagy;
 private Constant.DifficultyLevel difLevel=Constant.DifficultyLevel.EASY;
 
	public Constant.DifficultyLevel getDifLevel() {
	return difLevel;
}

public void setDifLevel(Constant.DifficultyLevel difLevel) {
	this.difLevel = difLevel;
}

	public ComputerPlayingStrategy getStretagy() {
		return stretagy;
	}

	public void setStretagy(ComputerPlayingStrategy stretagy) {
		this.stretagy = stretagy;
	}
	
	public static class Builder{
		ComputerPlayers computerPlayers;
		public Builder(Symbol symbol) {
			this.computerPlayers=new ComputerPlayers(symbol);
		}
		
		public ComputerPlayers.Builder setStaretagy(ComputerPlayingStrategy st) {
			this.computerPlayers.setStretagy(st);
			return this;
		}
		public ComputerPlayers.Builder setDiffLevel(Constant.DifficultyLevel level){
			this.computerPlayers.setDifLevel(level);
			return this;
		}
		
		public ComputerPlayers build() {
			return this.computerPlayers;
		}
	}

	@Override
	public Move makeMove(Board board) {
		// TODO Auto-generated method stub
		   System.out.println("Bot is executing the move");
		return stretagy.getNextMove(board);
	}
}
