import org.testng.annotations.Test;

import java.io.IOException;

public class ExcertionsTestNG {

    @Test(expectedExceptions = {IOException.class, RuntimeException.class})
    public void testException1(){
        System.out.println("Except 1");
        throw new RuntimeException("Pass");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void testException2(){
        System.out.println("Except 2");
        throw  new RuntimeException("Pass");
    }
    @Test(expectedExceptions = IOException.class)
    public void testException3(){
        System.out.println("Except 3");
       // throw new IOException("Pass");
    }
}
