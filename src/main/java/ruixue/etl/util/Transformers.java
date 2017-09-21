package ruixue.etl.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import ruixue.etl.dto.DimPlayerDTO;
import ruixue.etl.dto.FactBetTransactionDTO;
import ruixue.etl.entity.DimTime;

/**
 * Static factory method
 * 
 * @author dingding
 *
 */
public class Transformers {
	public static List<FactBetTransactionDTO> getFactBetTransactionDTOs(List<String> factBetTransactionCSVContent) {
		List<FactBetTransactionDTO> dtos = new ArrayList<>();
		FactBetTransactionDTO currentDTO = null;
		for (String currentLine : factBetTransactionCSVContent) {
			String[] currentLineArray = currentLine.split(";");
			String transactionType = currentLineArray[currentLineArray.length-1];
			if (transactionType.equals("WAGER")) {
				if (currentDTO == null)
					currentDTO = new FactBetTransactionDTO(
							currentLineArray[0],
							getDate(currentLineArray[1]),
							toDouble(currentLineArray[3]),
							toDouble(currentLineArray[4]),
							new Long(currentLineArray[7]),
							new Integer(currentLineArray[8]));
				else {
					//TODO: throw Exception/error log: repeating WAGER
				}
			} else if (transactionType.equals("RESULT")) {
				if (currentDTO != null && currentDTO.getCashWinnings() == null) {
					currentDTO.setCashWinnings(toDouble(currentLineArray[3]));
					currentDTO.setBonusWinnings(toDouble(currentLineArray[4]));
					dtos.add(currentDTO);
					currentDTO = null;
				}
				else {
					//TODO: throw Exception/error log: no corresponding WAGER
				}
			}
		}
		return dtos;
	}
	
	public static LocalDate getDate(String s) {
		return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	public static LocalDate getDate(DimTime dimTime) {
		return LocalDate.of(dimTime.getYear(), dimTime.getMonth(), dimTime.getDay());
	}
	private static Double toDouble (String s) {
		return new Double(s.replace(',', '.'));
	}
	
	public static List<DimPlayerDTO> getDimPlayerDTOs(List<String> playersString) {
		List<DimPlayerDTO> list = new ArrayList<>();
		for (String currentLine :playersString) {
			String[] currentLineArray = currentLine.split(";");
			list.add(new DimPlayerDTO(currentLineArray[0], currentLineArray[1]));
		}
		return list;
	}
	
	
}
