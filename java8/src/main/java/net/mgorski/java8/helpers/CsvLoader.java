package net.mgorski.java8.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.mgorski.java8.mod01.FileListing;

public class CsvLoader {

	private static Logger LOG = LoggerFactory.getLogger(FileListing.class);

	private final static String COMMA = ",";
	
	public List<TransactionDto> processInputFile(String inputFilePath) {
		List<TransactionDto> inputList = new ArrayList<TransactionDto>();
		try {
			File inputF = new File(inputFilePath);

			URL resource = Thread.currentThread().getContextClassLoader().getResource(inputFilePath);
			
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			LOG.error(e.getMessage());

		}
		return inputList;
	}

	private Function<String, TransactionDto> mapToItem = (line) -> {
		String[] p = line.split(COMMA);// a CSV has comma separated lines
		TransactionDto item = new TransactionDto();
		// item.setItemNumber(p[0]);//<-- this is the first column in the csv file
		if (p[3] != null && p[3].trim().length() > 0) {
			// item.setSomeProeprty(p[3]);
		}
		// more initialization goes here
		return item;

	};
}
