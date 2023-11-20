import org.testng.annotations.Test;

public class DependsOnTest {
    @Test(dependsOnGroups = "group.dependency")
    public void testDependsonGroup() {
        System.out.println("This method depends on group.dependency");
    }

    @Test(groups = "group.dependency")
    public void testDGroupDependency() {
        System.out.println("This method is part of  group.dependency");
    }

    @Test(groups = "group.dependency")
    public void testDGroupDependency2() {
        System.out.println("This method is part of  group.dependency again");
    }

    @Test(dependsOnMethods = "testGroupDependency")
    public void testGroupDependency() {
        System.out.println("This method will execute if anather method succeed ");
    }
}
