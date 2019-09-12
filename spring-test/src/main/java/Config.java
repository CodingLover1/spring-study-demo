import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author shuo.wang
 * @date 19-8-15
 */

@Configuration
public class Config {

    @Bean
    public User user1dfw3(){
        return new User("a");
    }


    @Bean
    @Qualifier("user")
    public User user2(){
        return new User("b");
    }
}
