package net.mgorski.java8.mod01;

import java.util.List;

import net.mgorski.java8.helpers.CsvLoader;
import net.mgorski.java8.helpers.TransactionDto;

public class CsvProcessing {

	public static void main(String[] args) {
		List<TransactionDto> processInputFile = new CsvLoader().processInputFile("sample_transactions.csv");
		processInputFile.forEach(System.out::println);
	}

}
