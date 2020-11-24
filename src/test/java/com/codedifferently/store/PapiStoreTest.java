package com.codedifferently.store; //Code Differently package-organizes a set of related classes and interfaces


import org.junit.Assert; //Imports the Assert Class from the org.junit package or folder-provides a set of
// assertion methods useful for writing tests. Only failed assertions are recorded.
import org.junit.Before; //Imported from the org.junit package or folder-allows for the @Before
// annotation to be used in the program.
import org.junit.Test; //Imported from the org.junit package or folder-allows for the @Test
// annotation to be used in the program.


    public class PapiStoreTest { //This is a public (accessed) class named PapiStoreTest

        PapiStore papiStore; //papiStore is the variable of the Object type PapiStore

        @Before //Annotation (metadata (info about the data)), that is used on a method to run before each test case.
        //Useful when we want to execute some common code before running a test.
        public void setup(){ //A public accessed method called setup that is invoked before each test method.
            //Used for creating and configuring the system under test. JUnit 4 requires that the method
            //annotated with the @Before annotation is public, doesn't have any method parameters, and doesn't return anything (void).
            //We should create the dependencies of the tested object in this method.
            // In other words, if we want to use test doubles in our unit tests, we should create these test doubles in this method.
            //We should create the tested object in this method.
            papiStore = new PapiStore(); //This is using a constructor to initialize a new object of PapiStore.
            //papiStore is the variable that references the Class (Object) PapiStore. The new operator instantiates a class by allocating
            //memory for a new object. Instantiating a class means the same thing as creating an object.
            papiStore.createActiveTab("Jamal"); //Creating a new active tab for Jamal in the newly constructed object of PapiStore.
            papiStore.createActiveTab("Victor"); //Creating a new active tab for Victor in the newly constructed object of PapiStore
            papiStore.owesPapiMoney.put("Jamal", 0.0); //HashMap.put method inserting the specific key "Jamal" and the value 0.0 into the
            //map owesPapiMoney in the instance of the class PapiStore. Value is 0.0 indicating Jamal does not owe money.
            papiStore.owesPapiMoney.put("Victor", 7.0); //HashMap.put method inserting the specific key "Victor" and the value 7.0 into the
            //map owesPapiMoney in the instance of the class PapiStore. Value is 7.0 indicating Victor owes money.
        }

        @Test //An annotation provided by JUnit called @Test that tells the JUnit that the public void method in which it is
        // used can run as a test case
        public void OpenStoreTest(){ //A test method called OpenStoreTest created to call on the PapiStore Class.
            //Given

            papiStore.openStore(); //Method openStore called to open store of object papiStore

            //When
            Boolean expected = true; //autoboxing; converts a primitive value into an object of the corresponding wrapper class.
            //Converts boolean to Boolean class. expected is referencing Boolean class and is set to true.
            Boolean actual = papiStore.isStoreOpen(); //Stating whether the store is actually open or closed. The actual
            // references the Boolean class (true or false).

            //Then
            //Assert.assertEquals(expected, actual);
            Assert.assertTrue(actual); // boolean condition asserting (stating) that the condition is true.
            // If the condition is true, that the store is actually open, then the test will pass.
        }

        @Test //An annotation provided by JUnit called @Test that tells the JUnit that the public void method in which it is
        // used can run as a test case
        public void allowToUseTabTestSuccess(){ //A public accessed method, returning nothing, to test if the
            // allowToUseTab method is a success or not.
            // given
            PapiStore papiStore = new PapiStore(); //Declares the variable papiStore that makes reference to the PapiStore class,
            // creating (Instantiating) the object PapiStore. The new operator is followed by a call to the
            // constructor, which initializes the new object of PapiStore.

            // when
            Boolean expected = true; //autoboxing; converts a primitive value into an object of the corresponding wrapper class.
            //Converts boolean to Boolean class. expected is referencing Boolean class and is set to true.
            Boolean actual = papiStore.allowToUseTab("Jamal");

            // then
            Assert.assertEquals(expected, actual); //Asserts that two objects are equal. assertEquals method checks if two objects
            //are equal or not.
        }

        @Test //An annotation provided by JUnit called @Test that tells the JUnit that the public void method in which it is
        // used can run as a test case
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore(); //Declares the variable papiStore that makes reference to the PapiStore class,
            // creating (Instantiating) the object PapiStore. The new operator is followed by a call to the
            // constructor, which initializes the new object of PapiStore.

            // when
            Boolean expected = false; //autoboxing; converts a primitive value into an object of the corresponding wrapper class.
            //Converts boolean to Boolean class. expected is referencing Boolean class and is set to false.
            Boolean actual = papiStore.allowToUseTab("Victor"); //

            // then
            Assert.assertEquals(expected, actual); //Asserts that two objects are equal. assertEquals method checks if two objects
            //are equal or not.
        }
}
