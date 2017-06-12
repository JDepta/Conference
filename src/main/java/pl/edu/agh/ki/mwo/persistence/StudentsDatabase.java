package pl.edu.agh.ki.mwo.persistence;

import java.util.ArrayList;

import pl.edu.agh.ki.mwo.model.Student;

public class StudentsDatabase{
	
	protected static StudentsDatabase studentsDatabase = null;
	
	public static StudentsDatabase getInstance()
	{
		if (studentsDatabase == null)
		{
			studentsDatabase = new StudentsDatabase();
		}
		return studentsDatabase;
	}
	
	
	protected ArrayList<Student> students = null;
	
	protected StudentsDatabase()
	{
		students = new ArrayList<Student>();
	}

	public Iterable<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		students.add(student);		
	}
	
	public void removeStudent(int studentId) {
		for(Student student : students)
		{
			if (student.getId() == studentId)
			{
				students.remove(student);
				return;
			}
		}
	}
	
}
