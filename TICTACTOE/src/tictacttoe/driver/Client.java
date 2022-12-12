package tictacttoe.driver;

import java.util.Scanner;

import tictacttoe.constant.Constant;
import tictacttoe.entity.Game;
import tictacttoe.entity.Players;
import tictacttoe.entity.Symbol;
import tictacttoe.factory.PlayerFactory;
import tictacttoe.strategy.EasyStretegy;
import tictacttoe.strategy.HardStretegy;

public class Client {
public static void main(String[] args) throws Exception {
	 Scanner scanner = new Scanner(System.in);

	Game game=new Game.GameBuilder().setDimension(3).
			addPlayer(PlayerFactory.getHumanPlayer(new Symbol('X')).setWithUserId(1).build()).
			addPlayer(PlayerFactory.getComputerPlayer(new Symbol('O')).
					setStaretagy(new EasyStretegy()).build())
			.build();
	
	while(game.getStatus().equals(Constant.GameStatus.IN_PROGRESS)) {
		Players p=game.getPlayers().get(game.getNextTurnPlayerIndex());
		System.out.println("Next Move is of Player " + p.getPlayerType());
		 if (p.getPlayerType().equals(Constant.PlayerType.Human)) {
             System.out.println("Do you want to undo? Y/N");
         }
		 String undoAnswer = scanner.next();

         if (undoAnswer.equals("Y")) {
             game.undo();
             continue;
         }

         game.run();

         game.printBoard();
	}
	if (game.getStatus().equals(Constant.GameStatus.DRAW)) {
        System.out.println("Game DRAW. No Winner.");
    }

    if (game.getStatus().equals(Constant.GameStatus.ENDED)) {
        System.out.println("Game has ended. Winner is: " + game.getWinner().getPlayerType());
    }
	
}
}
