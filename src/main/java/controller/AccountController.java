package controller;

import model.EnterpriseAccount;
import model.IndividualAccount;

import java.util.ArrayList;
import java.util.regex.Pattern;

import boundary.DBBoundary;

import static boundary.AccountBoundary.modifyIndividualInfo;


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
        saveIndiDB(individualAccount);
        System.out.println("Signup Success!");
        System.out.println("your Id: "+individualAccount.getId());
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

        saveEnterDB(enterpriseAccount);
        System.out.println("Signup Success!");
        System.out.println("your Id: "+enterpriseAccount.getId());
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
        ArrayList<IndividualAccount> arr=readIndiDB();
        IndividualAccount resultIndividual=arr.stream()
                .filter(account -> id.equals(account.getId())&&password.equals(account.getPassword()))
                .findAny()
                .orElse(null);


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

    public static Boolean verifyPassword(String type, String id, String password) {

        ArrayList<IndividualAccount> indiAccounts = getIndividualAccounts();
        ArrayList<EnterpriseAccount> enterAccounts = getEnterpriseAccounts();

        if (type.equals("Individual")) {
            IndividualAccount iAccount = indiAccounts.stream()
                    .filter(account -> id.equals(account.getId()) && password.equals(account.getPassword()))
                    .findAny()
                    .orElse(null);

            if (iAccount == null)	{
                System.out.println("비밀번호 불일치");
                return false;
            }
            else 					return true;
        }
        else {
            EnterpriseAccount eAccount = (EnterpriseAccount) enterAccounts.stream()
                    .filter(e -> ((e.getId().equals(id)) && (e.getPassword().equals(password))))
                    .findAny()
                    .orElse(null);

            if (eAccount == null)	{
                System.out.println("비밀번호 불일치");
                return false;
            }
            else 					return true;
        }
    }

    public static void modifyIndividualAccountInfo(String individualId, int infoType, String modifiedInfo) {

        // protected String name;      -> #1
        // private String phoneNumber; -> #2
        // private int age;            -> #3
        // private String gender;      -> #4

        individualAccounts = getIndividualAccounts();
        IndividualAccount iAccount = (IndividualAccount) individualAccounts.stream()
                .filter(i -> i.getId().equals(individualId))
                .findAny()
                .orElse(null);


        if (iAccount == null) {
            System.out.println("개인회원 정보 수정 실패");
        }
        else {
            switch (infoType) {
                case 1:
                    iAccount.setName(modifiedInfo);
                    break;
                case 2:
                    iAccount.setPhoneNumber(modifiedInfo);
                    break;
                case 3:
                    try {
                        iAccount.setAge(Integer.parseInt(modifiedInfo));
                    }
                    catch (NumberFormatException e) { System.out.println("modifying age -> Number format error"); }
                    break;
                case 4:
                    iAccount.setGender(modifiedInfo);
            }

            individualAccounts.remove(iAccount);
            individualAccounts.add(iAccount);
            saveIndiDB(individualAccounts);


            System.out.println("개인회원 정보 수정 성공");

        }
    }

    public static void modifyEnterpriseAccountInfo(String enterpriseId, int infoType, String modifiedInfo) {

        // protected String name;                  -> #1
        // private String enterpriseNum;           -> #2
        // private String category;                -> #3
        // private String enterprisePhoneNumber;   -> #4
        // private String enterpriseLocation;      -> #5

        enterpriseAccounts = getEnterpriseAccounts();
        EnterpriseAccount eAccount = (EnterpriseAccount) enterpriseAccounts.stream()
                .filter(e -> e.getId().equals(enterpriseId))
                .findAny()
                .orElse(null);


        if (eAccount == null) {
            System.out.println("기업회원 정보 수정 실패");
            return;
        }
        else {
            switch (infoType) {
                case 1:
                    eAccount.setName(modifiedInfo);
                    break;
                case 2:
                    eAccount.setEnterpriseNum(modifiedInfo);
                    break;
                case 3:
                    eAccount.setCategory(modifiedInfo);
                    break;
                case 4:
                    eAccount.setEnterprisePhoneNumber(modifiedInfo);
                    break;
                case 5:
                    eAccount.setEnterpriseLocation(modifiedInfo);
            }

            enterpriseAccounts.remove(eAccount);
            enterpriseAccounts.add(eAccount);
            saveEnterDB(enterpriseAccounts);

            System.out.println("기업회원 정보 수정 성공");
        }
    }

    public static void deleteAccount(String type, String id) {

        if (type.equals("Individual")) {
            individualAccounts = getIndividualAccounts();
            IndividualAccount iAccount = (IndividualAccount) individualAccounts.stream()
                    .filter(i -> i.getId().equals(id))
                    .findAny()
                    .orElse(null);

            individualAccounts.remove(iAccount);
            saveIndiDB(individualAccounts);

            System.out.println("개인회원 탈퇴 성공");
        }
        else {
            enterpriseAccounts = getEnterpriseAccounts();
            EnterpriseAccount eAccount = (EnterpriseAccount) enterpriseAccounts.stream()
                    .filter(e -> e.getId().equals(id))
                    .findAny()
                    .orElse(null);

            enterpriseAccounts.remove(eAccount);
            saveEnterDB(enterpriseAccounts);

            System.out.println("기업회원 탈퇴 성공");
        }
    }
    public static ArrayList<IndividualAccount> getIndividualAccounts() {
        ArrayList<IndividualAccount> indiAccounts = readIndiDB();
        return indiAccounts;
    }

    public static ArrayList<EnterpriseAccount> getEnterpriseAccounts() {
        ArrayList<EnterpriseAccount> enterAccounts = readEnterDB();
        return enterAccounts;
    }

    public static String showWithdrawalTerms() {
        return "탈퇴 약관";
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
        saveIndiDB(individual1);
        saveIndiDB(individual2);

        modifyIndividualInfo("aa1234","aaaa",1,"namememe");
    }
}