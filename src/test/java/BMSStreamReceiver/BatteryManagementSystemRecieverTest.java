package BMSStreamReceiver;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import BatteryParamEvaluator;
import BatteryComputationParam;

import org.junit.Before;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class BatteryManagementSystemRecieverTest {
	List<Integer> TemperatureList=new ArrayList<>();
	List<Double> Charge_RateList=new ArrayList<>();
	
	static BatteryParamEvaluator<?> paramevaluator=new BatteryParamEvaluator();
	static BatteryComputationParam batteryparam=new BatteryComputationParam();
	@Before
	public void setup() {
		
		TemperatureList.add(25);
		TemperatureList.add(26);
		TemperatureList.add(35);
		TemperatureList.add(72);
		TemperatureList.add(63);
		TemperatureList.add(85);
		
		Charge_RateList.add(0.5);
		Charge_RateList.add(0.7);
		Charge_RateList.add(0.9);
		Charge_RateList.add(0.6);
		Charge_RateList.add(0.8);
		Charge_RateList.add(0.95);
		
	}
	
	@Test
	public void givenChargeRateValues_whenListIsEmpty_thenReturnNull() {
		
		List<Double> chargeRateEmptyList = Collections.emptyList();  
		assertNull(paramevaluator.getMaxVal(chargeRateEmptyList));
	 }
	
	@Test
	public void givenTemperatureValues_whenListIsEmpty_thenReturnNull() {
		
		List<Double> TemperatureEmptyList = Collections.emptyList();  
		assertNull(paramevaluator.getMinVal(TemperatureEmptyList));
	 }
	
	
	@Test
	public void givenTemperatureValues_whenListhisnull_thenReturnNull() {
		
		List<Integer> TemperatureListwithNullVal =null;
		assertNull(paramevaluator.getMinVal(TemperatureListwithNullVal));
	 }
	
	@Test
	public void givenChargerate_whenListhisnull_thenReturnNull() {
		
		List<Double> ChargeRateListwithNullVal =null;
		assertNull(paramevaluator.getMinVal(ChargeRateListwithNullVal));
	 }
		
	@Test
	public void givenTemperatureValues_whenComputeMaxVal_thenReturnMax() {
		assertEquals(Integer.valueOf(85),paramevaluator.getMaxVal(TemperatureList));
	 }
	
	@Test
	public void givenTemperatureValues_whenComputeMinVal_thenReturnMin() {
	
		assertEquals(Integer.valueOf(25),paramevaluator.getMinVal(TemperatureList));
	 }
	
	@Test
	public void givenChargeRateValues_whenComputeMaxVal_thenReturnMax() {
		assertEquals(Double.valueOf(0.95),paramevaluator.getMaxVal(Charge_RateList));
	 }
	
	@Test
	public void givenChargeRateValues_whenComputeMinVal_thenReturnMin() {
		assertEquals(Double.valueOf(0.5),paramevaluator.getMinVal(Charge_RateList));
	 }
	
	@Test
	public void givenTemperatureValues_whenComputeAverage_thenReturnAverage() {
	Double temperatureAverage=paramevaluator.getAverageofIntlist(TemperatureList);
	assertEquals(Double.valueOf(56.2),temperatureAverage);
	 }
	
	@Test
	public void givenChargeRateValues_whenComputeAverage_thenReturnAverage() {
	Double chargeRateAverage=paramevaluator.getAverageofDoublelist(Charge_RateList);
	assertEquals(Double.valueOf(0.79),chargeRateAverage);
	 }
	
	@Test
	public void givenTemperatureValues_whenComputeAverage_thenReturnZero() {
		
	List<Integer> temperratureSubList = TemperatureList.subList(3, TemperatureList.size());
	Double temperatureAverage=paramevaluator.getAverageofIntlist(temperratureSubList);
	assertEquals(Double.valueOf(0.0),temperatureAverage);
	 }
	
	@Test
	public void givenChargeValues_whenComputeAverage_thenReturnZero() {
		
	List<Double> chargeRateSubList = Charge_RateList.subList(3, Charge_RateList.size());
	Double chargeRateAverage=paramevaluator.getAverageofDoublelist(chargeRateSubList);
	assertEquals(Double.valueOf(0.0),chargeRateAverage);
	 }
	
	@Test
	public void checkRecieverReportPrinting() {
	paramevaluator.getMinVal(TemperatureList);
	paramevaluator.getMaxVal(TemperatureList);
	paramevaluator.getMaxVal(Charge_RateList);
	paramevaluator.getMinVal(Charge_RateList);
	paramevaluator.getAverageofDoublelist(Charge_RateList);
	paramevaluator.getAverageofIntlist(TemperatureList);
	IReportPrinter reportPrinterMock = Mockito.mock(ConsolePrinter.class);
	((ConsolePrinter) reportPrinterMock).printToConsole(batteryparam);
	((ConsolePrinter) Mockito.verify(reportPrinterMock, Mockito.times(1))).printToConsole(batteryparam);
	}
	
}
