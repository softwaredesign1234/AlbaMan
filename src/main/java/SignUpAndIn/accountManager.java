package SignUpAndIn;

import account.EnterpriseAccount;
import account.IndividualAccount;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class accountManager {

    public static ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();
    public static ArrayList<EnterpriseAccount> enterpriseAccounts=new ArrayList<>();


    //valid로 이메일 형식 맞는지 확인하기
    //회원가입 더 NullpointException 같이 잘 짜보기..
    public static void signupIndividual(String id, String password, String name,
                                        String email, String phoneNumber, int age, String gender)
    {
        Boolean valid=false;
        Boolean isActivate=true;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);

        if(m.matches())
        {
            valid=true;

            IndividualAccount individualAccount=new IndividualAccount(email, phoneNumber, age, gender, id, password,name,valid,isActivate, "Individual");

            individualAccounts.add(individualAccount);
            System.out.println("Signup Success!");
        }
        else
        {
            valid=false;
            System.out.println("email pattern not matched");
        }
    }

    //000-00-00000
    public static void signupEnterprise(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                                   String id, String password, String name)
    {
        Boolean valid=false;
        Boolean isActivate=true;
        String regex = "\\d{3}-\\d{2}-\\d{5}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(companyNum);

        if(m.matches())
        {
            valid=true;
            //String email, String phoneNumber, int age, String gender, String id, String password,
            //                             String name, Boolean valid, Boolean isActive, String type
            EnterpriseAccount enterpriseAccount=new EnterpriseAccount(companyNum, category, companyPhoneNumber, companyLocation,id, password, name,
                    valid, isActivate, "Enterprise");

            enterpriseAccounts.add(enterpriseAccount);
            System.out.println("Signup Success!");
        }
        else
        {
            valid=false;
            System.out.println("companyNum pattern not matched");
        }
    }


    public static Boolean signIn(String type,String id,String password)
    {

        Boolean isSigninSuccess=false;
        if(type.equals("Individual")){
           if(signinIndividual(id,password)!=null)
               isSigninSuccess=true;
        }
        else
        {
            if(signinEnterprise(id,password)!=null)
                isSigninSuccess=true;
        }
        return isSigninSuccess;

    }

    //개인 로그인
    public static IndividualAccount signinIndividual(String id,String password )
    {
        ArrayList<IndividualAccount> arr=getIndividualAccounts();
        IndividualAccount resultIndividual=arr.stream()
                .filter(account -> id.equals(account.getId())&&password.equals(account.getPassword()))
                .findAny()
                .orElse(null);


        return resultIndividual;

    }

    //기업 로그인
    public static EnterpriseAccount signinEnterprise(String id,String password )
    {
        ArrayList<EnterpriseAccount> arr=getEnterpriseAccounts();
        EnterpriseAccount resultEnterprise=arr.stream()
                .filter(account -> id.equals(account.getId())&&password.equals(account.getPassword()))
                .findAny()
                .orElse(null);


        return resultEnterprise;

    }

    static ArrayList<IndividualAccount> getIndividualAccounts()
    {
        return individualAccounts;
    }
    public static ArrayList<EnterpriseAccount> getEnterpriseAccounts()
    {
        return enterpriseAccounts;
    }

    public static void main(String[] args) throws Exception{

        String idIndi="aa1234";
        String idEnter="bb5678";

        String passwordIndi="1234";
        String passwordEnter="5678";
        String name="park";
        String email="pyunj787@naver.com";
        String phoneNumber="010-5555-5555";
        int age=20;
        String gender="F";
        String companyNum="000-00-00000";
        String category="IT company";
        String companyPhoneNumber="010-777-7777";
        String companyLocation="대구광역시 북구 산격동";


        signupIndividual(idIndi,passwordIndi,name,email,phoneNumber, age,gender);
        signupEnterprise(companyNum,category,companyPhoneNumber,companyLocation,idEnter,passwordEnter,name);

        System.out.println(signIn("Individual","aa1234","5678"));


    }
}