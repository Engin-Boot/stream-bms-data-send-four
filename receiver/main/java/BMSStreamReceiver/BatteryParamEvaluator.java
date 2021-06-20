package BMSStreamReceiver;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import junit.framework.Test;

public class BatteryParamEvaluator<T> {


	public <T extends Object & Comparable<? super T>> T  getMinVal(List<T> datalist) {
		
		
		if((boolean) checkIfListIsValid((List<T>) datalist)) {
			return null;
		}
		   T minimum = Collections.min( datalist );
		    return minimum;
	}

	
	public <T extends Object & Comparable<? super T>> T getMaxVal(List<T> datalist) {
		if((boolean) checkIfListIsValid((List<T>) datalist)) {
			return null;
		}
		 T maximum = Collections.max( datalist );
		 return maximum;	
	}
	
	public <T extends Object & Comparable<? super T>> boolean checkIfListIsValid(List<T> datalist) {
		
		if(Objects.isNull(datalist) || null == datalist || datalist.isEmpty()) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean IsListValidToComputeAverage(List<T> datalist) {
		return (Objects.isNull(datalist) || null == datalist || datalist.isEmpty()||datalist.size()<5);
	}
	
	
	public double getAverageofDoublelist(List<Double> chargeRateList) {
		if(IsListValidToComputeAverage((List<T>) chargeRateList)) {
			return 0.0;
		}
		
		List<Double> chargeRateSubList = chargeRateList.subList(chargeRateList.size() - 5, chargeRateList.size());
		return chargeRateSubList.stream().mapToDouble(chargeRate -> chargeRate).average().orElse(0.0f);
	}
	
	public double getAverageofIntlist(List<Integer> templist) {
		if(IsListValidToComputeAverage((List<T>) templist)) {
			return 0.0;
		}
		
		
		List<Integer> chargeRateSubList = templist.subList(templist.size() - 5, templist.size());
		return chargeRateSubList.stream().mapToDouble(temperature -> temperature).average().orElse(0.0f);
	}
	
		
}
