package com.lantaiyuan.ebus.zookeeper;

import com.lantaiyuan.ebus.constants.BasicConstans;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.curator.RetryPolicy;


@Configuration
public class ZookeeperClientConfiguration {

    private static  final Logger logger = LoggerFactory.getLogger(ZookeeperClientConfiguration.class);

    // 系统名
    @Value("${system.name}")
    private String systemName;

    // zookeeper集群服务器地址
    @Value("${zookeeper.serverPaths}")
    private String serverPaths;

    // 间隔时间
    @Value("${zookeeper.curator.baseSleepTimeMs}")
    private int baseSleepTimeMs;

    // 最大重试次数
    @Value("${zookeeper.curator.maxRetries}")
    private int maxRetries;

    /**
     * 创建ZK连接
     */
    @Bean
    public CuratorFramework curatorFramework() throws Exception{
        // 操作失败重试机制 1000毫秒间隔 重试3次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(baseSleepTimeMs, maxRetries);
        // 创建Curator客户端
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(serverPaths,retryPolicy);
        // 启动客户端
        curatorFramework.start();
        String node1 = BasicConstans.LOCK_PATH_PREFIX + "1" + systemName;
        String node2 = BasicConstans.LOCK_PATH_PREFIX + "2" + systemName;
        ZKClientUtils zkClientUtils = new ZKClientUtils(curatorFramework);
        // 判断锁的父节点是否存在,不存在则自动创建父节点
        try {
            if(curatorFramework.checkExists().forPath(node1) == null ){
                zkClientUtils.createNode(node1,CreateMode.PERSISTENT, BasicConstans.LOCK_PATH_INIT_DATA);
            }
            if(curatorFramework.checkExists().forPath(node2) == null){
                zkClientUtils.createNode(node2,CreateMode.PERSISTENT, BasicConstans.LOCK_PATH_INIT_DATA);
            }
            logger.info("Zookeeper connection init success!");
        }catch (Exception e){
                throw new Exception("Zookeeper connection init fail!", e);
        }
        return curatorFramework;
    }

    /**
     * 创建分布式锁1
     */
    @Bean
    public InterProcessMutex lock1() throws Exception{
        String node1 = BasicConstans.LOCK_PATH_PREFIX + "1" + systemName;
        CuratorFramework curatorFramework = curatorFramework();
        InterProcessMutex lock1 = new InterProcessMutex(curatorFramework, node1);
        return lock1;
    }

    /**
     * 创建分布式锁2
     */
    @Bean
    public InterProcessMutex lock2() throws Exception{
        String node1 = BasicConstans.LOCK_PATH_PREFIX + "2" + systemName;
        CuratorFramework curatorFramework = curatorFramework();
        InterProcessMutex lock1 = new InterProcessMutex(curatorFramework, node1);
        return lock1;
    }

}

