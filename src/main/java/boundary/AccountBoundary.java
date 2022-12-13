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

    public void startSignup()
    {
        //SEQ1: showTerms호출
    }
    public String showTerms()
    {
        return null;
    }
    public void inputValidationInput()
    {
        //SEQ1: 회원가입 전 액터가 인증정보 입력 (Loop 첫단계)
    }

    public void vadlidation()
    {
        //SEQ1: 인증정보 확인

    }


    public void signIn()
    {

    }

    public void signUp()
    {

    }



    public String permission() //give permission,show failMessage
    {
        return null;
    }
    public void modifyIndividualInfo() {
    }

    public void modifyEnterpriseInfo() {

    }

    public void withdrawAccount() {
    }

    public String showResultMessage() {
        return null;
    }



}
