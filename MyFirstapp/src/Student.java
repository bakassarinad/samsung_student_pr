import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class Student {
	String name;
	String surname;
	int id = 0;
	int mark;
	int COURSES = 8;
	int groupId;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	ArrayList<Integer> marks = new ArrayList<Integer>(COURSES);
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		
		this.mark = mark;
		this.marks.add(mark);
	}

	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;	
	}
	
	public Student(int mark) {
		this.mark = mark;
	}
	
	
	public double avgMark(ArrayList<Integer> marks) {
		if (marks != null && marks.size() != 0) {
		double sum = 0;
		for (int i = 0; i < marks.size(); ++i) {
			sum += marks.get(i);
		
		}
		return sum/marks.size();
		}
		return 0;
	}
	public  void passExam(int mark) {
		if (mark > 3) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}
	
	
	
	
	public String toString() {
		return this.getId() + "\n" + this.getName() + "\n" + this.getSurname();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Integer> getMarks() {
		return marks;
	}
	public void setMarks(ArrayList<Integer> marks) {
		if (marks.size() <= 8) {
		this.marks = marks;
		}
	
	}
	
	
	
}
