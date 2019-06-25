package chenqx.csvtest;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class CsvTest {
    private Map<String ,CSVRecord> i18nMap = Maps.newHashMap();

    @Before
    public void init() {
        String i18key="name";
        String[] headers = new String[0];
        InputStream in = this.getClass().getResourceAsStream("/map.csv");
        CSVFormat format = CSVFormat.DEFAULT.withHeader(headers).withSkipHeaderRecord().withIgnoreHeaderCase().withTrim();

        try {
            CSVParser csvParser = CSVParser.parse(in, Charsets.UTF_8, format);
            List<CSVRecord> records = csvParser.getRecords();
            records.forEach((record) -> {
                i18nMap.put(record.get(i18key), record);
            });
        } catch (IOException var8) {

        }

    }


    @Test
    public void getCsv(){
        i18nMap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v.get("name"));
            System.out.println(v.get("auth"));
        });
    }
}
