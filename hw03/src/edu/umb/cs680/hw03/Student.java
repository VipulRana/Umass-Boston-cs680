package edu.umb.cs680.hw03;
public class Student {

	private float tuition;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String priorState;
	private String foreignAddr;
	private StudentStatus status;

	protected Student(String name, int i20num, String usAddr, int yrsInState, String priorState, String foreignAddr,
			StudentStatus status) {
		super();
		this.name = name; // name: String
		this.i20num = i20num; // i20num: int
		this.usAddr = usAddr; // usAddr: String
		this.yrsInState = yrsInState; // yrsInState: int
		this.priorState = priorState; // priorState: String
		this.foreignAddr = foreignAddr; // foreignAddr: String,
		this.status = status; // status: StudentStatus
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

	public String getName() {
		return name;
	}

	public int getI20num() {
		return i20num;
	}

	public String getUsAddr() {
		return usAddr;
	}

	public int getYrsInState() {
		return yrsInState;
	}

	public String getPriorState() {
		return priorState;
	}

	public String getForeignAddr() {
		return foreignAddr;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public float getTuition() {
		return tuition;
	}
	
	public static void main(String[] args) {
		System.out.println("Student Class Successfully Run!!");
	}

}