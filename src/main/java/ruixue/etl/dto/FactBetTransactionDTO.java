package ruixue.etl.dto;

import java.time.LocalDate;

public class FactBetTransactionDTO {
	private Long betId;
	private LocalDate date;
	private Double cashTurnover;
	private Double bonusTurnover;
	private Double cashWinnings;
	private Double bonusWinnings;
	private Long playerId;
	private Integer gameId;
	
	public FactBetTransactionDTO(String betId,
			LocalDate date,
			double cashTurnover, double bonusTurnover,
			long playerId, int gameId) {
		this.betId = new Long(betId);
		this.date = date;
		this.cashTurnover = cashTurnover;
		this.bonusTurnover = bonusTurnover;
		this.playerId = playerId;
		this.gameId = gameId;
	}
	
	public Long getBetId() {
		return betId;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getCashTurnover() {
		return cashTurnover;
	}

	public Double getBonusTurnover() {
		return bonusTurnover;
	}

	public Double getCashWinnings() {
		return cashWinnings;
	}
	
	public void setCashWinnings(Double cashWinnings) {
		this.cashWinnings = cashWinnings;
	}

	public Double getBonusWinnings() {
		return bonusWinnings;
	}
	
	public void setBonusWinnings(Double bonusWinnings) {
		this.bonusWinnings = bonusWinnings;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public Integer getGameId() {
		return gameId;
	}

}
