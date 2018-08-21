/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sel;



import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class spam_sayat 
{
    public static void main(String[] args) throws Exception
    {
        
        int i =0;
        String s[] = new String[1000] ;
        
        File f = new File("response.txt");
        int lines = 0 ;
        try
        {
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine())
            {
                s[lines++] = sc.nextLine();
            }


            for(int j = 0 ; j < lines ; j++)
                System.out.println(s[j]);
        }
        catch(Exception e)
        {
            System.out.println("fail");
        }
        
        int k = 0 ;
        Random r = new Random();
            
         System.setProperty("webdriver.chrome.driver","chromedriver.exe");
           WebDriver driver = new ChromeDriver();      
        while(true)
        {
         
            i++;
                
            driver.navigate().to("https://sayat.me/<User Name>");
                
            k =(k+1)%(lines);/// //*[@id="give-feedback-textarea"]
            
            driver.findElement(By.id("give-feedback-textarea")).sendKeys(s[k]);
            TimeUnit.SECONDS.sleep(3);                
            
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
               
            driver.findElement(By.xpath("//*[@id=\"give-feedback-button\"]")).click();
            TimeUnit.SECONDS.sleep(3);
            
            // //*[@id="give-feedback-button"]
            
            System.out.println("Spam Count XD -  "+" "+i);
            
            //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
                 
            //ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
              
                  
                
            //driver.close();
                 
              
         }
    }
}
    
        
