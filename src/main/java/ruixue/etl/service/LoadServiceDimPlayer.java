package ruixue.etl.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruixue.etl.util.Transformers;
import ruixue.etl.dto.DimPlayerDTO;
import ruixue.etl.entity.DimPlayer;
import ruixue.etl.entity.DimTime;
import ruixue.etl.repository.JpaRepositoryDimPlayer;

@Service
public class LoadServiceDimPlayer {
	@Autowired
	private ServiceDimTime dimTimeService;
	@Autowired
	private JpaRepositoryDimPlayer dimPlayerRepository;
	public void loadDimTime(List<DimPlayerDTO> dimPlayerDTOs, String dateStampString) {
		LocalDate dateStamp = Transformers.getDate(dateStampString);
		DimTime loadTime = dimTimeService.findDimTime(dateStamp);
		if (loadTime != null) {
			for (DimPlayerDTO currentDTO : dimPlayerDTOs) {
				long currentPlayerId = currentDTO.getPlayerId();
				DimPlayer latestDimPlayer = dimPlayerRepository.findByValidToIsNullAndPlayerID(currentPlayerId);
				if (latestDimPlayer != null && latestDimPlayer.getCountry().equals(currentDTO.getCountry()))
					continue;
				else if (latestDimPlayer != null && !latestDimPlayer.getCountry().equals(currentDTO.getCountry())) {
					//latestDimPlayer.setValidTo(loadTime);
				}		
				latestDimPlayer = new DimPlayer();
				
				//currentPlayer.setPlayerId(currentDTO.getPlayerId());
			}
		}
	}
}
