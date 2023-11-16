package application;

public class Defect extends EffortLog{
	private String name;
	
	
	public Defect(String name, String deliverable, String lifeCycleStep) {
		super(deliverable, lifeCycleStep, "defect");
		
		this.name = name;
	}
	
	public String getDefectName() {
		return name;
	}
}