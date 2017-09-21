package ruixue.etl.dto;

public class DimPlayerDTO {
	private Long playerId;
	private String country;
	public DimPlayerDTO(String playerIDString, String country) {
		this.playerId = new Long(playerIDString);
		this.country = country;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
