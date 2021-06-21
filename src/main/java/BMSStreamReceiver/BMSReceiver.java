package BMSStreamReceiver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BMSReceiver {
	
	public static BufferedReader in;
	static List<Double> Charge_rate = new ArrayList<>();
	static List<Integer> Temperature = new ArrayList<>();
	static InputStreamFormatter inputFormatter=new InputStreamFormatter();
	static BatteryParamEvaluator<?> paramevaluator=new BatteryParamEvaluator();
	static BatteryComputationParam batteryparam=new BatteryComputationParam();
	public static void main(String[] args) throws IOException {
		String getData = null;
		in=new BufferedReader(new InputStreamReader(System.in));
		getData=in.readLine().trim();
	
		if(getData.equalsIgnoreCase("Charge_rate")) {
			inputFormatter.readChargeRateVal(in);
			inputFormatter.readTemperatureVal(in);
			
			  } 
		else if(getData.equalsIgnoreCase("Temperature")) {
			inputFormatter.readTemperatureVal(in);
			inputFormatter.readChargeRateVal(in);
			  }
		
		batteryparam.setMaxChargeRate(paramevaluator.getMaxVal(Charge_rate));
		batteryparam.setMinChargeRate(paramevaluator.getMinVal(Charge_rate));
		batteryparam.setMaxTemperature(paramevaluator.getMaxVal(Temperature));
		batteryparam.setMinTemperature(paramevaluator.getMinVal(Temperature));
		
		batteryparam.setAverageChargeRate(paramevaluator.getAverageofDoublelist(Charge_rate));
		batteryparam.setAverageTemperature(paramevaluator.getAverageofIntlist(Temperature));
		
		
		IReportPrinter consoleReporter = new ConsolePrinter();
		consoleReporter.printToConsole(batteryparam);
		
		
	}
	
	
	
	
	
}
