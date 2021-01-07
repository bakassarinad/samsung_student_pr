
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;
import java.util.ArrayList;



	
public class MyClass {

	public static void main(String[] args) throws Exception {
		StudentList students = new StudentList();
		GroupList groups = new GroupList();
		students.importFromFile();
		//groups.importFromFileGroup();
		boolean menu = true;
		Scanner scan = new Scanner(System.in);
		while (menu) {
		
		System.out.println("Choose CRUD:\n"
		       + "1. Add student\n"
		       + "2. Update student\n" 
		       + "3. Get students\n"
		       + "4. Get a student\n" 
		       + "5. Remove student\n" 
		       + "6. Put marks\n"
		       + "7. Exit\n"
		       + "8. Add group\n"
		       + "9. Get Students by group\n"
		       + "10. Get Groups\n"
		       + "11. Add to student a group");
			   
		int option = scan.nextInt();
		switch (option) {
		case (1):
			String name = scan.next();
			String surname = scan.next();
			students.add(new Student(name, surname));
			students.getArrayStudents();
			break;
			
		case (2):
			System.out.println("Enter id: ");
			int id = scan.nextInt();
			System.out.println("Enter new name: ");
			String newName = scan.next();
			System.out.println("Enter new surname: ");
			String newSurname = scan.next();
			students.update(id, new Student(newName, newSurname));
			students.getArrayStudents();
			break;
			
		case (3):
			students.getArrayStudents();
			break;
			
		case (4):
			System.out.println("Enter id: ");
			int id4 = scan.nextInt();
			System.out.println("Name: " + students.getStudent(id4).getName() +"\nSurname: "+ students.getStudent(id4).getSurname()+"/nAvg Mark: " + students.getStudent(id4).avgMark(students.getStudent(id4).getMarks()));
			break;
		case (5):
			System.out.println("Enter id: ");
			int idR = scan.nextInt();
			students.remove(idR);
			break;
			
		case (6):
			System.out.println("Enter id: ");
			int id1 = scan.nextInt();
			System.out.println("Enter mark: ");
			int mark = scan.nextInt();
			students.setMark(id1, mark);
			break;
			
		case (7):
			menu = false;
			System.out.println("Goodbye!");
			break;
			
		case (8):
			System.out.println("Enter group title: ");
			String nameGroup = scan.next();
			groups.add(new Group(nameGroup));
			break;
			
		case (9):
			System.out.println("Enter groupID Students by Id: ");
			int idGroup = scan.nextInt();
			System.out.println(students.getStudentByGroup(idGroup));
			break;
			
		case (10):
			System.out.println("Groups:\n");
			for (Group p: groups.getGroups()){
				System.out.println("ID of a Group: "+ p.getId() +" " + "Name of a Group: " + p.getNameGroup());
			}
			break;
		case (11):
			System.out.println("Enter id of a Student: ");
			int idStudent = scan.nextInt();
			System.out.print("Enter id of a Group: ");
			int idGroup1 = scan.nextInt();
			students.setGroup(idGroup1, idStudent);
			break;
		}
		}
}
}

	
