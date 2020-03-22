package edu.umb.cs680.hw03;

public class StudentFactory extends Student{

	protected StudentFactory(String name, int i20num, String usAddr, int yrsInState, String priorState,
			String foreignAddr, StudentStatus status) {
		super(name, i20num, usAddr, yrsInState, priorState, foreignAddr, status);
		// TODO Auto-generated constructor stub
	}

	public static Student createInStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, 123, usAddr, yrsInState, "State", "Address", StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, String priorState) {
		return new Student(name, 123, usAddr, 2, priorState, "Address", StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
		return new Student(name, 123, usAddr, i20num, "State", foreignAddr, StudentStatus.INTL);
	}
}
