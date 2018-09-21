package de.entwicklerkurs.tdd.intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {

	private Map<String, List<String>> csvData = new HashMap<String, List<String>>();
	private Map<Integer, String> columnIdxInfo;

	public void read(String csvString) {
		String[] rows = csvString.split("\n");
		for (int rowIdx = 0; rowIdx < rows.length; rowIdx++) {
			if (rowIdx == 0) {
				// process csv meta row
				columnIdxInfo = new HashMap<Integer, String>();
				String[] columnNames = rows[rowIdx].split(",");
				for (int colIdx = 0; colIdx < columnNames.length; colIdx++) {
					columnIdxInfo.put(colIdx, columnNames[colIdx]);
				}
			} else {
				// process csv data rows
				String[] values = rows[rowIdx].split(",");
				for (int colIdx = 0; colIdx < values.length; colIdx++) {
					List<String> columnValues = csvData.get(columnIdxInfo.get(colIdx));
					if (columnValues == null) {
						columnValues = new ArrayList<String>();
						csvData.put(columnIdxInfo.get(colIdx), columnValues);
					}
					columnValues.add(values[colIdx]);
				}
			}
		}
	}

	public String getValue(String columnName, int rowIndex) {
		return csvData.get(columnName).get(rowIndex);
	}

}
