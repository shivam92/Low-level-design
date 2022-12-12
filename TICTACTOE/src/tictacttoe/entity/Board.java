package tictacttoe.entity;

import java.util.ArrayList;
import java.util.List;

import tictacttoe.constant.Constant;

public class Board {
 List<List<Cell>>board=new ArrayList();
int dimension;
 public int getDimension() {
	return dimension;
}
public void setDimension(int dimension) {
	this.dimension = dimension;
}
public Board(int dimension) {
	 this.dimension=dimension;
	 board=new ArrayList(dimension);
		for(int i=0;i<dimension;i++) {
			board.add(new ArrayList(dimension));
			for(int j=0;j<dimension;j++) {
				board.get(i).add(new Cell());
			}
		}
		
		
 }
public List<List<Cell>> getBoard() {
	return board;
}

public void setBoard(List<List<Cell>> board) {
	this.board = board;
}
public void printBoard() {
    for (int i = 0; i < dimension; ++i) {
        for (int j = 0; j < dimension; ++j) {
            Players playerAtCell = board.get(i).get(j).getPlayer();

            if (playerAtCell == null) {
                System.out.printf(" | - | ");
            } else {
                System.out.printf(" | " + board.get(i).get(j).getPlayer().getSymbol().getCharacter() + " | ");
            }
        }
        System.out.printf("\n");
    }
}
 
}
