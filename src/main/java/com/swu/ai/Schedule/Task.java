package com.swu.ai.Schedule;

import com.swu.ai.Util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * -------------------------------------------------
 *
 * @ Author  :       彭健彪
 * @ date    :       2019/3/2 22:02
 * @ IDE     :       PyCharm
 * @ GitHub  :       https://github.com/JackyPJB
 * @ Contact :       pengjianbiao@hotmail.com
 * -------------------------------------------------
 * Description :
 * -------------------------------------------------
 */

@Component
public class Task {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final RedisUtil redis;

    @Autowired
    public Task(RedisUtil redisUtil) {
        this.redis = redisUtil;
    }

    /**
     * @ Scheduled的几种用法
     * @ Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @ Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @ Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @ Scheduled(cron="* / 5*****") ：通过cron表达式定义规则 *注意，这里的时间，单位是毫秒，1秒=1000毫秒
     */
    @Scheduled(fixedRate = 10000)
    public void logTime() {
        logger.info("定时任务，现在时间：" + System.currentTimeMillis());
        //存到redis数据库  已经存在就更新token  key值是根据固定字符串+id唯一确定的
        String USER_REDIS_SESSION = "USER_REDIS_SESSION";
        redis.set(USER_REDIS_SESSION + ":" + "user", String.valueOf(System.currentTimeMillis()), 1000 * 60 * 30);//30分钟
    }

    @Scheduled(fixedRate = 20000)
    public void logTime2() {
        String USER_REDIS_SESSION = "USER_REDIS_SESSION";
        logger.info("定时任务，获取redis的值：" + redis.get(USER_REDIS_SESSION + ":" + "user"));
    }
}
