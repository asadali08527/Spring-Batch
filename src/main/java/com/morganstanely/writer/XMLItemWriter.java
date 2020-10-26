package com.morganstanely.writer;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.annotation.AfterWrite;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.morganstanely.pojo.Records;

@Component
public class XMLItemWriter implements ItemWriter<Records> {
	private String filename = new Date().getTime() + "-my-file.xml";

	@Value("${output1}")
	String output1;
	@Value("${output2}")
	String output2;

	@Override
	public void write(List<? extends Records> records) throws Exception {
		String xml = "";
		for (Records record : records) {
			XmlMapper xmlMapper = new XmlMapper();
			xml += xmlMapper.writeValueAsString(record);
		}
		xml = addRootElement(xml);
		writeFile(xml, output1, 0);

	}

	private String addRootElement(String xml) {
		return "<records>" + xml + "</records>";
	}

	private void writeFile(String xml, String destination, int counter) throws IOException {
		java.io.FileWriter fw = new java.io.FileWriter(destination + filename);
		fw.write(xml);
		fw.close();
		if (counter < 1) {
			counter += 1;
			writeFile(xml, output2, counter++);
		}
	}

}
