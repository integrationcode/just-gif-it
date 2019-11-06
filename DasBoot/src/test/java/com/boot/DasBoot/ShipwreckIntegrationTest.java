package com.boot.DasBoot;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.boot.DasBoot.model.Shipwreck;
import com.boot.DasBoot.repository.ShipwreckRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =  com.boot.DasBoot.App.class)
public class ShipwreckIntegrationTest {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	public void testFindAll() {
		List<Shipwreck> swrecks = shipwreckRepository.findAll();
		assertThat(swrecks.size(), is(greaterThanOrEqualTo(0)));
	}
}
