package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {
	
	@FindBy (id="personal_cmbNation")
	public WebElement nationalityDD;
	
	@FindBy (name= "personal[optGender]")
	public List<WebElement> genderRadioGroup;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement textProfilePic;
	
	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement editBtn;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement DLNum;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy(id="personal_txtEmpNickName")
	public WebElement NickName;
	
	@FindBy(id="personal_txtMilitarySer")
	public WebElement MilitaryService;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement SINNum;
	
	@FindBy(id="personal_cmbMarital")
	public WebElement MaritalStatus;
	
	@FindBy(id="personal_chkSmokeFlag")
	public WebElement smoker;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement LicenseExpiryDate;
	
	@FindBy(id="personal_DOB")
	public WebElement DOB;
	
	
	
	
	
	
	
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
