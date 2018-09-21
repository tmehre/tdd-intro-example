package de.entwicklerkurs.tdd.intro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleCsvReader {

	private Map<String, List<String>> csvData = new HashMap<String, List<String>>();
	private Map<Integer, String> columnIdxInfo;

	public void read(String csvString) {
		if(csvString.isEmpty()) {
			throw new IllegalArgumentException("CSV string cannot be null or empty.");
		}
		String[] rows = csvString.split("\n");
		for (int rowIdx = 0; rowIdx < rows.length; rowIdx++) {
			if (isMetaRow(rowIdx)) {
				initColumnMetaInfo(rows, rowIdx);
			} else {
				mapValuesToColumns(rows, rowIdx);
			}
		}
	}

	private boolean isMetaRow(int rowIdx) {
		return rowIdx == 0;
	}

	private void mapValuesToColumns(String[] rows, int rowIdx) {
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

	private void initColumnMetaInfo(String[] rows, int rowIdx) {
		columnIdxInfo = new HashMap<Integer, String>();
		String[] columnNames = rows[rowIdx].split(",");
		for (int colIdx = 0; colIdx < columnNames.length; colIdx++) {
			columnIdxInfo.put(colIdx, columnNames[colIdx]);
		}
	}

	public String getValue(String columnName, int rowIndex) {
		return csvData.get(columnName).get(rowIndex);
	}

}
