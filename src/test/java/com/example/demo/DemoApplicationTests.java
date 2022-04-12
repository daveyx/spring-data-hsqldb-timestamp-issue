package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DataModelRepository dataModelRepository;


	@BeforeEach
	private void beforeAll() {
		DataModel dataModel = DataModel.builder()
				.ts1(new Timestamp(System.currentTimeMillis()))
				.ts2(new Timestamp(System.currentTimeMillis()))
				.build();

		dataModelRepository.save(dataModel);
	}

	@Test
	void test() {
		List<DataModel> data = dataModelRepository.findByTimestamps(
				new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis())
		);

		assertFalse(data.isEmpty());
	}

}
