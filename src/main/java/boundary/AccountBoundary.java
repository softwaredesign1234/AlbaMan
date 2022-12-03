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
        String type=scanner.next();
        if(type.equals("Enterprise"))
        {
            String companyNum=scanner.next();
            String category=scanner.next();
            String companyPhoneNumber=scanner.next();
            String companyLocation=scanner.next();
            String id=scanner.next();
            String password=scanner.next();
            String name=scanner.next();
            AccountController.signupEnterprise(companyNum,category,companyPhoneNumber,companyLocation,id,password,name);
        }
        else if(type.equals("Individual"))
        {
            String id=scanner.next();
            String password=scanner.next();
            String name=scanner.next();
            String email=scanner.next();
            String phoneNumber=scanner.next();
            int age=scanner.nextInt();
            String gender=scanner.next();
            AccountController.signupIndividual(id,password,name,email,phoneNumber,age,gender);
        }
        else
            System.out.println("타입을 잘못 입력하셨습니다.");

    }



}
