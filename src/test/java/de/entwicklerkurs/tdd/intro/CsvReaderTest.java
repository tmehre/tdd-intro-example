package de.entwicklerkurs.tdd.intro;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class CsvReaderTest {

	@Test
	public void readFromString() throws Exception {
		CsvReader csvReader = new CsvReader();
		csvReader.read("col1\nval1");
		String value = csvReader.getValue("col1", 0);
		assertThat(value, Matchers.is("val1"));
	}
}
