package driver;

import model.Game;
import model.Player.PlayerBuilder;

public class Client {
public static void main(String[] args) {
	
	Game game=new Game.Builder().setDieceCount(1).setDimension(10).
			addPlayer(new PlayerBuilder().createWithGameId(1).createWithName("shivam").build())
			.addPlayer(new PlayerBuilder().createWithGameId(1).createWithName("computer").build())
			
			
			
			.build();
	game.launc();
}
}
