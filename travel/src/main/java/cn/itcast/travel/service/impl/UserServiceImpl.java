package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public boolean regist(User user) {
        User u = dao.findByUsername(user.getUsername());
        if (u!=null){
            //用户名存在
            return false;
        }
        //保存用户信息
        //设置激活码,唯一字符串
        user.setCode(UuidUtil.getUuid());
        //设置激活状态
        user.setStatus("N");
        dao.save(user);
        //激活邮件发送
        String content="<a href='http://localhost:8080/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活通知");

        return true;
    }

    @Override
    public boolean active(String code) {
        //查找对应激活码的用户是否存在
        User user=dao.findByCode(code);
        if (user!=null){
            //修改用户激活状态
            dao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
