package BMSStreamReceiver;

public class BatteryComputationParam {
	private Double maxChargeRate;
	private Double minChargeRate;
	private Integer minTemperature;
	private Integer maxTemperature;

	private Double averageChargeRate;
	private Double averageTemperature;
	
	
	public Double getMaxChargeRate() {
		return maxChargeRate;
	}
	public void setMaxChargeRate(Double maxChargeRate) {
		this.maxChargeRate = maxChargeRate;
	}
	public Integer getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(Integer maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	public Double getAverageChargeRate() {
		return averageChargeRate;
	}
	public void setAverageChargeRate(Double averageChargeRate) {
		this.averageChargeRate = averageChargeRate;
	}
	public Double getAverageTemperature() {
		return averageTemperature;
	}
	
	public void setAverageTemperature(Double averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	public Double getMinChargeRate() {
		return minChargeRate;
	}
	public void setMinChargeRate(Double minChargeRate) {
		this.minChargeRate = minChargeRate;
	}
	public Integer getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(Integer minTemperature) {
		
		this.minTemperature = minTemperature;
	}
}
