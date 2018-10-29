package com.spring.myapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.spring.myapp.constant.ApplicationConstants;

@Service
public class BooksPreProcessorService {
	
	@Autowired
	private CsvToJsonParserService csvToJsonParserService;
	
	@Value("classpath:input.csv")
	private Resource inputFile;

	public List<Map<String,String>> processInputFile(Map<String, Object> messageMap){
		
		// use messageMap to get Path of file
		List<Map<String, String>> inputDataRowList = null;
		
		inputDataRowList = csvToJsonParserService.readObjectFromCsv(inputFile);
		
		List<Map<String, String>> dataRowList = null;
		
		inputDataRowList.forEach(row ->
		{
			row.put(ApplicationConstants.BOOK_TITLE,row.remove("TITLE"));
			row.put(ApplicationConstants.BOOK_PRICE,row.remove("PRICE"));
			row.put(ApplicationConstants.BOOK_AUTHOR,row.remove("AUTHOR"));
			
			dataRowList.add(row);
		});
		
		return dataRowList;
		
		
	}
}
