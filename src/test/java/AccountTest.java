import boundary.DBBoundary;
import controller.AccountController;
import model.EnterpriseAccount;
import model.IndividualAccount;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import boundary.AccountBoundary;

public class AccountTest extends DBBoundary{
    @Mock
    private static IndividualAccount individual;
    AccountController accountController;
    IndividualAccount individual1;
    IndividualAccount individual2;
    EnterpriseAccount enterprise1;
    EnterpriseAccount enterprise2;
    @Mock
    AccountBoundary accountBoundary;
    private static String id = "individual";
    private static String password = "1234";
    private static String name = "individual Name";
    private static String email = "aa1234@naver.com";
    private static String phoneNumber = "010-7777-7777";
    private static int age = 55;
    private static String gender = "F";

    @Mock
    private static String companyName = "KakaoEnterprise";
    private static String companyNum = "123-45-67890";
    private static String companyId = "companyid";
    private static String companypassword="companypassword";
    private static String companyLocation = "Daegu";
    private static String inditype = "Individual";
    private static String entertype = "Enterprise";
    private static String category="IT";
    private static String companyPhonenumber="053-333-3333";

    @BeforeEach
    void basicMember()
    {
        individual1=new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
        individual2=new IndividualAccount("aa1111@naver.com","010-1111-1111",21,"M","aa1111","1111","Tom",true,true,"Individual");
        enterprise1=new EnterpriseAccount("000-00-00000","Restaurant","053-222-2222","Daegu","bb0000","0000","steakhouse",true,true,"Enterprise");
        enterprise2=new EnterpriseAccount("111-11-11111","SwimmingPool","053-333-3333","Daegu","bb1111","1111","blueswimming",true,true,"Enterprise");

        saveEnterDB(enterprise1);
        saveEnterDB(enterprise2);
        saveIndiAccountDB(individual1);
        saveIndiAccountDB(individual2);
    }

    @Test
    @DisplayName("개인회원가입")
    void IndividualSignupSuccess() {
        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput("Individual", email); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return
        IndividualAccount individualAccount = accountBoundary.indiSignup(id, password, name, email, phoneNumber, age, gender);

        assertEquals(message, "권한 성공");
        assertEquals(id, individualAccount.getId());
        assertEquals(password, individualAccount.getPassword());
        assertEquals(name, individualAccount.getName());
        assertEquals(email, individualAccount.getEmail());
        assertEquals(phoneNumber, individualAccount.getPhoneNumber());
        assertEquals(age, individualAccount.getAge());
        assertEquals(gender, individualAccount.getGender());

        System.out.println("id: " + individualAccount.getId());
        System.out.println("password: " + individualAccount.getPassword());
        System.out.println("name: " + individualAccount.getName());
        System.out.println("email: " + individualAccount.getEmail());
        System.out.println("phoneNumber: " + individualAccount.getPhoneNumber());
        System.out.println("age: " + individualAccount.getAge());
        System.out.println("gender: " + individualAccount.getGender());


    }
    @Test
    @DisplayName("개인회원가입-이메일 형식 틀림")
    void IndividualSignupFailwrongemail() {
        String wrongEmail="aa1234@naver";

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput("Individual", wrongEmail); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return

        assertEquals(message,"권한 실패");
        System.out.println("인증정보를 형식에 맞게 입력해주세요");
    }

    @Test
    @DisplayName("개인회원가입-타입 잘못 입력")
    void IndividualSignupFailwrongtype() {
        String wrongtype="hihi";

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput(wrongtype, email); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return

        assertEquals(message,"타입은 Individual과 Enterprise 중 하나로 입력해주세요");
    }

    @Test
    @DisplayName("기업회원가입")
    void EnterpriseSignupSuccess() {
        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput(entertype, companyNum); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return
        EnterpriseAccount enterpriseAccount = accountBoundary.enterSignup(companyNum, category,companyPhonenumber, companyLocation,companyId,companypassword,companyName);

        System.out.println("companyphoneNumber"+enterpriseAccount.getEnterprisePhoneNumber());
        assertEquals(message, "권한 성공");
        assertEquals(companyId, enterpriseAccount.getId());
        assertEquals(companypassword, enterpriseAccount.getPassword());
        assertEquals(companyName, enterpriseAccount.getName());
        assertEquals(companyNum, enterpriseAccount.getEnterpriseNum());
        assertEquals(companyPhonenumber, enterpriseAccount.getEnterprisePhoneNumber());
        assertEquals(category, enterpriseAccount.getCategory());
        assertEquals(companyLocation, enterpriseAccount.getEnterpriseLocation());

        System.out.println("id: " + enterpriseAccount.getId());
        System.out.println("password: " + enterpriseAccount.getPassword());
        System.out.println("companyname: " + enterpriseAccount.getName());
        System.out.println("companynum: " + enterpriseAccount.getEnterpriseNum());
        System.out.println("companyPhonenumber: " + enterpriseAccount.getEnterprisePhoneNumber());
        System.out.println("category: " + enterpriseAccount.getCategory());
        System.out.println("companylocation: " + enterpriseAccount.getEnterpriseLocation());

    }

    @Test
    @DisplayName("기업회원가입-사업자번호 형식 틀림")
    void EnterpriseSignupFailwrongecompanyNum() {
        String wrongCompanynum="000-777-777";

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput(entertype, wrongCompanynum); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return

        assertEquals(message,"권한 실패");
        System.out.println("인증정보를 형식에 맞게 입력해주세요");
    }
    @Test
    @DisplayName("기업회원가입-타입 잘못 입력")
    void EnterpriseSignupFailwrongtype() {

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput("enter", companyNum); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return


        assertEquals(message,"타입은 Individual과 Enterprise 중 하나로 입력해주세요");
        System.out.println(message);
    }

    @Test
    @DisplayName("기업로그인")
    void EnterpriseSignin() {

        EnterpriseAccount enterpriseAccount= (EnterpriseAccount) accountBoundary.signIn("Enterprise","bb1111","1111");

        System.out.println("기업id는 : "+enterpriseAccount.getId());
        assertEquals(enterprise2.getEnterpriseNum(),enterpriseAccount.getEnterpriseNum());

    }


    @Test
    @DisplayName("개인로그인")
    void IndividualSignin() {

        IndividualAccount individualAccount= (IndividualAccount) accountBoundary.signIn("Individual","aa1111","1111");

        System.out.println("id는: " +individualAccount.getId());

    }

    @Test
    @DisplayName("개인로그인-비밀번호 잘못 입력")
    void IndividualSigninWrongpassword() {

        String wrongpassword="5654";
        Object message=accountBoundary.signIn("Individual","aa1111",wrongpassword);

        assertEquals(message,"권한 실패");
        System.out.println("비밀번호가 틀렸습니다");

    }








}
