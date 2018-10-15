public class Person {                   
 private String name;                   
 private int age;                       
                                        
 public Person() {                      
         this.name = "None";            
         this.age = 0;                  
 }                                      
                                        
 public Person( String name, int age ) {
         this.name = name;              
         this.age = age;                
 }                                      
                                        
 public String getName() {              
         return this.name;              
 }                                      
                                        
 public void setName(String name){      
         this.name = name;              
 }                                      
                                        
 public int getAge() {                  
         return this.age;               
 }                                      
                                        
 public void setAge( int age ) {        
         this.age = age;                
 }                                     

}

public class Student extends Person {
	private String id;
	private int credits;

	public  Student() {
		super();
		this.id = "$$";
		this.credits = 0;
	}

	public Student (String name, int age, String id, int credits) {
		super(name,age);
		this.id = id;
		this.credits = credits;
	}

	public String getId() {
		return this.id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
}
Person p = new Person();
Student st = new Student();

Person joe = new Person();
joe.getName();
joe.getAge()
Student student = new Student("Juan",10,"A1",100);
student.getId()
