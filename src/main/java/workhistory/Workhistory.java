package workhistory;

import account.EnterpriseAccount;
import account.IndividualAccount;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.ArrayList;

public class Workhistory {

    public ArrayList<Workhistory> workhistoryList=new ArrayList<>();
    private String enterpriseId;
    private String individualId;

    //account가 이미 history를 들고 있는데 individual 객체를 굳이 가지고 있어야하나? ->ㅇㅇ imgurl이랑 post 생각해보면됨
    public Workhistory(String enterpriseId,String individualId)
    {
        this.enterpriseId=enterpriseId;
        this.individualId=individualId;
    }







    //getter,setter

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }



}