package sel ;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
public class spam_whatsapp
{
	
    public static void main(String[] args)
    {
		
		
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Nandan\\Documents\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String str[] = {"Heyy Sexy","Heyy Kaushal","You are awesome!","LOL","LMAO","ROFL","Haha","My doctor says i’m lacking Vitamin U","I'm going to have to ask you to leave. You’re making the other girls look bad.","8 Planets, 1 Universe, 1.735 billion people, and i end up with you","Are your eyes ike? Because i’m lost in them!","Call me shrek because i’m head ogre heels for you!","Do you have an inhaler? Because you took my breath away!","Do you have 11 protons? Because you’re sodium fine!","You know what’s on the menu? ME-N-U","If you were a flower you’d be a damnnndelion","My doctor says i’m lacking Vitamin U","Are you an omelette? Because you’re making me eggcited.","Are you a tower? Because eiffel for you!","Are you a bank loan? Because you got my interest","Are you the square root of -1 because you can’t be real","I know you’re busy today but can you add me to your to-do list?","Are you from mexico because i think you’re the juan for me!","Are you related to yoda because yodalicious!"};
        driver.navigate().to("http://web.whatsapp.com");
        System.out.println("enter any key to continue ");
        int n = new Scanner(System.in).nextInt();
        int count = 60 ;
        while(true)
        {
                
            System.out.println(count++);
            
            WebElement message = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div[2]/div/div[2]"));
            message.sendKeys(str[new Random().nextInt(str.length)]);
                
            driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/button")).click();
              
                
        }
}
}