import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LectionTestNG {

    @DataProvider (name = "ProviderData", parallel = true)
    public Object [][] justForProviderTest (){
        return new Object[][]{
        {null, null},
        {"test","test"},
        {null,"test"},
        };
    }

    @Test (dataProvider = "ProviderData")
    public void MyFirstTest(String str, String str1) {
        System.out.println(str+" "+str1);
    }
    @Test
    public void MySecondTest() {
        System.out.println("this is test class");
    }
    @Test
    public void MyThirdTest() {
        System.out.println("this is test class");
    }
}
