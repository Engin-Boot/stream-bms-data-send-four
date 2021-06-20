package BMSStreamReceiver;

import java.io.BufferedReader;
import java.io.IOException;


public class InputStreamFormatter extends BMSReceiver{
	
	String consoleReadline;

	public void readChargeRateVal(BufferedReader bf) throws IOException {
		
		  while((consoleReadline = bf.readLine()) != null) {
			  if(consoleReadline.equalsIgnoreCase("Temperature")) {
				  return ;
						  }
		  ValidateAndStoreChargeRateVal(consoleReadline);
		  }
		 
		
	}
	
	

	public void readTemperatureVal(BufferedReader bf) throws IOException {
		
		  while((consoleReadline = bf.readLine()) != null) {
		  if(consoleReadline.equalsIgnoreCase("Charge_rate")) {
			  return;
					  }
		  ValidateAndStoreTemperatureVal(consoleReadline);
		  }
		 
		
	}
	
	private void ValidateAndStoreChargeRateVal(String chargeRateStr) {
		if(!chargeRateStr.trim().equals("")) {
			  Double chargeRateVal = Double.parseDouble(chargeRateStr);
			  Charge_rate.add(chargeRateVal);
			  }
		
	}
	
	private void ValidateAndStoreTemperatureVal(String temperatureStr) {
		if(!temperatureStr.trim().equals("")) {
			  int chargeRateVal = Integer.parseInt(temperatureStr);
			  Temperature.add(chargeRateVal);
			  }
		
	}
	
}
