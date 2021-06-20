package BMSStreamReceiver;

public class ConsolePrinter implements IReportPrinter {

	@Override
	public void printToConsole(BatteryComputationParam batteryparam) {
	//	if(batteryparam.getMaxChargeRate()==null||batteryparam.getMinChargeRate()==null||batteryparam.getMaxTemperature()==null||batteryparam.getMinTemperature()==null)
		
		System.out.println("Maximum charge rate: "+ batteryparam.getMaxChargeRate());
		System.out.println("Minimum charge rate: "+ batteryparam.getMinChargeRate());
		System.out.println("Average charge rate: "+ batteryparam.getAverageChargeRate());
		System.out.println("Maximum Temperature: "+ batteryparam.getMaxTemperature());
		System.out.println("Minimum Temperature: "+ batteryparam.getMinTemperature());
		System.out.println("Average Temperature: "+ batteryparam.getAverageTemperature());
	}

}
