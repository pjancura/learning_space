package java_17.oop_inheritance;

public class Student {
    
    private String id;
    private String name;
    private String dateOfBirth;
    private String classList;

    public Student(String id, String name, String dateOfBirth, String classList) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classList = classList;
    }

    public String getClassList() {
        return classList;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setClassList(String classList) {
        this.classList = classList;
    }


    // annotations are a type of metadata
    // metadata is a way of formally describing additional information about our code
    // annotations are more structured, and have more meaning, than comments
    @Override   // this is the annotation
    public String toString() {
        
        return "Student {Id: '" + id + "', Name: '" + name + "', Date of Birth: '" + dateOfBirth + "', Class List: '" + classList + "'}";
    }


}
