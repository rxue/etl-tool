package ruixue.etl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DimGame {
	@Id
	private int gameId;
	private String gameName;
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
}
