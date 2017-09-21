package ruixue.etl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FactBetTransaction {
	@Id
	private long betId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TIMEID", insertable=false, updatable=false)
	private DimTime time;
	private double cashTurnover;
	private double bonusTurnover;
	private double cashWinnings;
	private double bonusWinnings;
	private long player;
	private int game;
	
	public long getBetId() {
		return betId;
	}
	public void setBetId(long betId) {
		this.betId = betId;
	}
	public DimTime getTime() {
		return time;
	}
	public void setTime(DimTime time) {
		this.time = time;
	}
	public double getCashTurnover() {
		return cashTurnover;
	}
	public void setCashTurnover(double cashTurnover) {
		this.cashTurnover = cashTurnover;
	}
	public double getBonusTurnover() {
		return bonusTurnover;
	}
	public void setBonusTurnover(double bonusTurnover) {
		this.bonusTurnover = bonusTurnover;
	}
	public double getCashWinnings() {
		return cashWinnings;
	}
	public void setCashWinnings(double cashWinnings) {
		this.cashWinnings = cashWinnings;
	}
	public double getBonusWinnings() {
		return bonusWinnings;
	}
	public void setBonusWinnings(double bonusWinnings) {
		this.bonusWinnings = bonusWinnings;
	}
	public long getPlayer() {
		return player;
	}
	public void setPlayer(long player) {
		this.player = player;
	}
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
}
