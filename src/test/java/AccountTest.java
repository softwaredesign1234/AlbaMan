import controller.AccountController;
import model.IndividualAccount;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class AccountTest {
    @Mock
    private static IndividualAccount individual;
    AccountController accountController;

    private static String id="aa1234";
    private static String password="1234";
    private static String name="aaaa";
    private static String email="aa1234@naver.com";
    private static String phoneNumber="010-7777-7777";
    private static int age=55;
    private static String gender="F";


    @Test
    void Individualtest()
    {

        IndividualAccount individualAccount=accountController.signupIndividual(id,password,name,email,phoneNumber,age,gender);

        assertEquals(id,individualAccount.getId());

    }




}
