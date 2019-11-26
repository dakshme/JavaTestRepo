package com.bmc.practice.cloneable;

public class CloneableExample {

	public static void main(String[] args) throws CloneNotSupportedException {

		Department dpt = new Department(5, "Computers");
		Employee original = new Employee(100, "Mahesh", dpt);

		//create clone
		
		Employee cloned = (Employee) original.clone();
		
		System.out.println(cloned.getEmpId());
		System.out.println("Original "+original.dpt.getDept());
		System.out.println("Cloned "+cloned.dpt.getDept());
		
		cloned.dpt.setDept("Electronics");

		System.out.println("Original "+original.dpt.getDept());
		System.out.println("Cloned "+cloned.dpt.getDept());
		
		 //Verify JDK's rules
		 
        //Must be true and objects must have different memory addresses
        System.out.println(original != cloned);
 
        //As we are returning same class; so it should be true
        System.out.println(original.getClass() == cloned.getClass());
 
        //Default equals method checks for references so it should be false. If we want to make it true,
        //then we need to override equals method in Employee class.
        System.out.println(original.equals(cloned));
	}
}

class Employee implements Cloneable {
	
	int empid;
	String name;
	Department dpt;
	
	public Employee (int empid, String name, Department dpt) {
		this.empid = empid;
		this.name = name;
		this.dpt = dpt;
	}
	
	public int getEmpId () {
		return this.empid;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Department {
	
    private int id;
    private String name;
 
    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }	
    
    public void setDept(String dpt ) {
    	this.name = dpt;
    }
    
    public String getDept( ) {
    	return this.name;
    }
}
