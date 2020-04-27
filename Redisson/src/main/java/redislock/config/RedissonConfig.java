package redislock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        config.useClusterServers()
                // cluster state scan interval in milliseconds
                .setScanInterval(2000)
                .setPassword("defangchaintest")
                .addNodeAddress("redis://192.168.10.233:6379", "redis://192.168.10.233:6380",
                        "redis://192.168.10.233:6381", "redis://192.168.10.233:6382",
                        "redis://192.168.10.233:6383", "redis://192.168.10.233:6384");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}

