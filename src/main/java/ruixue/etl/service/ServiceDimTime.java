package ruixue.etl.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruixue.etl.entity.DimTime;
import ruixue.etl.repository.JpaRepositoryDimTime;

@Service
public class ServiceDimTime {
	@Autowired
	private JpaRepositoryDimTime dimTimeRepository;
	
	public DimTime findDimTime(LocalDate date) {
		return dimTimeRepository
		.findByYearAndMonthAndDay(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
	}
	
}
