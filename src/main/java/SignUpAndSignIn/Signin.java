package SignUpAndSignIn;
import java.util.*;
import java.io.*;
import SignUpAndSignIn.Signup;
import account.IndividualAccount;


public class Signin {

    public static ArrayList<IndividualAccount> arr=Signup.getIndividualAccounts();

    public static Signup signup=new Signup();
    public static void signupind()
    {
        String id="aa1234";
        String password="1234";
        String name="park";
        String email="pyunj787@naver.com";
        String phoneNumber="010-5555-5555";
        int age=20;
        String gender="F";
        String companyNum="000-00-00000";
        String category="IT company";
        String companyPhoneNumber="010-777-7777";
        String companyLocation="대구광역시 북구 산격동";


        signup.signupEnter(companyNum,category,companyPhoneNumber,companyLocation,id,password,name);
    }

    public static void main(String[] args) throws Exception{
        signupind();
        System.out.print(arr.get(0));

    }
}
