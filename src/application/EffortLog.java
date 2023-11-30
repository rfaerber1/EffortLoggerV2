/**
 * Name: Effort Log Class
 * Description: stores data for each effort log
 * Author(s): Raylene Faerber
 */

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
	public EffortLog(String deliverable, String effortCategory, String lifeCycleStep) {
		this.deliverable = deliverable;
		this.effortCategory = effortCategory;
		this.lifeCycleStep = lifeCycleStep;
		
		this.name = "Some amalgamation";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName() {
		this.name = getLifeCycleStep() + "-" + getEffortCategory() + "-" + getDeliverable() + "-" + getDate();
	}
	
	public String getDeliverable() {
		return deliverable;
	}
	
	public void changeDeliverable(String deliverable) {
		this.deliverable = deliverable;
	}
	
	public String getLifeCycleStep() {
		return lifeCycleStep;
	}
	
	public void changeLifeCycleStep(String step) {
		this.lifeCycleStep = step;
	}
	
	public String getEffortCategory() {
		return effortCategory;
	}
	
	public void changeEffortCategory(String category) {
		this.effortCategory = category;
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
	
	public String getStartTime() {
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