package boundary;

import model.IndividualAccount;

import java.util.Scanner;

public class ResumeBoundary {
    Scanner sc=new Scanner(System.in);
    public void inputResume()
    {
        //적절한 paremeter 입력받고
        //resume 작성 합수 호출
        System.out.println("자기소개: ");
        String selfIntroduction=sc.next();
        System.out.println();

        System.out.println("경력사항: ");
        String workExperience=sc.next();
        System.out.println();

        System.out.println("공개여부: ");
        String isOpened=sc.next();
        System.out.println();
        Boolean isopen=Boolean.parseBoolean(isOpened);


        IndividualAccount individualAccount;

    }

    public void inputResult()
    {

    }

    public String message()
    {
        return null;
    }

    public void showResume()
    {

    }

}
