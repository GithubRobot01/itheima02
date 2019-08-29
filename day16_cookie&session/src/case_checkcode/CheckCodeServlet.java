package case_checkcode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //图片大小
        int width=100;
        int height=50;
        //创建对象,验证码图片对象
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //美化图片
        //填充背景色
        Graphics g = image.getGraphics(); //画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0,0,width,height); //在范围内填充颜色
        //画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        //写验证码
        String s="ABCDEFGHIJKLMNOPLRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index=r.nextInt(s.length());
            String ch= String.valueOf(s.charAt(index));
            sb.append(ch);
            g.drawString(ch,(10+25*i),25);
        }

        //将验证码信息存入session
        request.getSession().setAttribute("yzm",sb.toString());

        //画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1=r.nextInt(width);
            int x2=r.nextInt(width);
            int y1=r.nextInt(height);
            int y2=r.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
