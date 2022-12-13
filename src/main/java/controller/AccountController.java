package controller;

import model.EnterpriseAccount;
import model.IndividualAccount;

import java.lang.reflect.Array;
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
        saveIndiDB(individualAccount);
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





    //----------------------------------------------------------------------------------------------------------------------------------






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
            return;
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

    public static String showWithdrawalTerms() {
        return "탈퇴 약관";
    }

    public static ArrayList<IndividualAccount> getIndividualAccounts() {
        ArrayList<IndividualAccount> indiAccounts = readIndiDB();
        return indiAccounts;
    }

    public static ArrayList<EnterpriseAccount> getEnterpriseAccounts() {
        ArrayList<EnterpriseAccount> enterAccounts = readEnterDB();
        return enterAccounts;
    }




}