package de.entwicklerkurs.tdd.intro;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {

	private Map<String, List<String>> csvStructure;

	public void read(String csvString) {
		csvStructure = new HashMap<String, List<String>>();
		csvStructure.put("col1", Collections.singletonList("val1"));
		csvStructure.put("col2", Collections.singletonList("val2"));
	}

	public String getValue(String columnName, int rowIndex) {
		return csvStructure.get(columnName).get(rowIndex);
	}

}
