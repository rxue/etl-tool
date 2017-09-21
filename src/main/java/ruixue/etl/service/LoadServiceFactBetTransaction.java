package ruixue.etl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ruixue.etl.dto.FactBetTransactionDTO;
import ruixue.etl.entity.FactBetTransaction;
import ruixue.etl.repository.JpaRepositoryFactBetTransaction;

@Service
public class LoadServiceFactBetTransaction {
	@Autowired
	private JpaRepositoryFactBetTransaction factBetRepository;
	@Autowired
	private ServiceDimTime dimTimeService;
	public void loadFactBetTransaction(List<FactBetTransactionDTO> factBetTransactionDTOs) {
		for (FactBetTransactionDTO currentDTO : factBetTransactionDTOs) {
			FactBetTransaction betTransaction = new FactBetTransaction();
			betTransaction.setBetId(currentDTO.getBetId());
			betTransaction.setTime(dimTimeService.findDimTime(currentDTO.getDate()));
			betTransaction.setCashTurnover(currentDTO.getCashTurnover());
			betTransaction.setBonusTurnover(currentDTO.getBonusTurnover());
			betTransaction.setCashWinnings(currentDTO.getCashWinnings());
			betTransaction.setBonusWinnings(currentDTO.getBonusWinnings());
			factBetRepository.save(betTransaction);
		}
	}
}
