package application;
 
 
public class EffortLog{
	String deliverable;
	String lifeCycleStep;
	String effortCategory;
	double timeSpent = 0;
	
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
	
}