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
    }

    public void withdrawAccount() {
    }



}
