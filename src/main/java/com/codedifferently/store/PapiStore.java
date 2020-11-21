package com.codedifferently.store; //Code Differently package-organizes a set of related classes and interfaces.

import java.util.ArrayList; //Array list class imported from the java.util package-Dynamic data structure;
//items can be added and removed from the list. A normal array is static (limited to initial size of array)
import java.util.HashMap; //HashMap class imported from the java.util package-provides the basic implementation
//of the Map interface of Java. It stores the data in (Key, Value) pairs.
import java.util.Map; //Map class imported from the java.util package-An object that maps keys to values.
//A map cannot contain duplicate keys; each key can only map to one value.

public class PapiStore { //Declares name of class (PapiStore), set to public which is an access modifier.
    //public is a Java keyword that declares a member's access as public (visible to all other classes).
    //Any other class can access and modify unless a field is declared as final. The curly brace opens the body of the class.
    private boolean isStoreOpen; //A boolean variable, set to private, indicating whether the store is open or not open.
    private ArrayList<String> tabs; //An ArrayList, set to private, that stores new String variables (A container that holds values).
    Map<String, Double> owesPapiMoney; //

    public PapiStore(){ //Name of constructor class (PapiStore), set to public, initializing the state of the class
        this.isStoreOpen = false; //Keyword this calling on the isStoreOpen, declaring the beginning state of the store as closed.
        this.tabs = new ArrayList(); //Points to and initializes a new ArrayList for use throughout
        this.owesPapiMoney = new HashMap<>();
    }

    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){ //Another constructor of PapiStore class that accepts parameters
        this.isStoreOpen = isOpen; //Keyword this calling on the isStoreOpen, declaring the beginning state of the store as open.
        this.tabs = tabsIn; //
        this.owesPapiMoney = new HashMap<>();
    }

    public void closeStore(){ //Method (closeStore), set to public, called to "close" the store

    }

    public void openStore(){ //Method (openStore), set to public, called to "open" the store
        this.isStoreOpen = true; //Stating the store is "open".
    }

    public boolean isStoreOpen() { //Boolean method, (isStoreOpen), set to public, called to determine current state of store as being open or closed
        return isStoreOpen; //Returns the current state of the store
    }


    public Boolean allowToUseTab(String name){ //Method (allowToUseTab), set to public, called to determine if the name of the person passed in is
        //allowed to have a tab or not.
        Boolean response = false; //Response stating the person is not allowed to have a tab.
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name)) //If person has an active tab and does not have an overdue balance
            response = true; //States the person is allowed to have a tab. The response equals to true.
        return response; //Returns whether or not the person is allowed to have a tab.
    }

    private boolean hasAnOverDueBalance(String name){ //Method (hasOverdueBalance), set to private, called to determine if the name of the person passed in
        //has an overdue balance or not.
        if(!owesPapiMoney.containsKey(name)) //Checks to see if the person does not owe money
            return false; //States the person does not have an overdue balance
        Double money = owesPapiMoney.get(name); //Double is a data type, "money" is the name of the local (only
        //existing in this method (variable) that assigns a name to the person who owes money under this tab.
        Boolean owes = false; //Boolean stating whether it is true or false that money is or is not owed. Defaults to false (no).
        if(money > 0.0) //If dollar value is greater than zero
            owes = true;//States it is true that this person owes money
        return owes;//Returns whether or not money is owed to this person
    }

    private boolean hasAnActiveTab(String name){ //Method (hasAnActiveTab), set to private, called to determine if the name being passed in has an active tab.
        for (String tab : tabs){ //Loop to check through the list of names of all people that have tabs
            if (tab.equals(name)) //If one of the names is equal to one of the names being passed into the method
                return true; //Return true that the person (name given) has an active tab.
        }
        return false; //If iterates through the loop without a matching name, the program returns false. The name given
        //does not have an active tab.
    }

    public void createActiveTab(String name){ //Method (createActiveTab), set to public, called when someone wants to start a tab
        this.tabs.add(name); //Adds a name to the array list of tabs
    }


    public static void main(String[] args) { //public is the access modifier, static is a keyword meaning a variable or method marked
        //as static is available to be accessed at the class level without requiring an enclosing instance. Main is the name of the main method;
        //the identifier the JVM looks for as the starting point of the program. String[] args stores the command line arguments and is an array
        //of type java.lang.String class. The arg is the name of the String array but it is not fixed and can be changed by the user.
        System.out.println("Welcome to Papi Store, Hola");//Statement that prints out the argument passed to it.
    }


}
