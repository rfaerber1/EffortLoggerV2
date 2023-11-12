/**
 * Name: UserStory Class
 * Description: Creates User stories (name and description) and can contain effort and defect logs relevant to the user story implementation
 * Author: Raylene Faerber
 */
package application;

import java.util.ArrayList;
import java.util.List;

public class UserStory {
	private String name;
	private String description;	
	
	// track progress in implementing user story
	private ArrayList<EffortLog> effortLogs = new ArrayList<EffortLog>();
	private ArrayList<Defect> defects = new ArrayList<Defect>();
	
	
	public UserStory(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
	public void createEffortLog(EffortLog effortLog) {
		effortLogs.add(effortLog);
	}
	
	public ArrayList<EffortLog> getEffortLogs(){
		return effortLogs;
	}
	
	public void createDefectLog(Defect defectLog) {
		defects.add(defectLog);
	}

	public ArrayList<Defect> getDefectLogs(){
		return defects;
	}
	
	
}