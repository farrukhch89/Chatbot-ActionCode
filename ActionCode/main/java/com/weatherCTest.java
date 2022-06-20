package com;

import static org.junit.Assert.*;

import org.junit.Test;

public class weatherCTest {

	@Test
	public void testClothes() {
		weatherC weather = new weatherC();
		 String clothingExpected = weather.cloth(273.15);
		 String testActual = "Its Warm";
		 assertNotSame(clothingExpected, testActual);
	}
	
	@Test
	public void testMin() {
		weatherC temperature = new weatherC();
		int minExpected = temperature.conversionMin(273.15);
		int minActual = 0;
		
		assertEquals(minExpected, minActual);
	}
	
	@Test
	public void testMax() {
		weatherC temperature = new weatherC();
		int maxExpected = temperature.conversionMax(273.15);
		int maxActual = 0;
		
		assertEquals(maxExpected, maxActual);
	}
	
	@Test
	public void testTemperatureZero() {
		weatherC temperatureCheck = new weatherC();
		String Expected = temperatureCheck.zero();
		String Actual = "Its cold";
		
		assertNotEquals(Expected, Actual);
	}
	
	@Test
	public void testTemperatureAboveZero() {
		weatherC temperatureCheck = new weatherC();
		String Expected = temperatureCheck.aboveZero();
		String Actual = "Its not that cold";
		
		assertNotEquals(Expected, Actual);
	}
	
	@Test
	public void testTemperatureAboveTen() {
		weatherC temperatureCheck = new weatherC();
		String Expected = temperatureCheck.aboveTen();
		String Actual = "Its not that cold";
		
		assertNotEquals(Expected, Actual);
	}
	
	@Test
	public void testTemperatureAboveFifteen() {
		weatherC temperatureCheck = new weatherC();
		String Expected = temperatureCheck.aboveFifteen();
		String Actual = "Its warm";
		
		assertNotNull(Expected, Actual);
	}
	
	@Test
	public void testTemperatureAboveEighteen() {
		weatherC temperatureCheck = new weatherC();
		String Expected = temperatureCheck.aboveEighteen();
		String Actual = "Its very warm";
		
		assertNotNull(Expected, Actual);
	}
	
	
	 


}
