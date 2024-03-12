// class -> the blueprint for building / using the object
// object -> using the blueprint many instances of the class can be made
// instance -> one of the many objects that have been created from the blueprint of the class
// reference -> the address where the instance lives  (the reference can be saved to two different locations)
//      this is the variable that the object / instance was assigned to

// static variables -> declared with the word "static", every instance of the class shares the same static variable
//          if changes are made to that variable, all other instances of that class will see the effect of that change.
//          it is considered best practice to use the class name and not a reference variable to access a static variable
//          aren't used very often but are good for:
//              storing counters
//              generating unique ids
//              storing a constant value that doesn't change, like PI
//              creating,  and controlling access, to a shared resource (shared file, database, etc)

// instance variables -> don't use the keyword "static"
//          each instance has its own copy of an instance variable
//          every instance can have a different value
//          instance variables represent the state, of a specific instance of a class

// static methods -> declared using a static modifier
//          methods can't access instance methods and instance variables directly
//          usually used for operations that don't require any data from an instance of the class (can't be used with 'this')

// instance methods -> belong to an instance of a class
//          need to instantiate an instance of the class first
//          can also access static methods and static variables directly
//              you don't have to use "Class.staticVariable" but can help with clarity


package java_17.oop_intro;

public class AspectsOfClasses {
    
}
