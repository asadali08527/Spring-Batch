package com.morganstanely.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.morganstanely.pojo.HeaderRecord;

public class RecordFieldSetMapper implements FieldSetMapper<HeaderRecord> {

	@Override
	public HeaderRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		return null;
	}

}
