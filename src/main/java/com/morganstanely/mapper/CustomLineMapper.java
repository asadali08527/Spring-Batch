package com.morganstanely.mapper;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;

import com.morganstanely.pojo.DetailRecord;
import com.morganstanely.pojo.HeaderRecord;
import com.morganstanely.pojo.Records;
import com.morganstanely.pojo.TrailerRecord;

public class CustomLineMapper implements LineMapper<Records> {

	public LineTokenizer lineTokenizer;

	@Override
	public Records mapLine(String line, int lineNumber) throws Exception {

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		if (line.charAt(0) == '1') {
			String newLine = null;
			StringBuilder sb = new StringBuilder(line);
			sb.insert(1, ",").insert(8, ",").insert(19, ",")/* .insert(30, ",") */;
			newLine = sb.toString();
			System.out.println("Old line=" + line + "::::::: New Line=" + newLine);
			delimitedLineTokenizer.setDelimiter(",");
			String[] names = { "recordType", "productCode", "fileCreationDate", "billingDate" };
			delimitedLineTokenizer.setNames(names);
			setLineTokenizer(delimitedLineTokenizer);
			BeanWrapperFieldSetMapper<HeaderRecord> fieldSetMapper = new BeanWrapperFieldSetMapper<HeaderRecord>();
			fieldSetMapper.setTargetType(HeaderRecord.class);
			return fieldSetMapper.mapFieldSet(delimitedLineTokenizer.tokenize(newLine));

		} else if (line.charAt(0) == '2') {
			String newLine = null;
			StringBuilder sb = new StringBuilder(line);
			sb.insert(1, ",").insert(8, ",").insert(17, ",").insert(27, ",").insert(29, ",").insert(31, ",")
					.insert(41, ",").insert(62, ",").insert(79, ",")/* .insert(89, ",") */;
			newLine = sb.toString();
			System.out.println("Old line=" + line + "::::::: New Line=" + newLine);
			delimitedLineTokenizer.setDelimiter(",");
			String[] names = { "recordType", "productCode", "policyContractId", "employeeId", "memberSpouseIndicator",
					"paidByIndicator", "premiumAmount", "lastName", "firstName", "collectionNumber" };
			delimitedLineTokenizer.setNames(names);
			setLineTokenizer(delimitedLineTokenizer);
			BeanWrapperFieldSetMapper<DetailRecord> fieldSetMapper = new BeanWrapperFieldSetMapper<DetailRecord>();
			fieldSetMapper.setTargetType(DetailRecord.class);
			return fieldSetMapper.mapFieldSet(delimitedLineTokenizer.tokenize(newLine));
		} else if (line.charAt(0) == '3') {
			String newLine = null;
			StringBuilder sb = new StringBuilder(line);
			sb.insert(1, ",").insert(8, ",").insert(16, ",")/* .insert(29, ",") */;
			newLine = sb.toString();
			System.out.println("Old line=" + line + "::::::: New Line=" + newLine);
			delimitedLineTokenizer.setDelimiter(",");
			String[] names = { "recordType", "productCode", "detailsRecordCount", "totalPremiumAmount" };
			delimitedLineTokenizer.setNames(names);
			setLineTokenizer(delimitedLineTokenizer);
			BeanWrapperFieldSetMapper<TrailerRecord> fieldSetMapper = new BeanWrapperFieldSetMapper<TrailerRecord>();
			fieldSetMapper.setTargetType(TrailerRecord.class);
			return fieldSetMapper.mapFieldSet(delimitedLineTokenizer.tokenize(newLine));
		}
		return null;

	}

	public LineTokenizer getLineTokenizer() {
		return lineTokenizer;
	}

	public void setLineTokenizer(LineTokenizer lineTokenizer) {
		this.lineTokenizer = lineTokenizer;
	}

}
