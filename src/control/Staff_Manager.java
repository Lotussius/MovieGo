package control;

import itf.IStaff;
import model.*;
import util.BaseException;

public class Staff_Manager implements IStaff
{
    public void add(int sno){}
    public void delete(Staff s){}
    public void update(int col,String s) throws BaseException
    {
        if(User.currUser.uno!=0) //��0�Ź���Ա�޷�����Ա����Ϣ
            throw new BaseException("you aren't allowed to modify staff table.");
    }
}
