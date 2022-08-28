import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.revature.config.AppConfig;
import com.revature.service.PostsService;

public class Driver {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		PostsService postsService = applicationContext.getBean(PostsService.class);
		
		System.out.println(postsService.findPostByUserId(1));
		
		
	}
}
