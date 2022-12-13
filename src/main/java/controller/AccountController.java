package controller;

import model.EnterpriseAccount;
import model.IndividualAccount;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import boundary.DBBoundary;


public class AccountController extends DBBoundary{

    public static ArrayList<IndividualAccount> individualAccounts = new ArrayList<>();
    public static ArrayList<EnterpriseAccount> enterpriseAccounts = new ArrayList<>();


    public static String showTermsOfService() {

        String term = "이용약관에 대해 안내드립니다.";
        return term;
    }

    public static IndividualAccount signupIndividual(String id, String password, String name,
                                        String email, String phoneNumber, int age, String gender) {

        Boolean isActivate = true;
        IndividualAccount individualAccount = new IndividualAccount(email, phoneNumber, age, gender, id, password, name, true, isActivate, "Individual");
        individualAccounts.add(individualAccount); //개인계정 db에 추가
        saveIndiAccountDB(individualAccount);
        System.out.println("Signup Success!");

        return individualAccount;
}

    //000-00-00000
    public static EnterpriseAccount signupEnterprise(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                                        String id, String password, String name) {
        Boolean validation = isValidate("Enterprise", companyNum);
        Boolean isActivate = true;

        EnterpriseAccount enterpriseAccount = new EnterpriseAccount(companyNum,category, companyPhoneNumber, companyLocation,
                id, password, name,
               validation, isActivate,"Enterprise");
        enterpriseAccounts.add(enterpriseAccount); //개인계정 db에 추가

        System.out.println("회사폰넘버: "+enterpriseAccount.getEnterprisePhoneNumber());
        saveEnterDB(enterpriseAccount);
        System.out.println("Signup Success!");;
        return enterpriseAccount;
    }


    public static Object signIn(String type, String id, String password) {

        Boolean isSigninSuccess=false;
        Object account = null;
        if(type.equals("Individual")){
            if(signinIndividual(id,password)!=null)
            {
                isSigninSuccess=true;
                account=signinIndividual(id,password);
            }

        }
        else if(type.equals("Enterprise"))
        {
            if(signinEnterprise(id,password)!=null)
            {
                isSigninSuccess=true;
                account=signinEnterprise(id,password);
            }
        }
        return account;

    }

    //개인 로그인
    public static IndividualAccount signinIndividual(String id, String password) {
        System.out.println("컨트롤러 id: "+id);
        ArrayList<IndividualAccount> arr=readIndiDB();
        IndividualAccount resultIndividual=arr.stream()
                .filter(account -> id.equals(account.getId())&&password.equals(account.getPassword()))
                .findAny()
                .orElse(null);


        System.out.println("찾은id :"+resultIndividual.getId());
        return resultIndividual;

    }

    //기업 로그인
    public static EnterpriseAccount signinEnterprise(String id, String password) {
        ArrayList<EnterpriseAccount> arr=readEnterDB();
        EnterpriseAccount resultEnterprise=arr.stream()
                .filter(account -> id.equals(account.getId())&&password.equals(account.getPassword()))
                .findAny()
                .orElse(null);


        return resultEnterprise;
    }


    //회원가입시 email, 사업자번호 인증
    public static Boolean isValidate(String type, String info) {
        Boolean valid = false;
        String indiRegex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern indip = Pattern.compile(indiRegex);

        String enterRegex = "\\d{3}-\\d{2}-\\d{5}";
        Pattern enterp = Pattern.compile(enterRegex);


        if (type.equals("Individual")) {
            if (indip.matcher(info).matches())
                valid = true;
        } else if (type.equals("Enterprise")) {

            if (enterp.matcher(info).matches())
                valid = true;
        }
        return valid;

    }





    //----------------------------------------------------------------------------------------------------------------------------------






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

    public static ArrayList<IndividualAccount> getIndividualAccounts() {
        return individualAccounts;
    }//DB에서 회원들 조회

    public static ArrayList<EnterpriseAccount> getEnterpriseAccounts() {
        return enterpriseAccounts;
    }

    public void saveDB(Object o) {
        return;
        //받은 obeject를 string으로 변환해서 text파일에 저장하기
    }

    public Object readDb(String dbname) {
        return null;
    }


    public ArrayList<Object> readDB(String tablename) {
        return null;
    }

    public static void main(String[] args) throws Exception{
        signupIndividual("aa1234","aaaa","name","aa1234@naver.com","010-1111-1111",25,"F");
        signupEnterprise("000-00-00000","IT","053-777-7777","대구","bb4567","4567","kakao");
        Object object=signIn("Enterprise","bb4657","4567");
        System.out.println(object);
        IndividualAccount individual1=new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
        IndividualAccount individual2=new IndividualAccount("aa1111@naver.com","010-1111-1111",21,"M","aa1111","1111","Tom",true,true,"Individual");
        EnterpriseAccount enterprise1=new EnterpriseAccount("000-00-00000","Restaurant","053-222-2222","Daegu","bb0000","0000","steakhouse",true,true,"Enterprise");
        EnterpriseAccount enterprise2=new EnterpriseAccount("111-11-11111","SwimmingPool","053-333-3333","Daegu","bb1111","1111","blueswimming",true,true,"Enterprise");

//        saveEnterDB(enterprise1);
//        saveEnterDB(enterprise2);
        saveIndiAccountDB(individual1);
        saveIndiAccountDB(individual2);

    }
}