package model;

public class U_O
{
    public static final String[] tableTitles={"ono","uno","price","grade","comment"};

    public int ono,uno,grade;
    public double price;
    public String comment;

    public U_O(int ono,int uno,double price,int grade,String comment)
    {
        this.ono=ono;
        this.uno=uno;
        this.price=price;
        this.grade=grade;
        this.comment=comment;
    }

    public String getCell(int j)
    {
        if(j==0) return String.valueOf(ono);
        else if(j==1) return String.valueOf(uno);
        else if(j==2) return String.valueOf(price);
        else if(j==3) return String.valueOf(grade);
        else if(j==4) return comment;
        else return "";
    }
}
