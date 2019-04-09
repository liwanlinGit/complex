package www.forest.org;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("www.forest.org.system.mapper")
public class ApplicationSystemService{
    public static void main( String[] args ){
    	SpringApplication.run(ApplicationSystemService.class, args);
    }
}
