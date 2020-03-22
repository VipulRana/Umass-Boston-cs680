/*package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	Student inStateStudent = Student.createInStateStudent("ABC", "XYZ", 20);;
	Student outStateStudent = Student.createOutStateStudent("ABC", "XYZ", "PQR");
	Student intlStudent = Student.createIntlStudent("ABC", "XYZ", 12334567, "PQR");
	
	@Test
	void testGetTuition() {
		assertEquals(10000, inStateStudent.getTuition());
		assertEquals(15000, outStateStudent.getTuition());
		assertEquals(20000, intlStudent.getTuition());
	}

	@Test
	void testGetName() {
		assertEquals("ABC", inStateStudent.getName());
		assertEquals("ABC", outStateStudent.getName());
		assertEquals("ABC", intlStudent.getName());
	}

	@Test
	void testGetI20num() {
		assertEquals(0, inStateStudent.getI20num());
		assertEquals(0, outStateStudent.getI20num());
		assertEquals(12334567, intlStudent.getI20num());
		
	}

	@Test
	void testGetUsAddr() {
		assertEquals("XYZ", inStateStudent.getUsAddr());
		assertEquals("XYZ", outStateStudent.getUsAddr());
		assertEquals("XYZ", intlStudent.getUsAddr());
	}

	@Test
	void testGetYrsInState() {
		assertEquals(20, inStateStudent.getYrsInState());
		assertEquals(0, outStateStudent.getYrsInState());
		assertEquals(0, intlStudent.getYrsInState());
	}

	

	@Test
	void testGetForeignAddr() {
		assertNull(inStateStudent.getForeignAddr());
		assertNull(outStateStudent.getForeignAddr());
		assertEquals("PQR", intlStudent.getForeignAddr());
	}

	@Test
	void testCreateInStateStudent() {
		Student student= Student.createInStateStudent("ABC", "XYZ", 20);
		float actual = student.getTuition(); 
		float expected = 10000;
		assertEquals(expected, actual);
	}

	@Test
	void testCreateOutStateStudent() {
		Student student = Student.createOutStateStudent("ABC", "XYZ", "PQR");
		float actual = student.getTuition(); 
		float expected = 15000;
		assertEquals(expected, actual);
	}

	@Test
	void testCreateIntlStudent() {
		Student student = Student.createIntlStudent("ABC", "XYZ", 12334567, "PQR");
		float actual = student.getTuition(); 
		float expected = 20000;
		assertEquals(expected, actual);
	}

}*/



package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw03.Student;
import edu.umb.cs680.hw03.StudentFactory;
import edu.umb.cs680.hw03.StudentStatus;

public class StudentTest {
	
	@Test
	public void InstateStudentInstance() {
		Student str = Student.createInStateStudent("Test1", "Address", 5);
		assertNotNull(str);
	}
	
	@Test
	public void InstateStudentFactoryInstance() {
		Student str = StudentFactory.createInStateStudent("Test1", "Address", 5);
		assertNotNull(str);
	}
	
	@Test
	public void InstateStudentValidData() {
		Student str = Student.createInStateStudent("Test1", "Address", 5);
		assertEquals("Test1", str.getName());
		assertEquals("Address", str.getUsAddr());
		assertEquals(5, str.getYrsInState());
	}
	
	@Test
	public void InstateStudentFactoryValidData() {
		Student str = StudentFactory.createInStateStudent("Test1", "Address", 5);
		assertEquals("Test1", str.getName());
		assertEquals("Address", str.getUsAddr());
		assertEquals(5, str.getYrsInState());
	}
	
	@Test
	public void OutStateStudentInstance() {
		Student str = Student.createOutStateStudent("Test2", "Address1", "State1");
		assertNotNull(str);
	}
	
	@Test
	public void OutStateStudentFactoryInstance() {
		Student str = StudentFactory.createOutStateStudent("Test2", "Address1", "State1");
		assertNotNull(str);
	}
	
	@Test
	public void OutStateStudentValidData() {
		Student str = Student.createOutStateStudent("Test2", "Address1", "State1");
		assertEquals("Test2", str.getName());
		assertEquals("Address1", str.getUsAddr());
		assertEquals("State1", str.getPriorState());
	}
	
	@Test
	public void OutStateStudentFactoryValidData() {
		Student str = Student.createOutStateStudent("Test2", "Address1", "State1");
		assertEquals("Test2", str.getName());
		assertEquals("Address1", str.getUsAddr());
		assertEquals("State1", str.getPriorState());
	}
	
	@Test
	public void IntlStateStudentInstance()  {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertNotNull(str);
	}
	
	
	@Test
	public void IntlStateStudentFactoryInstance()  {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertNotNull(str);
	}
	
	
	@Test
	public void IntlStateStudentValidData() {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertEquals("Test3", str.getName());
		assertEquals("Address2", str.getUsAddr());
		assertEquals("Address3", str.getForeignAddr());
		assertEquals(123, str.getI20num());
	}
	
	@Test
	public void IntlStateStudentFactoryValidData() {
		Student str = Student.createIntlStudent("Test3", "Address2", 123, "Address3");
		assertEquals("Test3", str.getName());
		assertEquals("Address2", str.getUsAddr());
		assertEquals("Address3", str.getForeignAddr());
		assertEquals(123, str.getI20num());
	}
	
}
