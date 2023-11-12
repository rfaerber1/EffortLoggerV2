package application;
 
 
public class EffortLog{
	private String deliverable;
	private String lifeCycleStep;
	private String effortCategory;
	private double timeSpent = 0;
	
	/**
	 * 
	 * @param deliverable
	 * @param lifeCycleStep
	 * @param effortCategory
	 */
	public EffortLog(String deliverable, String lifeCycleStep, String effortCategory) {
		this.deliverable = deliverable;
		this.lifeCycleStep = lifeCycleStep;
		this.effortCategory = effortCategory;
	}
	
	public String getDeliverable() {
		return deliverable;
	}
	
	public String getLifeCycleStep() {
		return lifeCycleStep;
	}
	
	public String getEffortCategory() {
		return effortCategory;
	}
	
	public void setTimeSpent(double time) {
		timeSpent = time;
	}
	
	public double getTimeSpent() {
		return timeSpent;
	}
	
	public String getLog() {
		return "Life Cycle Step: " + lifeCycleStep + "\n" + 
				"Effort Category: " + effortCategory + "\n" +
				"Deliverable: " + deliverable + "\n";
	}
	
}