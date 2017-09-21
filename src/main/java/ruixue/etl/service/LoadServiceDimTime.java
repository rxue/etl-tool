package ruixue.etl.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruixue.etl.repository.JpaRepositoryDimTime;
import ruixue.etl.dto.FactBetTransactionDTO;
import ruixue.etl.entity.DimTime;

@Service
public class LoadServiceDimTime {
	@Autowired
	private JpaRepositoryDimTime dimTimeRepository;
	@Autowired
	private ServiceDimTime dimTimeService;
	public void loadDimTime(List<FactBetTransactionDTO> factBetTransactionDTOs) {
		for (FactBetTransactionDTO currentDTO : factBetTransactionDTOs) {
			LocalDate currentDate = currentDTO.getDate();
			DimTime correspondingDimTime = dimTimeService.findDimTime(currentDate);
			if (correspondingDimTime == null) {
				DimTime dimTime = new DimTime();
				dimTime.setYear(currentDate.getYear());
				dimTime.setMonth(currentDate.getMonthValue());
				dimTime.setDay(currentDate.getDayOfMonth());
				dimTimeRepository.save(dimTime);
			}
		}
	}
}
