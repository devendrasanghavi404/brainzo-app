package com.stackroute.Producer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.Model.UserDao;
import com.stackroute.Model.UserRole;
import com.stackroute.Repository.UserAuthenticationRepository;
@RestController
public class UserProducer {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	@Autowired
	private UserAuthenticationRepository repository;
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;
	@PostMapping("/message")
	public String sendMessageToRabbitMq(@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("userRole") UserRole role) {

		UserDao userDao=new UserDao();
		userDao.setEmail(email);
		userDao.setPassword(password);
		userDao.setUserRole(role);
		repository.save(userDao);
		rabbitTemplate.convertAndSend(exchange,routingkey, userDao);
		return "Successfull";
	}
}
