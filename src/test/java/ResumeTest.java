import boundary.DBBoundary;
import boundary.ResumeBoundary;
import controller.ResumeController;
import model.EnterpriseAccount;
import model.IndividualAccount;
import model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.Assert.*;

public class ResumeTest extends DBBoundary {
    @Mock
    IndividualAccount individual1;
    IndividualAccount individual2;
    EnterpriseAccount enterprise1;
    EnterpriseAccount enterprise2;
    DBBoundary dbBoundary;
    ResumeController resumeController;
    ResumeBoundary resumeBoundary;
    @BeforeEach
    void basicMember()
    {
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
    @DisplayName("UC5-이력서 작성")
    void saveResume() throws Exception {

        Resume resume=resumeBoundary.inputResume("aa1111","mynameisaa","1-2years",false);
        Resume resume1=resumeBoundary.inputResume("aa0000","pleaseHireMe!","0year",true);
        Resume resume2=resumeBoundary.inputResume("aa1234","hello!","5year",true);

        assertEquals("aa1111",resume.getIndividualAccount());
        assertEquals("mynameisaa",resume.getSelfIntroduction());

    }

    @Test
    @DisplayName("UC5-이력서 조회")
    void readResume()
    {
        Resume resume=resumeBoundary.showResume(2);
        assertEquals(2,resume.getId());
    }
}
