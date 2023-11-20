import org.testng.annotations.Test;

public class PriorityTest {
    @Test(priority = 0)
    public void testPriority3(){
        System.out.println("Prioritet 3");
    }
    @Test(priority = -1)
    public void testPriority1(){
        System.out.println("Prioritet 1");
    }
    @Test(priority = 2)
    public void testPriority2(){
        System.out.println("Prioritet 2");
    }

}
