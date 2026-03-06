public class Employee {
    protected String name;
    protected String employeeID;
    protected double salary;

    public Employee(String name, String employeeID, double salary){
        this.name=name;
        this.employeeID=employeeID;
        this.salary=salary;
    }

    public void displayInfo(){
        System.out.println(name+" has "+employeeID+" and "+salary+" years old.");
    }
}

class Manager extends Employee{
    public Manager(String name, String employeeID, double salary){
        super(name, employeeID, salary);
    }
    public void assignTask(){
        System.out.println("Manager "+name+" is assigning new task");
    }
    public void approveLeave(){
        System.out.println("Manager "+name+" approved the leave");
    }
}

class Developer extends Employee{
    public Developer(String name, String employeeID, double salary){
        super(name, employeeID, salary);
    }
    public void writeCode(){
        System.out.println("Developer "+name+" is writing a code");
    }
    public void fixBug() {
        System.out.println("Developer " + name + " is fixing the bug");
    }
}

class Intern extends Employee{
    public Intern(String name, String employeeID, double salary){
        super(name, employeeID, salary);
    }
    public void attendTraining(){
        System.out.println("Intern "+name+" attended training");
    }
    public void submitReport(){
        System.out.println("Intern "+name+" submit report");
    }
}
