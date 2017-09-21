package ruixue.etl.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ruixue.etl.dto.DimPlayerDTO;
import ruixue.etl.dto.FactBetTransactionDTO;
import ruixue.etl.util.IOUtils;
import ruixue.etl.util.Transformers;

//@Component
@Service
public class LoadServiceMain {
	@Autowired
	private LoadServiceDimTime loadServiceDimTime;
	@Autowired
	private LoadServiceFactBetTransaction loadServiceFactBetTransaction;
	public void loadDimTimeAndFactBetTransaction(String sourceCSVPath) {
		List<String> csvContent = null;
		try {
			csvContent = IOUtils.readAllLines(sourceCSVPath);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}				
		List<FactBetTransactionDTO> factBetTransactionDTOs = 
				Transformers.getFactBetTransactionDTOs(csvContent);
		loadServiceDimTime.loadDimTime(factBetTransactionDTOs);
		loadServiceFactBetTransaction.loadFactBetTransaction(factBetTransactionDTOs);
	}
	@Autowired
	private LoadServiceDimPlayer loadServiceDimPlayer;
	public void loadDimPlayer(String sourceCSVPath, LocalDate loadDate) {
		List<String> csvContent = null;
		try {
			csvContent = IOUtils.readAllLines(sourceCSVPath);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}				
		List<DimPlayerDTO> dimPlayerDTOs = Transformers.getDimPlayerDTOs(csvContent);
		
	}
}
