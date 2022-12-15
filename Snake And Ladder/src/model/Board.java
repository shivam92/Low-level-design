package model;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private Map<Integer,Cell>cells;
	private int cellCount;
	public Board(int dimension) {
		this.cellCount=dimension*dimension;
		cells=new HashMap<Integer, Cell>();
		
		for(int i=0;i<dimension;i++) {
			int min=2;
			int max=cellCount-1;
			int start=(int)Math.floor(Math.random()*(max-min)+1+min);
			max=start-1;
			int end=(int)Math.floor(Math.random()*(max-min)+1+min);
			if(!hasSnakeLadder(start)) {
				creatCells(start,new Snake(start,end));
			}
			max=cellCount-1;
			end=(int)Math.floor(Math.random()*(max-min)+1+min);
			max=end-1;
			start=(int)Math.floor(Math.random()*(max-min)+1+min);
			if(!hasSnakeLadder(start)) {
				creatCells(start,new Ladder(start,end));
			}
			
		}
	}
	public void printBoard() {
		for(int i=cellCount-1;i>0;i--) {
			System.out.print(i+" ");
			if(hasSnakeLadder(i)) {
				System.out.print(cells.get(i).toString());
			}else {
				System.out.print("  ");
			}
			if(i%10==0)System.out.println();
		}
		System.out.println();
	}
	public void creatCells(int index ,Cell cell) {
		this.cells.put(index, cell);
	}
	public Cell getCell(int index) {
		if(hasSnakeLadder(index)) {
			return this.cells.get(index);
		}
		return null;
	}
	public boolean hasSnakeLadder(int index) {
		return cells.containsKey(index);
	}
	
}
