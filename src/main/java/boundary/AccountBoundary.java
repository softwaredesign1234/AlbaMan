package boundary;

import controller.AccountController;
import model.EnterpriseAccount;
import model.IndividualAccount;

import java.util.ArrayList;


public class AccountBoundary {

    public static AccountController accountController;

    public static void startSignup() {
        //SEQ1: showTerms호출
        System.out.println("Boundary - startSignup() visited");
        String terms = accountController.showTermsOfService();
        System.out.println(terms);
    }


    public static String inputValidationInput(String type, String info)
    {
        //SEQ1: 회원가입 전 액터가 인증정보 입력 (Loop 첫단계)
        System.out.println("Boundary - inputValidationInput() visited");
        Boolean isvalid = false;

        //AccountController에 isValidate 함수 호출
        if (type.equals(("Individual"))) {
            isvalid = accountController.isValidate(type, info);
        } else if (type.equals("Enterprise")) {
            isvalid = accountController.isValidate(type, info);
        }else{
            System.out.println(permission(false));
            System.out.println("타입은 Individual과 Enterprise 중 하나로 입력해주세요");
            return "타입은 Individual과 Enterprise 중 하나로 입력해주세요";
        }


        if(isvalid == true)
        {
            System.out.println("권한 성공");
            return permission(true);
        }

        else
        {
            System.out.println(permission(false));
            System.out.println("인증정보를 정확히 입력해주세요.");
            return permission(false);
        }

    }


    public static IndividualAccount indiSignup(String id, String password, String name, String email, String phoneNumber, int age, String gender) {
        System.out.println("Boundary - indiSignup() visited");
        IndividualAccount individualAccount = accountController.signupIndividual(id, password, name, email, phoneNumber, age, gender);
        if(individualAccount==null)
            System.out.println(permission(false));
        return individualAccount;
    }

    public static EnterpriseAccount enterSignup(String companyNum, String category, String companyPhoneNumber, String companyLocation,
                                                String id, String password, String name) {
        System.out.println("AccountBoundary - enterSignup() visited");
        EnterpriseAccount enterpriseAccount = accountController.signupEnterprise(companyNum, category, companyPhoneNumber, companyLocation,
                id,password, name);
        return enterpriseAccount;
    }


    public static String permission(Boolean isSuccess) //give permission,show failMessage
    {
        System.out.println("AccountBoundary - permission() visited");
        String permissionMessage;
        //singup 결과를 불러와서 true면 성공메시지, false면 실패메시지 출력하기
        if (isSuccess == true)
            permissionMessage = "권한 성공";
        else
            permissionMessage = "권한 실패";
        return permissionMessage;
    }

    public static Object signIn(String type,String id,String password) {
        System.out.println("AccountBoundary - signIn() visited");
        if(type.equals("Individual"))
        {
            IndividualAccount individualAccount= accountController.signinIndividual(id,password);
            if(individualAccount!=null)
            {
                System.out.println(permission(true));
                return individualAccount;
            }
            else
            {
                System.out.println(permission(false));
                return permission(false);
            }



        }
        else
        {
            EnterpriseAccount enterpriseAccount=accountController.signinEnterprise(id,password);
            if(enterpriseAccount!=null)
            {
                System.out.println(permission(true));
                return enterpriseAccount;
            }
            else
            {
                System.out.println(permission(false));
                return permission(false);
            }
        }

    }
    public static void modifyIndividualInfo(String id, String password, int infoType, String modifiedInfo) {
        System.out.println("AccountBoundary - modifyIndividualInfo() visited");
        ArrayList<IndividualAccount> iAccounts = accountController.getIndividualAccounts();

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
        System.out.println("AccountBoundary - modifyEnterpriseInfo() visited");
        ArrayList<EnterpriseAccount> eAccounts = accountController.getEnterpriseAccounts();

        Boolean result = accountController.verifyPassword("Enterprise", id, password);
        String message = permission(result);

        if (result == true) {
            System.out.println(message);
            accountController.modifyEnterpriseAccountInfo(id, infoType, modifiedInfo);
            System.out.println(showResultMessage());
        }
        else {
            System.out.println(message);
            System.out.println(showResultMessage());
        }
    }

    public static void withdrawAccount(String type, String id, String password) {
        System.out.println("AccountBoundary - withdrawAccount() visited");
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

        System.out.println("AccountBoundary - showResultMessage() visited");
        return "종료";
    }

    public static void main(String[] args) throws Exception {

        String id = "individual";
        String password = "1234";
        String name = "individualName";
        String email = "aa1234@naver.com";
        String phoneNumber = "010-7777-7777";
        int age = 55;
        String gender = "F";
        IndividualAccount individualAccount=indiSignup(id, password, name, email, phoneNumber, age, gender);

        System.out.println("회원가입 ID는: "+individualAccount.getId());
        IndividualAccount ind= (IndividualAccount) signIn("Individual","individual","1234");
        System.out.println("id는: "+ind.getId());

        Object result=signIn("Individual","individual","5645");
        System.out.println(result);

        modifyIndividualInfo("individual","1234",1,"YUNJUPARK");

    }


}
