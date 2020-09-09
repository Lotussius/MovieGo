package itf;

import model.Staff;
import util.BaseException;

public interface IStaff
{
    public void add(int sno);
    public void delete(Staff s);
    public void update(int col,String s) throws BaseException;
}
