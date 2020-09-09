package itf;

import model.User;
import util.BaseException;
import util.DbException;

public interface IUser
{
    public void add(int uno) throws BaseException;
    public void delete(User u) throws BaseException;
    public void update(int col,String s) throws BaseException;
    public void alter_pwd(String old,String new1,String new2) throws BaseException;

}
