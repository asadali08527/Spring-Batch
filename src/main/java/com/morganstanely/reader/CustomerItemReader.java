package com.morganstanely.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.morganstanely.pojo.Records;

public class CustomerItemReader implements ItemReader<Records> {

	private ItemReader<Records> delegate;

	@Value("${input}")
	private Resource resource;

	public CustomerItemReader(Resource resource) {
		this.resource = resource;

	}

	@Override
	public Records read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if (delegate == null) {
			delegate = new IteratorItemReader<>(records());
		}
		return delegate.read();
	}

	private List<Records> records() {
		// TODO Auto-generated method stub
		return null;
	}

}
