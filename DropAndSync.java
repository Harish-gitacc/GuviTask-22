package task22;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.io.FileHandler;

public class DropAndSync {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500)); 
		driver.get("https://phptravels.com/demo/");
		//driver.manage().window().maximize();
		FluentWait <WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(30))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Last Name']"))).sendKeys("hari");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(" input[placeholder='First Name']"))).sendKeys("V");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Business Name']"))).sendKeys("Enterprise");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='Email']"))).sendKeys("dabon53489@hidelux.com");
		
		WebElement ele1 = driver.findElement(By.id("numb1"));
		WebElement ele2 = driver.findElement(By.id("numb2"));

		String a=ele1.getText();
		String b=ele2.getText();
		System.out.println("First number :"+a);
		System.out.println("Second number :"+b);
		
		int i=Integer.parseInt(a);
		System.out.print(i);
		System.out.print("+");
		
		int j=Integer.parseInt(b);
		System.out.print(j);
		System.out.println();
		
		int x=i+j;
		System.out.println("Addition Result : "+x);
		
		String s=Integer.toString(x);
		WebElement Total=driver.findElement(By.id("number"));
		Total.sendKeys(s);
		driver.findElement(By.id("demo")).click();
		
		Thread.sleep(1000);
		WebElement sc=driver.findElement(By.id("swup"));
		
		File src=sc.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir");
        File dest=new File(path+"/Screenshot/.png");		
	    FileHandler.copy(src, dest);
	   
	}

}


OUTPUT:
First number :6
Second number :5
6+5
Addition Result : 11
