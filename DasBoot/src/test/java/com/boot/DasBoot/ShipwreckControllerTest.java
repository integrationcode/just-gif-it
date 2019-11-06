package com.boot.DasBoot;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.DasBoot.controller.ShipwreckController;
import com.boot.DasBoot.model.Shipwreck;
import com.boot.DasBoot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1l);
		Optional<Shipwreck> sw = Optional.of(shipwreck);
		
		when(shipwreckRepository.findById(1l)).thenReturn(sw);
		
		//Mocketio will mock this object
		Shipwreck wreck = sc.list(1L).getBody();
		verify(shipwreckRepository).findById(1l);
		System.out.println("************"+wreck);
		//Junit
		//assertEquals(1l, wreck.getId().longValue());
		
		//Hamcrest Matchers
		assertThat(wreck.getId(), is(1l));
	}

}
