package transmatter.project.security.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent>  {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

    }
}
