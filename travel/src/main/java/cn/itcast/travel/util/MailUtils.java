package cn.itcast.travel.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {
    private static final String USER = "15139683375@163.com"; // 发件人称号，同邮箱地址
    private static final String PASSWORD = "wqs123456"; // 如果是qq邮箱可以使户端授权码，或者登录密码
    private static String  nickName = "ceshi";

    /**
     *
     * @param to 收件人邮箱
     * @param text 邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.163.com");

            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception { // 做测试用
        MailUtils.sendMail("1440035864@qq.com","入学通知","学校定于9月1号举行开学典礼");
        System.out.println("发送成功");
    }

    /**
     * 发送163Email
     *
     * @param to
     * @param title
     * @param content
     * @param type    发送邮件类型（html，text）
     * @return
     *//*
    public static Boolean send163Email(String to, String title, String content, String type) {
        //发件电子邮箱
        final String from = "wei_zeyuan@163.com";
        //发件电子邮箱授权码
        final String authorization = "wzy813595246325";

        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        properties.put("mail.smtp.auth", "true");
        try {
            //设置SSL加密
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        // 获取默认session对象
        Session session = Session.getInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, authorization);
            }
        });
        session.setDebug(true);
        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            try{
                if (nickName == null || "".equals(nickName)){
                    throw new UnsupportedEncodingException();
                } else{
                    //设置昵称
                    String nick = MimeUtility.encodeText(nickName, MimeUtility.mimeCharset("gb2312"),null);
                    message.setFrom(nick + "<" + from + ">");
                }
            }catch(UnsupportedEncodingException e){
                message.setFrom(new InternetAddress(from));
            }

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(title);
            //发送邮件格式
            if ("html".equals(type)) {
                // 设置消息体
                Multipart mainPart = new MimeMultipart();
                // 创建一个包含HTML内容的MimeBodyPart
                BodyPart html = new MimeBodyPart();
                // 设置HTML内容
                html.setContent(content, "text/html; charset=utf-8");
                mainPart.addBodyPart(html);
                // 将MiniMultipart对象设置为邮件内容
                message.setContent(mainPart);
            } else {
                message.setText(content);
            }
            message.setSentDate(new Date());
            // 发送消息
            Transport.send(message);

        } catch (MessagingException e) {
            return false;
        }
        return true;
    }*/

}
