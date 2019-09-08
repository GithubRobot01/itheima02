package proxy2;

public class Lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("电脑售价"+money+"元");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("顾客看电脑");
    }
}
