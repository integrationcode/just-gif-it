package com.other.externalize.health;

import javax.inject.Inject;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.justgifit.JustGifItProperties;

@Component("JustGifIt")
public class JustGifItHealthIndicator implements HealthIndicator {
	
	@Inject
	private JustGifItProperties properties;
	
	
	@Override
	public Health health() {
		System.out.println("*****INSIDE CUSTOM HEALTH***************");
		if(!properties.getGifLocation().canWrite()) {
			return Health.down().build();
		}
		return Health.up().build();
	}

}
