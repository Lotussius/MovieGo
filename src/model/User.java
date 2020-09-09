package model;

public class User
{
    public static User currUser;

    public static final String[] tableTitles={"uno","uname","usex","upwd","utel"};

    public int uno,usex,utel;
    public String uname,upwd;

    public User(int uno,String uname,int usex,String upwd,int utel)
    {
        this.uno=uno;
        this.uname=uname;
        this.usex=usex;
        this.upwd=upwd;
        this.utel=utel;
    }

    public String getCell(int j)
    {
        if(j==0) return String.valueOf(uno);
        else if(j==1) return uname;
        else if(j==2) return usex==1?"male":"female";
        else if(j==3) return upwd;
        else if(j==4) return String.valueOf(utel);
        else return "";
    }
}
