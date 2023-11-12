/**
 * Name: Project Class
 * Description: Creates projects with a name and description, that hold effort logs, defect logs, and user stories relevant to the project
 * Author: Raylene Faerber
 */
package application;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	
	private ArrayList<UserStory> userStories = new ArrayList<UserStory>();
	
	// for effortLogs not assigned to a user story
	private ArrayList<EffortLog> effortLogs = new ArrayList<EffortLog>();
	
	private ArrayList<Defect> defects = new ArrayList<Defect>();
	
	public Project (String name) {
		this.name = name;
	}
	
	/**
	 * @return Name of project
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Checks if user story already exists for a project
	 * @param UserStory name
	 * @return -1 if user story doesn't exist, otherwise return index of user story
	 */
	private int checkForUserStory(String name) {
		for (int i=0; i < userStories.size(); i++){
			if (name.equals( userStories.get(i).getName() )) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Add new user story to a project
	 * @param user story name
	 * @param user story description
	 */
	public void addUserStory (String name, String description) {
		if(checkForUserStory(name) == -1) {
			userStories.add(new UserStory(name, description));
		}
		else {
			// userStory with name already exists within this project
		}
	}
	
	/**
	 * Create log for effort on implementing a user story
	 * @param userStoryName
	 */
	public void createEffortLog(String userStoryName, EffortLog effortLog) {
		int i = checkForUserStory(userStoryName);
		if(i == -1) {
			// user story doesn't exist
		}
		else {
			userStories.get(i).createEffortLog(effortLog);
		}
	}
	
	/*
	 * If Effort Logs and Defects aren't associated with user story
	 */
	
	public void createEffortLog(EffortLog effortLog) {
		effortLogs.add(effortLog);
	}

	public List<EffortLog> getEffortLogs(){
		return effortLogs;
	}
	
	public void createDefectLog(Defect defectLog) {
		defects.add(defectLog);
	}

	public List<Defect> getDefectLogs(){
		return defects;
	}
}