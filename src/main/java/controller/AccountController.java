package controller;

import model.EnterpriseAccount;
import model.IndividualAccount;

import java.util.ArrayList;
import boundary.DBBoundary;




public class AccountController {

    public static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();
    public static ArrayList<EnterpriseAccount> enterpriseAccounts=new ArrayList<>();

    public static DBBoundary dbManager;

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

    //회원가입시 email, 사업자번호 인증
    public static Boolean isValidate(Boolean type,String info)
    {
        return null;

    }

    public Boolean verifyPassword(String type, String id, String passowrd) {
        return null;
    }

    public void modifyIndividualAccountInfo(String individualId, int infoType, String modifiedInfo) {
        return;
    }

    public void modifyEnterpriseAccountInfo(String enterpriseId, int infoType, String modifiedInfo) {
        return;
    }

    public void deleteAccount(String type, String id) {
        return;
    }

    public String showWithdrawalTerms() {
        return null;
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