package com.morganstanely.writer;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.morganstanely.pojo.Records;

@Component
public class XMLItemWriter implements ItemWriter<Records> {
	@Value("${output}")
	String output;

	@Override
	public void write(List<? extends Records> records) throws Exception {

		XmlMapper xmlMapper = new XmlMapper();
		String xml = xmlMapper.writeValueAsString(records);
		writeFile(xml);
	}

	private void writeFile(String xml) throws IOException {
		java.io.FileWriter fw = new java.io.FileWriter(output + new Date().getTime() + "-my-file.xml");
		fw.write(xml);
		fw.close();
	}

}
