import org.testng.annotations.*;

public class GroupTest {

    @Test(groups = "smoke")
    public void testSmokeGroup2() {
        System.out.println("Test method 2");
    }

    @Test(groups = "smoke")
    public void testSmokeGroup4() {
        System.out.println("Test method 4");
    }
    @Test(groups = "regression")
    public void TestSmokeGroup5() {
        System.out.println("Test method 5");
    }
        @Test(groups = "regression")
        public void TestSmokeGroup6() {
            System.out.println("Test method 6");
        }
    }
