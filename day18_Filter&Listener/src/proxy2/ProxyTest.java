package proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo=new Lenovo();
        SaleComputer proxy_sale= (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                double price = 0;
                if (args!=null&&args.length>0){
                    price = (double) args[0];
                    price*=1.05;
                }

                if (method.getName().equals("sale")){
                    System.out.println("专车接站");
                    String obj = (String) method.invoke(lenovo, price);
                    System.out.println("送您回家");
                    return obj+",耳机和机械键盘";
                }else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });
        String sale = proxy_sale.sale(8000);
        System.out.println(sale);
        System.out.println("--------------");
        proxy_sale.show();
    }
}
