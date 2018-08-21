package sel ;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VTU_NEW_2018 
{
    
    static int getPoint(String c)
    {
       
        switch(c)
        {
            case "S+" : return 10 ;
            case "S" : return 9 ;
            case "A" : return 8;
            case "B" : return 7;
            case "C" : return 6;
            case "D" : return 5;
            case "E" : return 4;
        }
        
        return 0 ;
    }
    
    
    
    static String getGrade(int n)
    {
        if(n >= 90) return "S+" ;
        else if( n >= 80) return "S" ;
        else if( n >= 70) return "A" ;
        else if(n >= 60) return "B" ;
        else if( n >= 50) return "C" ;
        else if( n >=45) return "D" ;
        else if( n >= 40 ) return "E" ;
        else return "F" ;
        
    }
	
    public static void main(String[] args) 
    {
            
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(new File("ECE123.csv"));
            out.write("\n\n\n");
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
		
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://results.vtu.ac.in/vitaviresultcbcs2018/resultpage.php");
            
        for(int count = 1 ; count < 140 ; count++)
        {
            try
            {
                driver.navigate().to("http://results.vtu.ac.in/vitaviresultcbcs2018/resultpage.php");
                String usn = "1BG15CS"+String.format("%03d", count) ;
                driver.findElement(By.xpath("//*[@id=\"raj\"]/div[1]/div/input")).sendKeys(usn);
                driver.findElement(By.id("submit")).click();
                    
                    
                try
                {
                    Alert alert = driver.switchTo().alert() ;
                    alert.accept();
                    continue ;
                    
                }
                catch(Exception e)
                {
                        
                }
                String name = driver.findElements(By.xpath("//*[@id=\"dataPrint\"]/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr[2]/td[2]")).get(0).getText().substring(1).trim();
                    
                    
                int i = 0 ;
                List<WebElement> l1 = driver.findElements(By.className("divTableCell")).subList(6, 54) ;
                // 6 - 53
                     
                out.write(usn.toUpperCase()+","+name+",");
                System.out.print(name+","+usn+",");
                double sgpa = 0.0f ; int total = 0 ;
                for(i=0 ; i < 8 ; i++) 
                {

                    String subcode , subname  , res ;
                    int im , em , t ;
                    subcode = l1.get(i*6 + 0).getText() ;
                    subname = l1.get(i*6 + 1).getText() ;
                    im = Integer.parseInt(l1.get(i*6 + 2).getText());
                    em = Integer.parseInt(l1.get(i*6 + 3).getText());
                    t = Integer.parseInt(l1.get(i*6 + 4).getText());
                    res = l1.get(i*6 + 5).getText() ;
                    
                    int subcredits = 0 ;
                    String grade ="" ;
                        
                        
                    if(subcode.equals("15PHY561"))
                        subcredits = 3 ;
                    else if(Pattern.matches("15[A-Z]{2}[L][1-9]{2}", subcode) )
                        subcredits = 2 ;
                    else if(Pattern.matches("15[A-Z]{2}[6][1-4]", subcode) )
                        subcredits = 4 ;
                    else if(Pattern.matches("15[A-Z]{2}[6][5|6][1-9]", subcode))
                        subcredits = 3 ;
                         
                    if(res.trim().equals("P"))
                    {
                        grade=getGrade(t);
                        total += subcredits * getPoint(grade) ;
                    }
                    else
                    {
                        grade="F" ;
                        subcredits = 0 ;
                        total += subcredits * getPoint(grade) ;
                    }
                        
                    if(subname.equals("CRYPTOGRAPHY, NETWORK SECURITY AND CYBER LAW"))
                        subname =  "CRYPTOGRAPHY NETWORK SECURITY AND CYBER LAW"  ;
                                    
                    String to_csv = subcode+","+subname+","+im+","+em+","+t+","+res+","+grade+"," ;
                    System.out.print(to_csv);
                    out.write(to_csv);

                }
                String formattedres = String.format("%.2f", total/26.0f);
                System.out.println(formattedres);
                out.write(formattedres+"\n");
                    
            }
            catch(Exception e)
            {
                continue ;
            }
        }    
        
        //driver.findElement(By.xpath("//*[@id=\"currentId\"]")).click();
        out.close();
    }
}
