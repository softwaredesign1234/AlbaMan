import boundary.DBBoundary;
import controller.AccountController;
import model.EnterpriseAccount;
import model.IndividualAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.Assert.*;

import boundary.AccountBoundary;

import java.util.ArrayList;

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
    private static String id = "aa1234";
    private static String password = "1234";
    private static String name = "individualName";
    private static String email = "aa1234@naver.com";
    private static String phoneNumber = "010-7777-7777";
    private static int age = 55;
    private static String gender = "F";

    @Mock
    private static String companyName = "KakaoEnterprise";
    private static String companyNum = "123-45-67890";
    private static String companyId = "bb134";
    private static String companypassword="1234";
    private static String companyLocation = "Daegu";
    private static String inditype = "Individual";
    private static String entertype = "Enterprise";
    private static String category="IT";
    private static String companyPhonenumber="053-333-3333";

    @BeforeEach
    void basicMember()
    {
        clearDB("IndividualAccount");
        clearDB("EnterpriseAccount");
        individual1=new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
        individual2=new IndividualAccount("aa1111@naver.com","010-1111-1111",21,"M","aa1111","1111","Tom",true,true,"Individual");
        enterprise1=new EnterpriseAccount("000-00-00000","Restaurant","053-222-2222","Daegu","bb0000","0000","steakhouse",true,true,"Enterprise");
        enterprise2=new EnterpriseAccount("111-11-11111","SwimmingPool","053-333-3333","Daegu","bb1111","1111","blueswimming",true,true,"Enterprise");

        saveEnterDB(enterprise1);
        saveEnterDB(enterprise2);
        saveIndiDB(individual1);
        saveIndiDB(individual2);
    }

    @Test
    @DisplayName("UC1-정상")
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


    }
    @Test
    @DisplayName("UC1-실패(이메일 형식 틀림)")
    void IndividualSignupFailwrongemail() {
        String wrongEmail="aa1234@naver";

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput("Individual", wrongEmail); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return

        assertEquals(message,"권한 실패");
    }

    @Test
    @DisplayName("UC1-실패(타입 잘못 입력)")
    void IndividualSignupFailwrongtype() {
        String wrongtype="hihi";

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput(wrongtype, email); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return

        assertEquals(message,"타입은 Individual과 Enterprise 중 하나로 입력해주세요");
    }

    @Test
    @DisplayName("UC2-정상")
    void EnterpriseSignupSuccess() {
        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput(entertype, companyNum); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return
        EnterpriseAccount enterpriseAccount = accountBoundary.enterSignup(companyNum, category,companyPhonenumber, companyLocation,companyId,companypassword,companyName);

        assertEquals(message, "권한 성공");
        assertEquals(companyId, enterpriseAccount.getId());
        assertEquals(companypassword, enterpriseAccount.getPassword());
        assertEquals(companyName, enterpriseAccount.getName());
        assertEquals(companyNum, enterpriseAccount.getEnterpriseNum());
        assertEquals(companyPhonenumber, enterpriseAccount.getEnterprisePhoneNumber());
        assertEquals(category, enterpriseAccount.getCategory());
        assertEquals(companyLocation, enterpriseAccount.getEnterpriseLocation());



    }

    @Test
    @DisplayName("UC2-실패(사업자번호 형식 틀림)")
    void EnterpriseSignupFailwrongecompanyNum() {
        String wrongCompanynum="000-777-777";

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput(entertype, wrongCompanynum); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return

        assertEquals(message,"권한 실패");
    }
    @Test
    @DisplayName("UC2-실패(타입 잘못 입력)")
    void EnterpriseSignupFailwrongtype() {

        accountBoundary.startSignup(); //이용약관: boundary->controller에 약관 요청-> 약관 return
        String message=accountBoundary.inputValidationInput("enter", companyNum); //valid 확인: boundary ->개인=이메일, 기업=사업자번호->controller 형식 확인 -> boundary에 권한 return


        assertEquals(message,"타입은 Individual과 Enterprise 중 하나로 입력해주세요");
    }

    @Test
    @DisplayName("UC3-정상(기업로그인)")
    void EnterpriseSignin() {

        EnterpriseAccount enterpriseAccount= (EnterpriseAccount) accountBoundary.signIn("Enterprise","bb1111","1111");

        System.out.println("기업id는 : "+enterpriseAccount.getId());
        assertEquals(enterprise2.getEnterpriseNum(),enterpriseAccount.getEnterpriseNum());

    }


    @Test
    @DisplayName("UC3-정상(개인로그인)")
    void IndividualSignin() {

        IndividualAccount individualAccount= (IndividualAccount) accountBoundary.signIn("Individual","aa1111","1111");

        System.out.println("개인 id는: " +individualAccount.getId());

    }

    @Test
    @DisplayName("UC3-실패(비밀번호 잘못 입력)")
    void IndividualSigninWrongpassword() {

        String wrongpassword="5654";
        Object message=accountBoundary.signIn("Individual","aa1111",wrongpassword);

        assertEquals(message,"권한 실패");
        System.out.println("비밀번호가 틀렸습니다");

    }


    @Test
    @DisplayName("UC6.1-개인회원정보 수정 정상")
    void IndividualModifyInfoSuccess() {

        String changedName = "different_Name";
        String changedAge = "88";

        ArrayList<IndividualAccount> iAccounts = readIndiDB();
        for (IndividualAccount i : iAccounts) {
            System.out.println("id : " + i.getId());
            System.out.println("name : " + i.getName());
            System.out.println("Age : " + i.getAge());
        }
        System.out.println("--------------modify---------------");

        AccountBoundary.modifyIndividualInfo("aa0000", "0000", 1, changedName);
        System.out.println("-------------------------------------------");
        AccountBoundary.modifyIndividualInfo("aa1111", "1111", 3, changedAge);

        System.out.println("--------------result----------------");
        iAccounts = readIndiDB();
        for (IndividualAccount i : iAccounts) {
            System.out.println("id : " + i.getId());
            System.out.println("name : " + i.getName());
            System.out.println("Age : " + i.getAge());
        }

    }

    @Test
    @DisplayName("UC6.2-기업회원정보 수정 정상")
    void EnterpriseModifyInfoSuccess() {

        String changedName = "different_company_Name";
        String changedLocation = "Seoul";

        ArrayList<EnterpriseAccount> eAccounts = readEnterDB();
        for (EnterpriseAccount e : eAccounts) {
            System.out.println("id : " + e.getId());
            System.out.println("name : " + e.getName());
            System.out.println("Location : " + e.getEnterpriseLocation());
        }
        System.out.println("--------------modify---------------");

        AccountBoundary.modifyEnterpriseInfo("bb0000", "0000", 1, changedName);
        System.out.println("-------------------------------------------");
        AccountBoundary.modifyEnterpriseInfo("bb0000", "0000", 5, changedLocation);

        System.out.println("--------------result----------------");
        eAccounts = readEnterDB();
        for (EnterpriseAccount e : eAccounts) {
            System.out.println("id : " + e.getId());
            System.out.println("name : " + e.getName());
            System.out.println("Location : " + e.getEnterpriseLocation());
        }
    }

    @Test
    @DisplayName("UC6.1-개인 회원 정보 수정 - 비밀번호 불일치 실패")
    void IndividualModifyInfoFail() {
        String changedName = "different name";

        accountBoundary.modifyIndividualInfo("aa0000", "0000",1, changedName);
    }

    @Test
    @DisplayName("UC6.2-기업 회원 정보 수정 - 비밀번호 불일치 실패")
    void EnterpriseModifyInfoFail() {
        String changedName = "different company Name";

        AccountBoundary.modifyEnterpriseInfo("bb0000", "0001", 1, changedName);
    }

    @Test
    @DisplayName("UC7.1-개인 회원 탈퇴")
    void IndividualWithdraw() {
        AccountBoundary.withdrawAccount("Individual", "aa0000", "0000");
    }


    @Test
    @DisplayName("UC7.1-개인 회원 탈퇴 실패 - 비밀번호 불일치")
    void IndividualWithdrawalFail() {
        AccountBoundary.withdrawAccount("Individual", "aa0000", "1111");
    }

    @Test
    @DisplayName("UC7.2-기업 회원 탈퇴")
    void EnterpriseWithdraw() {
        AccountBoundary.withdrawAccount("Enterprise", "bb0000", "0000");
    }

    @Test
    @DisplayName("UC7.2-기업 회원 탈퇴 실패 - 비밀번호 불일치")
    void EnterpriseWithdrawalFail() {
        AccountBoundary.withdrawAccount("Enterprise", "bb0000", "1111");
    }





}
