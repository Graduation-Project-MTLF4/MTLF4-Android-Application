package amirahmed.com.mtlf4androidapplication.Models;


public class ShopItem {

    public String name;
    public int pic;
    public String number;

    public ShopItem(String name,int pic,String number)
    {
        this.name=name;
        this.pic=pic;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
