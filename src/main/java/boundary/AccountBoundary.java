package boundary;

import controller.AccountController;
import model.EnterpriseAccount;
import model.IndividualAccount;
import controller.AccountController;

import java.awt.*;
import java.util.*;


public class AccountBoundary {

    public static AccountController a;
    //나중에 NullPointerException으로 수정하기

    public static void startSignup() {
        //SEQ1: showTerms호출
        String terms = a.showTermsOfService();
        System.out.println(terms);
    }


    public static String inputValidationInput(String type, String info) {
        //SEQ1: 회원가입 전 액터가 인증정보 입력 (Loop 첫단계)

        Boolean isvalid = false;

        //AccountController에 isValidate 함수 호출
        if (type.equals(("Individual"))) {
            isvalid = a.isValidate(type, info);
        } else if (type.equals("Enterprise")) {
            isvalid = a.isValidate(type, info);
        }else
            return "타입은 Individual과 Enterprise 중 하나로 입력해주세요";

        if(isvalid == true)
            return permission(true);
        else
        {
            System.out.println("인증정보를 정확히 입력해주세요.");
            return permission(false);
        }

    }


    public static IndividualAccount indiSignup(String id, String password, String name, String email, String phoneNumber, int age, String gender) {
        IndividualAccount individualAccount = a.signupIndividual(id, password, name, email, phoneNumber, age, gender);

        System.out.println("개인회원 가입성공!");
        return individualAccount;
    }

    public static EnterpriseAccount enterSignup(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                                                String id, String password, String name) {
        EnterpriseAccount enterpriseAccount = a.signupEnterprise(companyNum, category, companyPhoneNumber, companyLocation,
                id,password, name);
        System.out.println("기업회원 가입성공! id는: " + enterpriseAccount.getId());
        return enterpriseAccount;
    }


    public static String permission(Boolean isSuccess) //give permission,show failMessage
    {
        String permissionMessage;
        //singup 결과를 불러와서 true면 성공메시지, false면 실패메시지 출력하기
        if (isSuccess == true)
            permissionMessage = "권한 성공";
        else
            permissionMessage = "권한 실패";
        return permissionMessage;
    }

    public static Object signIn(String type,String id,String password) {

        if(type.equals("Individual"))
        {
            IndividualAccount individualAccount= a.signinIndividual(id,password);
            if(individualAccount!=null)
            {
                System.out.println(permission(true));
                return individualAccount;
            }
            else
                System.out.println(permission(false));


        }
        else
        {
            EnterpriseAccount enterpriseAccount=a.signinEnterprise(id,password);
            if(enterpriseAccount!=null)
            {
                System.out.println(permission(true));
                return enterpriseAccount;
            }
            else
                System.out.println(permission(false));
        }

        return null;
    }


    public static void modifyIndividualInfo(String id, String password, int infoType, String modifiedInfo) {

        ArrayList<IndividualAccount> iAccounts = a.getIndividualAccounts();

        Boolean result = AccountController.verifyPassword("Individual", id, password);
        String message = permission(result);

        if (result == true) {
            System.out.println(message);
            AccountController.modifyIndividualAccountInfo(id, infoType, modifiedInfo);
            System.out.println(showResultMessage());
        }
        else {
            System.out.println(message);
            System.out.println(showResultMessage());
        }
    }

    public static void modifyEnterpriseInfo(String id, String password, int infoType, String modifiedInfo) {

        ArrayList<EnterpriseAccount> eAccounts = a.getEnterpriseAccounts();

        Boolean result = a.verifyPassword("Enterprise", id, password);
        String message = permission(result);

        if (result == true) {
            System.out.println(message);
            a.modifyEnterpriseAccountInfo(id, infoType, modifiedInfo);
            System.out.println(showResultMessage());
        }
        else {
            System.out.println(message);
            System.out.println(showResultMessage());
        }
    }

    public static void withdrawAccount(String type, String id, String password) {

        if (type.equals("Individual")) {
            ArrayList<IndividualAccount> iAccounts = AccountController.getIndividualAccounts();

            Boolean result = AccountController.verifyPassword("Individual", id, password);
            String message = permission(result);

            if (result == true) {
                System.out.println(AccountController.showWithdrawalTerms());
                AccountController.deleteAccount("Individual", id);
                System.out.println(message);
                System.out.println(showResultMessage());
            }
            else {
                System.out.println(message);
                System.out.println(showResultMessage());
            }
        }
        else {
            ArrayList<EnterpriseAccount> eAccounts = AccountController.getEnterpriseAccounts();

            Boolean result = AccountController.verifyPassword("Enterprise", id, password);
            String message = permission(result);

            if (result == true) {
                System.out.println(AccountController.showWithdrawalTerms());
                AccountController.deleteAccount("Enterprise", id);
                System.out.println(message);
                System.out.println(showResultMessage());
            }
            else {
                System.out.println(message);
                System.out.println(showResultMessage());
            }
        }

    }

    public static String showResultMessage() {
        return "종료";
    }

    public static void main(String[] args) throws Exception {

        String id = "hello";
        String password = "1234";
        String name = "first name";
        String email = "ww@naver.com";
        String phoneNumber = "010-1111-2222";
        int age = 11;
        String gender = "M";

        AccountBoundary a = new AccountBoundary();

        a.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message = a.inputValidationInput("Individual", email); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return
        IndividualAccount individualAccount = a.indiSignup(id, password, name, email, phoneNumber, age, gender);

        a.modifyIndividualInfo(id, password, 1, "different Name");

    }

}
