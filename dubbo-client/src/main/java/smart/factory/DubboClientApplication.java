package smart.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import smart.factory.dubbo.CityConsumerService;

@SpringBootApplication
public class DubboClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DubboClientApplication.class, args);
		CityConsumerService cityService = run.getBean(CityConsumerService.class);
		cityService.printCity();
	}
}
