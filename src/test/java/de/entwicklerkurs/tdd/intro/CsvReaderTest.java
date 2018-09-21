package de.entwicklerkurs.tdd.intro;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class CsvReaderTest {

	private CsvReader csvReader;

	@Before
	public void initReader() {
		csvReader = new CsvReader();
	}

	@Test
	public void readColumnByNameAtRowIndex() throws Exception {
		csvReader.read("col1\nval1");
		String value = csvReader.getValue("col1", 0);
		assertThat(value, Matchers.is("val1"));
	}

	@Test
	public void readColumnByNameAtRowIndexTwoColumns() throws Exception {
		csvReader.read("col1,col2\nval1,val2");
		String value = csvReader.getValue("col2", 0);
		assertThat(value, Matchers.is("val2"));
	}
}
