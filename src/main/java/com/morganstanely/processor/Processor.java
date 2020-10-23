package com.morganstanely.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.morganstanely.pojo.Records;

@Component
public class Processor implements ItemProcessor<Records, Records> {

	@Override
	public Records process(Records item) throws Exception {
		return item;

	}

}
