import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author shuo.wang
 * @date 19-8-15
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(Config.class);
        User user=(User)applicationContext.getBean("user1dfw3");
        User user2=(User)applicationContext.getBean("user2");
        System.out.println(user);
        System.out.println(user2);
        String[] beanNames=applicationContext.getBeanNamesForType(User.class);
        Arrays.stream(beanNames).forEach((name)-> System.out.println(name));

        User user3=(User)applicationContext.getBean("user");
        System.out.println(user3);
    }
}
