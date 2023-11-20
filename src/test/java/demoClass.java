import org.testng.annotations.*;

import java.awt.*;

public class demoClass{

@BeforeSuite(alwaysRun = true)
public void testBeforeSuite(){
    System.out.println("Executed before Suite");
}
@AfterSuite
public void afterSuit(){
    System.out.println("Executed after Suite");
}
@BeforeTest
public void testBeforTest(){
    System.out.println("Executed before Test");
}
@AfterTest
public void testAftereSuite(){
    System.out.println("Executed after Suite");
}
@BeforeGroups
public void testBeforeGroups(){
    System.out.println("Executed before Groups");
}
@AfterGroups
public void tesAfterGroups(){
    System.out.println("Executed after Groups");
}
@BeforeClass
public void testBeforeClass(){
    System.out.println("Executed before Class");
}
@AfterClass
public void testAfterClass(){
    System.out.println("Executed after Class");
}
@BeforeMethod
public void testBeforeMethod(){
    System.out.println("Executed before Method");
}
@AfterMethod
public void testAfterMethod() {
    System.out.println("Executed after Method");

}
        @Test( groups = "smoke")
        public void testSmokeGroup () {
        System.out.println("Test method 1");
    }
        @Test
        public void TestSmokeGroup () {
        System.out.println("Test method 3");
    }
}
