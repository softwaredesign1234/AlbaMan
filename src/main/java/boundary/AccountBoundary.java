package boundary;
import controller.AccountController;
import model.EnterpriseAccount;
import model.IndividualAccount;
import controller.AccountController;
import java.util.*;


public class AccountBoundary {
    Scanner scanner=new Scanner(System.in);
    ArrayList<IndividualAccount> individualAccounts=new ArrayList<>();
    ArrayList<EnterpriseAccount> enterpriseAccounts=new ArrayList<>();

    Object account;
    AccountController a;
    //나중에 NullPointerException으로 수정하기

    public void startSignup()
    {
        //SEQ1: showTerms호출
        String terms=a.showWithdrawalTerms();
        System.out.println(terms);
    }


    public void inputValidationInput()
    {
        //SEQ1: 회원가입 전 액터가 인증정보 입력 (Loop 첫단계)
        System.out.print("타입:");
        String type=scanner.next();
        System.out.println();
        Boolean isvalid=false;

        //AccountController에 isValidate 함수 호출
        if(type.equals(("Individual"))) {
            System.out.print("이메일:");
            String email = scanner.next();
            System.out.println();

            isvalid = a.isValidate(type, email);
        }
        else if(type.equals("Enterprise"))
        {
            System.out.print("사업자번호:");
            String enterpriseNumber = scanner.next();
            System.out.println();

           isvalid = a.isValidate(type, enterpriseNumber);
        }
        else
            System.out.println("타입은 Individual과 Enterprise 중 하나로 입력해주세요");

        if(isvalid==true)
            permission(true);
        else
            permission(false);
    }




    public void signUp()
    {
        System.out.print("타입:");
        String type=scanner.next();
        System.out.println();

        if(type.equals("Individual"))
        {
            System.out.print("아이디:");
            String id=scanner.next();
            System.out.println();

            System.out.print("비밀번호:");
            String password=scanner.next();
            System.out.println();

            System.out.print("이름:");
            String name=scanner.next();
            System.out.println();

            System.out.print("이메일:");
            String email=scanner.next();
            System.out.println();

            System.out.print("휴대폰번호:");
            String phoneNumber=scanner.next();
            System.out.println();

            System.out.print("나이:");
            int age=scanner.nextInt();
            System.out.println();

            System.out.print("성별:");
            String gender=scanner.next();
            System.out.println();

            a.signupIndividual(id,password,name,email,phoneNumber,age,gender);
        }
        else if(type.equals("Enterprise"))
        {
            System.out.print("사업자번호:");
            String companyNum=scanner.next();
            System.out.println();

            System.out.print("업종:");
            String category=scanner.next();
            System.out.println();

            System.out.print("회사 전화번호:");
            String companyPhoneNumber=scanner.next();
            System.out.println();

            System.out.print("회사 위치:");
            String companyLocation=scanner.next();
            System.out.println();

            System.out.print("아이디:");
            String id=scanner.next();
            System.out.println();

            System.out.print("비밀번호:");
            String password=scanner.next();
            System.out.println();

            System.out.print("회사이름:");
            String name=scanner.next();
            System.out.println();

            a.signupEnterprise(companyNum,category,companyPhoneNumber,companyLocation,id,password,name);
        }
        else
            System.out.println("타입은 Individual과 Enterprise 중 하나로 입력해주세요");

    }



    public String permission(Boolean isSuccess) //give permission,show failMessage
    {
        String permissionMessage;
        //singup 결과를 불러와서 true면 성공메시지, false면 실패메시지 출력하기
        if(isSuccess==true)
            permissionMessage="성공";
        else
            permissionMessage="실패";
        return permissionMessage;
    }

    public void signIn()
    {
        System.out.println("타입을 입력하세요");
        String type=scanner.next();
        System.out.println("아이디를 입력하세요");
        String id=scanner.next();
        System.out.println("비밀번호를 입력하세요");
        String password=scanner.next();

        Object signinResult=a.signIn(type,id,password);
        if(signinResult!=null)
            permission(true);
        else
            permission(false);

        account=signinResult;

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

    public static void main(String[] args) throws Exception {






    }



}
