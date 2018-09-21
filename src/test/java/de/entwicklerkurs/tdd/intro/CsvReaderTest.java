package de.entwicklerkurs.tdd.intro;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class CsvReaderTest {

	private SimpleCsvReader csvReader;

	@Before
	public void initReader() {
		csvReader = new SimpleCsvReader();
	}

	@Test
	public void readColumnByNameAtRowIndex() throws Exception {
		csvReader.read("col1\nval1");
		assertColumnValueAtRow(0, "col1", "val1");
	}

	@Test
	public void readColumnByNameAtRowIndexZeroColumn2() throws Exception {
		csvReader.read("col1,col2\nval1,val2");
		assertColumnValueAtRow(0, "col2", "val2");
	}
	
	@Test
	public void readColumnByNameAtRowIndexZeroColumn1() throws Exception {
		csvReader.read("col1,col2\nval1,val2");
		assertColumnValueAtRow(0, "col1", "val1");
	}
	
	@Test
	public void readColumnByNameAtRowIndex1Column2() throws Exception {
		csvReader.read("col1,col2\nval11,val12\nval21,val22");
		assertColumnValueAtRow(1, "col1", "val21");
	}
	
	@Test
	public void readColumnByNameAtRowIndex1Column1() throws Exception {
		csvReader.read("col1,col2\nval11,val12\nval21,val22");
		assertColumnValueAtRow(1, "col1", "val21");
	}
	
	@Test
	public void readColumnByNameAtRowIndex2Column2() throws Exception {
		csvReader.read("col1,col2\nval11,val12\nval21,val22\nval31,val32");
		assertColumnValueAtRow(2, "col2", "val32");
	}

	private void assertColumnValueAtRow(int rowIndex, String columnName, String expectedValue) {
		String value = csvReader.getValue(columnName, rowIndex);
		assertThat(value, Matchers.is(expectedValue));
	}
}
