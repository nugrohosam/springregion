package com.nugrohosamiyono.springregion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringregionApplicationTests {

	@Test
	void contextLoads() {
		for (int i = 1; i <= 30; i++) {
			if (i == 1) {
				System.out.println("prima : " + i);
				continue;
			}

			int tryDevide = 2;
			while (true) {
				if (i % tryDevide == 0 && tryDevide < i) {
					System.out.println("not prima : " + i);
					break;
				} else if (tryDevide == i) {
					System.out.println("prima : " + i);
				}
				tryDevide++;
			}
		}
	}
}
