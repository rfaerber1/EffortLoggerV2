/**
 * Name: Project Class
 * Description: Creates projects with a name and description, and holds effort logs for each project
 * Author: Raylene Faerber
 */
package application;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	
	// array containing the effortlogs
	private ArrayList<EffortLog> effortLogs = new ArrayList<EffortLog>();
	
	public Project (String name) {
		this.name = name;
	}
	
	/**
	 * @return Name of project
	 */
	public String getName() {
		return this.name;
	}
	
	
	/*
	 * Create an Effort Log
	 */
	
	public void createEffortLog(EffortLog effortLog) {
		//effortLog.setName("Effort Log " + (effortLogs.size()+1));
		effortLog.setName();
		effortLogs.add(effortLog);
		
	}

	public ArrayList<EffortLog> getEffortLogs(){
		return effortLogs;
	}
	
	public EffortLog getEffortLog(String name){
		for (int i = 0; i < effortLogs.size(); i ++) {
			if(name.equals(effortLogs.get(i).getName())) {
				return effortLogs.get(i);
			}
		}
		return null;
	}
	
	public String[] getEffortLogNames() {
		String[] names = new String[effortLogs.size()];
		for (int i = 0; i < effortLogs.size(); i++) {
			names[i] = effortLogs.get(i).getName();
		}
		return names;
	}
	
}