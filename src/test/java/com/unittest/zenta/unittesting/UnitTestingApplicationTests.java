package com.unittest.zenta.unittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testInit() {
		UnitTestingApplication.main(new String[] {});

	}

}
