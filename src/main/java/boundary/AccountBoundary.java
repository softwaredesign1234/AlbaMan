package boundary;
import controller.AccountController;
import model.EnterpriseAccount;
import model.IndividualAccount;

import java.util.*;


public class AccountBoundary {
    Scanner scanner=new Scanner(System.in);
    ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();
    ArrayList<EnterpriseAccount> enterpriseAccounts=new ArrayList<>();

    //나중에 NullPointerException으로 수정하기
    public void Signin()
    {

    }

    public void Signup()
    {

    }

    public String permission() //give permission,show failMessage
    {
        return null;
    }
    
    public void modifyIndividualInfo() {
    	
        // protected String name; -> #1
    	
    	// private String email;       -> #2
        // private String phoneNumber; -> #3
        // private int age;            -> #4
        // private String gender;      -> #5
    	
    	IndividualAccount individualAccount;
    	
    	int infoType;
    	String modifiedInfo;
    	
    	AccountController.getIndividualAccounts();
    	Boolean result = AccountController.verifyPassword(individualAccount.type,
    													  individualAccount.id,
    													  individualAccount.password);
    	
    	if (result) {
    		System.out.println(permission());
    		AccountController.modifyIndividualAccountInfo(individualAccount.id,
    													  infoType, modifiedInfo);
    	}
    	else
    		System.out.println("fail to modify account information");
    }

    public void withdrawAccount() {
    	
    	IndividualAccount individualAccount;
    	
    	int infoType;
    	String modifiedInfo;
    	
    	AccountController.getIndividualAccounts();
    	Boolean result = AccountController.verifyPassword(individualAccount.type,
    													  individualAccount.id,
    													  individualAccount.password);
    	
    	
    	if (result) {
    		System.out.println(AccountController.showWithdrawalTerms());
    		AccountController.deleteAccount("individual", individualAccount.id);
    		showResultMessage();
    	}
    	
    }



}
