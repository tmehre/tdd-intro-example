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
		assertColumnValueAtRow(0, "col1", "val1");
	}

	@Test
	public void readColumnByNameAtRowIndexTwoColumns() throws Exception {
		csvReader.read("col1,col2\nval1,val2");
		assertColumnValueAtRow(0, "col2", "val2");
	}

	private void assertColumnValueAtRow(int rowIndex, String columnName, String expectedValue) {
		String value = csvReader.getValue(columnName, rowIndex);
		assertThat(value, Matchers.is(expectedValue));
	}
}
