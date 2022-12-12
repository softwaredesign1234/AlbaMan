package controller;

import model.EnterpriseAccount;
import model.IndividualAccount;

import java.util.ArrayList;
import boundary.DBBoundary;


public class AccountController {

    public static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();
    public static ArrayList<EnterpriseAccount> enterpriseAccounts=new ArrayList<>();

    static DBBoundary dbManager;

    public static String showTermsOfService()
    {
        return null;
    }
    public static void signupIndividual(String id, String password, String name,
                                        String email, String phoneNumber, int age, String gender)
    {
        return;
    }

    //000-00-00000
    public static void signupEnterprise(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                                   String id, String password, String name)
    {
        return;
    }


    public static Boolean signIn(String type,String id,String password)
    {
        return null;
    }

    //개인 로그인
    public static IndividualAccount signinIndividual(String id,String password )
    {
        return null;

    }

    //기업 로그인
    public static EnterpriseAccount signinEnterprise(String id,String password )
    {
        return null;
    }

    public Boolean isSigninSuccess()
    {
        return null;
    }

    public static Boolean verifyPassword(String type, String id, String passowrd) {
    	
    	if (type.equals("IndividualAccount")) { // type 형식?
    		IndividualAccount iAccount = individualAccounts.stream()
    			.filter(i -> ((i.getId().equals(id)) && (i.getPassword().equals(password))));
    		
    		if (iAccount == null)	return false;
    		else 					return true;
    	}
    	else {
    		EnterpriseAccount eAccount = enterpriseAccounts.stream()
        			.filter(e -> ((e.getId().equals(id)) && (e.getPassword().equals(password))));
        		
        		if (eAccount == null)	return false;
        		else 					return true;
    	}
   
    }

    public static void modifyIndividualAccountInfo(String individualId, int infoType, String modifiedInfo) {
    	
        // protected String name; -> #1
    	
    	// private String email;       -> #2
        // private String phoneNumber; -> #3
        // private int age;            -> #4
        // private String gender;      -> #5

    	int index = -1;
    	IndividualAccount iAccount = null;
    	
    	for (int i = 0;i < individualAccounts.size();i++) {
    		if (individualAccounts.get(i).getId().equals(individualId)) {
    			index = i;
    			iAccount = individualAccounts.get(i);
    		}
    	}
    	
    	
    	if (index < 0) {
    		return;
    	}
    	else {
    		switch (infoType) {
    		case 1:
    			individualAccounts.get(index).setName(modifiedInfo);
    			iAccount.setName(modifiedInfo);
    			break;
    		case 2:
    			individualAccounts.get(index).setEmail(modifiedInfo);
    			iAccount.setEmail(modifiedInfo); // email 검사 또 해야 하나?
    			break;
    		case 3:
    			individualAccounts.get(index).setPhoneNumber(modifiedInfo);
    			iAccount.setPhoneNumber(modifiedInfo);
    			break;
    		case 4:
    			try { 
    				individualAccounts.get(index).setAge(Integer.parseInt(modifiedInfo));
    				iAccount.setAge(Integer.parseInt(modifiedInfo));
    			}
    			catch (NumberFormatException e) { System.out.println("modifying age -> Numberformat error"); }
    			break;
    		case 5:
    			individualAccounts.get(index).setGender(modifiedInfo);
    			iAccount.setGender(modifiedInfo);
    		}
    	}
    	
    	if (iAccount) { saveDB(iAccount); } // saveDB 형식?
    	return;
    }

    public static void modifyEnterpriseAccountInfo(String enterpriseId, int infoType, String modifiedInfo) {
    	
    	// protected String name; -> #1
    	
    	// private String enterpriseNum;           -> #2
        // private String category;                -> #3
        // private String enterprisePhoneNumber;   -> #4
        // private String enterpriseLocation;      -> #5
 
    	int index = -1;
    	EnterpriseAccount eAccount = null;
    	
    	for (int i = 0;i < enterpriseAccounts.size();i++) {
    		if (enterpriseAccounts.get(i).getId().equals(enterpriseId)) {
    			index = i;
    			eAccount = enterpriseAccounts.get(i);
    		}
    	}
    	
    	
    	if (index < 0) {
    		return;
    	}
    	else {
    		switch (infoType) {
    		case 1:
    			enterpriseAccounts.get(index).setName(modifiedInfo);
    			eAccount.setName(modifiedInfo);
    			break;
    		case 2:
    			enterpriseAccounts.get(index).setEnterpriseNum(modifiedInfo);
    			eAccount.setEnterpriseNum(modifiedInfo);
    			break;
    		case 3:
    			enterpriseAccounts.get(index).setCategory(modifiedInfo);
    			eAccount.setCategory(modifiedInfo);
    			break;
    		case 4:
    			enterpriseAccounts.get(index).setEnterprisePhoneNumber(modifiedInfo);
    			eAccount.setEnterprisePhoneNumber(modifiedInfo);
    			break;
    		case 5:
    			enterpriseAccounts.get(index).setEnterpriseLocation(modifiedInfo);
    			eAccount.setEnterpriseLocation(modifiedInfo);
    		}
    	}
    	
    	if (eAccount) { saveDB(eAccount); } // saveDB 형식?
        return;
    }

    public static void deleteAccount(String type, String id) {
    	
    	if (type.equals("IndividualAccount")) { // type 형식?
    		for (int i = 0;i < individualAccounts.size();i++) {
    			if (individualAccounts.get(i).getId().equals(id))
    				individualAccounts.remove(i); // ArrayList에서 직접 삭제
    		}
    	}
    	else {
    		for (int i = 0;i < enterpriseAccounts.size();i++) {
    			if (enterpriseAccounts.get(i).getId().equals(id))
    				enterpriseAccounts.remove(i);
    		}
    	}
    	
        return;
    }

    public static String showWithdrawalTerms() {
    	String withdrawalTerms = "Once you leave, you cannot join again with the same email.\n"
        return withdrawalTerms;
    }
    
    public static ArrayList<IndividualAccount> getIndividualAccounts()
    {
        return individualAccounts;
    }//DB에서 회원들 조회
    public static ArrayList<EnterpriseAccount> getEnterpriseAccounts()
    {
        return enterpriseAccounts;
    }

    public void saveDB(Object o)
    {
        return;
        //받은 obeject를 string으로 변환해서 text파일에 저장하기
    }
    public Object readDb(String dbname)
    {
        return null;
    }


    public ArrayList<Object> readDB(String tablename) {
        return null;
    }
}