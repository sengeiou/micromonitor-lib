package com.metao.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

    private static final Logger log = LoggerFactory.getLogger(ClientApplication.class);

    private final Environment env;

    public ClientApplication(Environment env) {
        this.env = env;
    }

    /**
     * Initializes micromonitor-client.
     * <p>
     * Spring profiles can be configured with a program argument --spring.profiles.active=your-active-profile
     * <p>
     * You can find more information on how profiles work with MicroMonitor on <a href="https://www.micromonitor.tech/profiles/">https://www.micromonitor.tech/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(MicroMonitorConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(MicroMonitorConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run " +
                    "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(MicroMonitorConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(MicroMonitorConstants.SPRING_PROFILE_CLOUD)) {
            log.error("You have misconfigured your application! It should not " +
                    "run with both the 'dev' and 'cloud' profiles at the same time.");
        }
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClientApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        app.run(args).getEnvironment();
    }
}
