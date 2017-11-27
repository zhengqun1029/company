package com.lantaiyuan.ebus.zookeeper;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.CreateMode;

import java.util.List;

import java.util.concurrent.TimeUnit;

/**
 * zookeeper操作工具类
 * by zhenghanbin
 * create time: 2017-10-13
 */
public class ZKClientUtils {

    private CuratorFramework newClient;

    public ZKClientUtils(CuratorFramework curatorFramework) {
        this.newClient = curatorFramework;
    }

    /**
     * 创建数据节点
     *
     * @param path       节点路径
     * @param createMode 节点类型，类型有：
     *                   1.CreateMode.PERSISTENT: 创建节点后，不删除就永久存在
     *                   2.CreateMode.PERSISTENT_SEQUENTIAL：节点path末尾会追加一个10位数的单调递增的序列
     *                   3.CreateMode.EPHEMERAL：创建后，回话结束节点会自动删除
     *                   4.CreateMode.EPHEMERAL_SEQUENTIAL：节点path末尾会追加一个10位数的单调递增的序列
     * @param data       节点数据
     */
    public void createNode(String path, CreateMode createMode, String data) throws Exception {
        newClient.create().withMode(createMode).forPath(path, data.getBytes());
    }

    /**
     * 获取节点数据
     *
     * @param path 节点路径
     * @return
     */
    public static String getData(CuratorFramework curatorFramework, String path) throws Exception {
        return new String(curatorFramework.getData().forPath(path));
    }

    /**
     * 更新节点
     *
     * @param parentNode
     * @param data
     */
    public static void updateNodeDate(CuratorFramework curatorFramework,String parentNode, String data) throws Exception {
        curatorFramework.setData().forPath(parentNode, data.getBytes());
    }

    /**
     * 删除节点
     *
     * @param path
     */
    public void deleteNode(String path) throws Exception {
        newClient.delete().forPath(path);
    }

    public static void acquire(InterProcessMutex lock, long times, TimeUnit timeUnit) throws Exception {
        lock.acquire(times, timeUnit);
    }

    /**
     * 判断是否式最后一个节点
     * @param curatorFramework  zk连接
     * @param parentNode        父节点
     * @return
     * @throws Exception
     */
    public static boolean isLastThread(CuratorFramework curatorFramework, String parentNode) throws Exception {
        List<String> nodeList = curatorFramework.getChildren().forPath(parentNode);
        if (nodeList.size() == 0) {
            return true;
        }
        return false;
    }

}
