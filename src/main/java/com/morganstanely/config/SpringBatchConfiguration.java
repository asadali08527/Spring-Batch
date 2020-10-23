package com.morganstanely.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.morganstanely.mapper.CustomLineMapper;
import com.morganstanely.pojo.Records;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration {
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<Records> itemReader, ItemProcessor<Records, Records> itemProcessor,
			ItemWriter<Records> itemWriter) {
		Step step = stepBuilderFactory.get("load-file").<Records, Records>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();
		return jobBuilderFactory.get("Record-Extractor").incrementer(new RunIdIncrementer()).start(step).build();
	}

	@Bean
	public FlatFileItemReader<Records> fileItemReader(
			@Value("${input}") org.springframework.core.io.Resource resource) {
		FlatFileItemReader<Records> flatFileItemReader = new FlatFileItemReader<Records>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("Flat File Reader");
		flatFileItemReader.setLineMapper(new CustomLineMapper());

		return flatFileItemReader;

	}

	

}
