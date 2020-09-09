package itf;

import model.M_AC;

public interface IM_AC
{
    public void add(int acno,int mno);
    public void delete(M_AC mac);
    public void update(int col,String s);
}
