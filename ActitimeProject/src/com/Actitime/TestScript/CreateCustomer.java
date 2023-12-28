package com.Actitime.TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.ObjectRepository.Homepage;
import com.Actitime.ObjectRepository.TaskPage;
//@Listeners(ListenerImplementation.class) // if you want screenshot for failed test script then it is mandatory to linked ListenerImplementation class for TakeScreenshot
public class CreateCustomer extends BaseClass {
    @Test
    public void createCustomer() throws IOException {
    	Homepage hp=new Homepage(driver);
    	hp.getTasklnk().click();
    	
    	TaskPage tp=new TaskPage(driver);
    	tp.getAddnewbtn().click();
    	tp.getNewCust().click();
    	FileLibrary f=new FileLibrary();
    	String customername = f.excelFile("Sheet1", 4, 1);
    	tp.getCustName().sendKeys(customername);
    	String customerdesp = f.excelFile("Sheet1", 4, 2);
    	//Assert.fail();
    	tp.getCustDesp().sendKeys(customerdesp);
    	tp.getCreatebtn().click();
    }
}
 