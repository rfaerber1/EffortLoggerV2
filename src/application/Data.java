/**
 * Name: Data Class
 * Description: Class holding data(effort and defect logs) for all projects
 * Author: Raylene Faerber
 */

package application;

public class Data {
	
	// initialized with number of max projects
	private static Project[] projects = new Project[10];
	
	// number of projects in array
	private static int numOfProjects = 0;
	
	public Data() {
		
	}
	
	public static String[] getProjectNames() {
		String[] names = new String[numOfProjects];
		for (int i = 0; i < numOfProjects; i++) {
			names[i] = projects[i].getName();
		}
		return names;
	}
	
	public static int getNumberOfProjects() {
		return numOfProjects;
	}
	
	public static boolean addProject(Project project) {
		for (int i = 0; i < numOfProjects; i++) {
			if(project.getName() == projects[i].getName()) {
				return false;
			}
		}
		if (numOfProjects < 10) {
			projects[numOfProjects] = project;
			numOfProjects ++;
		}
		return true;
	}
	
	public static Project getProject(String name) {
		for (int i = 0; i < numOfProjects; i ++) {
			if(name.equals(projects[i].getName())) {
				return projects[i];
			}
		}
		return null;
	}
	
}