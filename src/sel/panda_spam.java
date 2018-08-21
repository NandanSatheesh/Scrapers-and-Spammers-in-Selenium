
//https://pollsgo.com/poll?p=unrkSik
package sel ;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class panda_spam 
{
	
    public static void main(String[] args) 
    {
            
            
        int count = 0 ;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        
	while(true)
        {
		
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            count++;
            driver.navigate().to("https://pollsgo.com/poll?p=unrkSik");
                
            for( int i = 0 ; i < 9 ; i++)
            { 
                   
                   
                try
                {
                    int r = new Random().nextInt() % 3 +1 ;
                    TimeUnit.SECONDS.sleep(3);
                    driver.findElement(By.xpath("//*[@id=\"option_3\"]")).click();
                }
                catch(Exception e)
                {
                        System.out.println("fail");
                }
                
            }
                
            try
            {
                TimeUnit.SECONDS.sleep(3);
                driver.close();
                System.out.println(count);
            }
            catch(Exception e)
            {
                System.out.println("fail");
            }
                
        }
    }

}