package application;
 
 
public class EffortLog{
	private String name;
	
	private String deliverable;
	private String lifeCycleStep;
	private String effortCategory;
	
	private double timeSpent = 0;
	private String date = "0000-00-00";
	private String startTime = "00:00:00";
	private String endTime = "00:00:00";
	
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
		
		this.name = "Some amalgamation";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setStartTime(String time) {
		this.startTime = time;
	}
	
	public String getSartTime() {
		return startTime;
	}
	
	public void setEndTime(String time) {
		this.endTime = time;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	
	public String getLog() {
		return "Life Cycle Step: " + lifeCycleStep + "\n" + 
				"Effort Category: " + effortCategory + "\n" +
				"Deliverable: " + deliverable + "\n";
	}
	
}