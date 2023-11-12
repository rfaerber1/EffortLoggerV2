package application;

public class Defect extends EffortLog{
	private String name;
	
	
	public Defect(String deliverable, String lifeCycleStep) {
		super(deliverable, lifeCycleStep, "defect");
	}
}