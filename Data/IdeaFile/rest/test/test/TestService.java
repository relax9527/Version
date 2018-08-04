package test;

import com.xushouwei.bean.Page;
import com.xushouwei.bean.User;
import com.xushouwei.dao.UserDao;
import com.xushouwei.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/7/23.
 */
public class TestService {
    Logger logger = Logger.getLogger("test.TestService");
    private static UserService service;
    private static UserDao commonDao;


   @Before
    public void init() {
        ApplicationContext
                context = new ClassPathXmlApplicationContext("spring.xml");
        commonDao = (UserDao) context.getBean("commonDao");
       service = (UserService) context.getBean("userService");
    }

    @Test
    public void testGetAcccountById() throws Exception {
        ApplicationContext
                context = new ClassPathXmlApplicationContext("spring.xml");
        //commonDao = (CommonDao)context.getBean("commonDao");
        //service = (Service) context.getBean("service");
//        String i="1";
//       // System.out.println("ceshi:++++" + service.validate());
//        System.out.println("++++"+commonDao.getUserByName("test"));
        User user = new User();
        user.setUsername("rcc");
        user.setPassword("123");
       // commonDao.insertUser(user);
    }
    @Test
    public  void  testService(){
        User user = new User();
        user.setUsername("test23");
        user.setPassword("test");
        service.insertUser(user);
    }
    @Test
    public void testList(){
        Page page = new Page(0,3,2,1);
       List<User> list=service.selectAllUser(page);
       System.out.println(list.size());
    }
    @Test
    public  void  testById(){
        System.out.println("++++++++++++"+service.findUserById(8));

    }
    @Test
    public  void testSelect(){
        logger.info("+++"+commonDao.select(""));
    }
}