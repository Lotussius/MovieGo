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
        if(User.currUser.uno!=0) //非0号管理员无法更改员工信息
            throw new BaseException("you aren't allowed to modify staff table.");
    }
}
