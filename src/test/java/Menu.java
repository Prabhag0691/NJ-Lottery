import org.openqa.selenium.By;

public class Menu {

	StartAppTest HCLClient=new StartAppTest();
	
	public void Menuverification() throws InterruptedException {
		Thread.sleep(2000);
		HCLClient.driver.findElement(By.id("slideNavButton")).click();
		HCLClient.driver.findElement(By.id("winningNumberSlide")).click();
		
		
	}
	
	
	
}
