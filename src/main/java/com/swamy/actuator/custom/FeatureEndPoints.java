package com.swamy.actuator.custom;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "features")
public class FeatureEndPoints {

	private Map<String,Feature>map = new ConcurrentHashMap<>();

	public FeatureEndPoints() {
		map.put("EMPLOYEE" , new Feature(true, "Employee"));
		map.put("USER" , new Feature(false, "User"));
	}

	@ReadOperation
	public Map<String,Feature>features(){
		return map;
	}
	
	@ReadOperation
	public Feature feature(@Selector String name) {
		return map.get(name);
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class Feature{
	
		private boolean isEnabled;
		private String moduleName;
		
	}
}




