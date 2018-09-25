package com.alperguclu.checktc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alperguclu.checktc.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckTcApplicationTests {

	@Autowired
	private Client client;

	@Test
	public void checkTC() {
		assertFalse(client.check("CAN", "TEK", 1981, 12345678902L));
	}

}
