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
	private static int length = 0;
	
	public Data() {
		
	}
	
	public static String[] getProjectNames() {
		String[] names = new String[length];
		for (int i = 0; i < length; i++) {
			names[i] = projects[i].getName();
		}
		return names;
	}
	
	public static int getNumberOfProjects() {
		return length;
	}
	
	public static void addProject(Project project) {
		if (length < 10) {
			projects[length] = project;
			length ++;
		}
	}
	
	public static Project getProject(String name) {
		for (int i = 0; i < length; i ++) {
			if(name.equals(projects[i].getName())) {
				return projects[i];
			}
		}
		return null;
	}
	
}