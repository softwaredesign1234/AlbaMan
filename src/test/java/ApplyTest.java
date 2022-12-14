import boundary.DBBoundary;
import boundary.ResumeBoundary;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class ApplyTest extends DBBoundary {
    @Mock
    IndividualAccount individual1;
    IndividualAccount individual2;
    EnterpriseAccount enterprise1;
    EnterpriseAccount enterprise2;

    Apply apply1;
    Apply apply2;
    ResumeBoundary resumeBoundary;
    @BeforeEach
    void basicMember()
    {
        individual1=new IndividualAccount("aa0000@naver.com","010-0000-0000",25,"F","aa0000","0000","janny",true,true,"Individual");
        individual2=new IndividualAccount("aa1111@naver.com","010-1111-1111",21,"M","aa1111","1111","Tom",true,true,"Individual");
        enterprise1=new EnterpriseAccount("000-00-00000","Restaurant","053-222-2222","Daegu","bb0000","0000","steakhouse",true,true,"Enterprise");
        enterprise2=new EnterpriseAccount("111-11-11111","SwimmingPool","053-333-3333","Daegu","bb1111","1111","blueswimming",true,true,"Enterprise");

        apply1=new Apply(1,individual1.getId(),enterprise1.getId(),0,null);
        apply2=new Apply(2,individual2.getId(),enterprise2.getId(),0,null);
        saveEnterDB(enterprise1);
        saveEnterDB(enterprise2);
        saveIndiDB(individual1);
        saveIndiDB(individual2);
        saveApplyDB(apply2);
        saveApplyDB(apply1);


    }

    @Test
    @DisplayName("UC5-정상")
    void saveApplyToIndividual() throws Exception {

        Apply apply=resumeBoundary.inputapply("aa1234","bb1234");
        assertEquals("aa1234",apply.getIndividualId());
        assertEquals("bb1234",apply.getEnterpriseId());


    }

    @Test
    @DisplayName("UC5-개인이 수락")
    void individualAccept() throws Exception {
        resumeBoundary.inputResult(1,true);
        ArrayList<Workhistory> arr=readWorkHistoryDB();
        Workhistory workhistory=arr.stream()
                .filter(workhistory1 -> workhistory1.getIndividualId().equals(apply1.getIndividualId())&&workhistory1.getEnterpriseId().equals(apply1.getEnterpriseId()))
                .findAny()
                .orElse(null);


        assertEquals(workhistory.getIndividualId(),apply1.getIndividualId());
        assertEquals(workhistory.getEnterpriseId(),apply1.getEnterpriseId());
        System.out.println("workhistory Individual: "+workhistory.getIndividualId());
        System.out.println("workhistory Enterprise: "+workhistory.getEnterpriseId());
    }
    @Test
    @DisplayName("UC5-개인이 거절")
    void individualNotAccept() throws Exception {
        resumeBoundary.inputResult(1,false);


    }


}