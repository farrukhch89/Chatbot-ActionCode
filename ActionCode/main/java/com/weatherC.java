package com;
import java.io.File;
import org.alicebot.ab.Bot;
import org.alicebot.ab.MagicBooleans;

import java.util.Random;
import java.util.Scanner;

import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

public class weatherC {
    public static void main(String[] args) throws APIException
    {
        
    	weatherCheck();
    }
    
    public static void weatherCheck()  
    		throws APIException{
       	Scanner kb = new Scanner(System.in);
		
    		int count = 5;
    		for(int i = 0; i<count; i++) {  // take in 5 location
    			System.out.println("");
    			
            //Ask user for location
            System.out.println("Enter a location: ");
            String location = kb.nextLine();
            
            // declaring object of "OWM" class
            OWM owm = new OWM("4f43a9a179f37d605f02fcb0c8487b3e");

            // getting current weather data for the  city
            CurrentWeather cwd = owm.currentWeatherByCityName(location);
            
            // checking data retrieval was successful or not
            if (cwd.hasRespCode() && cwd.getRespCode() == 200) {
            
                // checking if city name is available
                if (cwd.hasCityName()) {
                	System.out.println();
                    //printing city name from the retrieved data
                    System.out.println("City: " + cwd.getCityName());
                }
                
                // checking if max. temp. and min. temp. is available
                if (cwd.hasMainData() && cwd.getMainData().hasTempMax() && cwd.getMainData().hasTempMin()) {
                    // printing the max./min. temperature
					/*
					 * System.out.println("Temperature: " + cwd.getMainData().getTempMax() + "/" +
					 * cwd.getMainData().getTempMin() + "\'K");
					 */
                    System.out.println("Maximum Temperature: " + conversionMax(cwd.getMainData().getTempMax()) + "°C");// max temperature in degree
                    System.out.println("Minimum Temperature: " + conversionMin(cwd.getMainData().getTempMin()) + "°C");// min temperature in degree
                    
                    System.out.println(cloth(cwd.getMainData().getTempMin())); // method to get clothing type
                    
                    
                }
            }
    	}
    }
    
    //cloth selection
	public static String  cloth(Double tempMin) {
    	String typeOfClothing = "";
		if(tempMin < 273.15) { // less than 0 degree
			typeOfClothing = zero();
		}
		else if(tempMin > 273.15 && tempMin <= 283.15  ) { //greater than 0 and less than 10
			typeOfClothing = aboveZero();
			
		}
		else if(tempMin > 283.15 && tempMin <= 288.15) { // greater than 10 and less than 16
			typeOfClothing = aboveTen();
		}
		else if(tempMin > 288.15 && tempMin <= 291.15) { // greater than 15 and less than 19
			typeOfClothing = aboveFifteen();
		}
		else if(tempMin >= 291.15) { //more than 18
			typeOfClothing = aboveEighteen();
		}
		return typeOfClothing;
	}
    

    //convert min temperature from to degree
    public static int conversionMin(Double tempMin) {
    	int minTempInDegree = 0;
  
    	minTempInDegree = (int) (tempMin - 273.15);
    	
		return minTempInDegree;
	}
    
    //convert max temperature from to degree
    public static int conversionMax(Double tempMax) {
    	int maxTempInDegree = 0;
    	
    	maxTempInDegree = (int) (tempMax - 273.15);

		return maxTempInDegree;
	}
    
	// random for temperature below 0
	public static String zero() {
        String[] arr={"It would be very cold, take warm clothes, jackets, scarfs and gloves.",
        			  "It would be very cold, take long warm clothes and warm jacket.", 
        		      "It would be very cold, take sweater, jacket and gloves."};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        String coldString = arr[randomNumber];
        return coldString;
        
	}
	
	//random for temperature between 0 and 10
	public static String aboveZero() {
        String[] arr={"It would be cold, take warm clothes, scarfs and gloves.",
        			  "It would be cold, take long warm clothes and jacket.", 
        		      "It would be cold, take sweater, jacket and gloves."};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        String coldString = arr[randomNumber];
        return coldString;
        
	}
	
	//random for temperature between 10 and 15
	public static String aboveTen() {
        String[] arr={"It would be mild cold, take normal clothing and jacket.",
        			  "It would be mild cold, take warm clothes and light jacket.", 
        		      "It would be mild cold, take warm clothes and jacket."};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        String coldString = arr[randomNumber];
        return coldString;
        
	}
	
	//random for temperature between 15 and 18
	public static String aboveFifteen() {
        String[] arr={"It would be warm, take normal clothing and a light jacket.",
        			  "It would be warm, take light clothes and jacket.", 
        		      "It would be warm, take normal light clothes"};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        String coldString = arr[randomNumber];
        return coldString;
        
	}
	
	//random for temperature 19
	public static String aboveEighteen() {
        String[] arr={"It would be very warm, take light clothes.",
        			  "It would be very warm, take normal light clothes.", 
        		      "It would be very warm, take summer type clothes"};
        Random r = new Random();
        int randomNumber = r.nextInt(arr.length);
        String coldString = arr[randomNumber];
        return coldString;
        
	}

}