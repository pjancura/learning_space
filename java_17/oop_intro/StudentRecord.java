// this is all the more code that is needed when setting up a record object
// the part in parentheses is called the "record header"
// record header -> consists of record components, a comma delimited list of components
//      for each component Java a field with the smae name and declared type as the record component
//      the field is declared private and final
//      the field is sometimes referred to as a component field
//      generates a toSTring method that prints out each attribute in a formatted String
//      Java generates a public accessor method for each component
//          these have no special prefix such as "get" or "is"
//      the accessor method, for a component is simply component()
//      there are no setter methods in records b/c of the goal to be immmutable


package java_17.oop_intro;

public record StudentRecord(String id, String name, String dateOfBirth, String classList) {


    
}
