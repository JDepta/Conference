package pl.edu.agh.ki.mwo.model;

public class Student {
	private static int studentIdGenerator = 1;
	
	protected int id;
	protected String name;
	protected String surname;
	protected boolean sexFemale;
	
	public Student(String name, String surname, boolean sexFemale) {
		super();
		this.id = studentIdGenerator;
		studentIdGenerator++;
		
		this.name = name;
		this.surname = surname;
		this.sexFemale = sexFemale;
	}
	
	public int getId() {
		return id;
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
	
	public boolean isSexFemale() {
		return sexFemale;
	}
	public void setSexFemale(boolean sexFemale) {
		this.sexFemale = sexFemale;
	}
	
	
	
}

