package net.mgorski.java8.helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("EEE MMM d HH:mm:ss z yyyy");

    public List<ApartmentDto> processInputFile(String inputFilePath) {
        List<ApartmentDto> inputList = new ArrayList<ApartmentDto>();
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(inputFilePath);
            InputStream inputFS = new FileInputStream(resource.getFile());
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (IOException e) {
            LOG.error(e.getMessage());

        }
        return inputList;
    }

    private Function<String, ApartmentDto> mapToItem = (line) -> {

        String[] p = line.split(COMMA);

        final ApartmentDto item = new ApartmentDto();
        item.setStreet(p[0]);
        item.setCity(p[1]);
        item.setBeds(Integer.parseInt(p[4]));
        item.setBaths(Integer.parseInt(p[5]));
        item.setId(Long.parseLong(p[6]));
        item.setSaleDate(LocalDate.parse(p[8], FORMATTER));
        item.setPrice(new BigDecimal(p[9]));
        item.setLatitude(Double.valueOf(p[10]));
        item.setLongitude(Double.valueOf(p[11]));

        return item;
    };
}
