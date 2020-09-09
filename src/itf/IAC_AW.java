package itf;

import model.AC_AW;

public interface IAC_AW
{
    public void add(int acno,int awno);
    public void delete(AC_AW acaw);
    public void update(int col,String s);
}
