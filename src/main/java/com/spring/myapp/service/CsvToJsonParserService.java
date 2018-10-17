package com.spring.myapp.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.spring.myapp.exception.ApplicationException;

@Service
public class CsvToJsonParserService {

	private static final Logger log = LoggerFactory.getLogger(CsvToJsonParserService.class);

	public List<Map<String, String>> readObjectFromCsv(Resource resource) {

		List<Map<String, String>> inputDataObjectList = null;
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
		CsvMapper mapper = new CsvMapper();

		try {
			List dataMap = mapper.readerFor(Map.class).with(schema).readValues(resource.getInputStream()).readAll();
			inputDataObjectList = dataMap;

			log.info("Size of datamap{}", dataMap.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error while processing CSV, Cause{}", e.getMessage());
			throw new ApplicationException(ApplicationException.EXCEPTION_DATA_NOT_FOUND,"Data not found");
		}

		return inputDataObjectList;

	}

}
