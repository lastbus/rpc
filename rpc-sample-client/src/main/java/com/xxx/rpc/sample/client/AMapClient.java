package com.xxx.rpc.sample.client;

import com.xxx.rpc.client.RpcProxy;
import com.xxx.rpc.sample.api.AMapService;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * Created by MK33 on 2016/11/23.
 */
public class AMapClient {

    public static void main(String[] args) throws IOException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        RpcProxy rpcProxy = context.getBean(RpcProxy.class);
//        AMapService aMapService = rpcProxy.create(AMapService.class);
//        String result = aMapService.request("http://restapi.amap.com/v3/geocode/geo?key=02ea79be41a433373fc8708a00a2c0fa&address=北京市朝阳区阜通东大街6号");
//        System.out.println(result);

        ZkClient zk = new ZkClient("10.201.129.79:2181");
        String root = "/registry";
        List<String> child = zk.getChildren(root);
        println(zk.readData(root));
        for (String l : child) {
            System.out.println(l);
            String path = root + "/" + l;
            System.out.println(zk.getChildren(path));
            println(zk.readData(path + "/" + zk.getChildren(path).get(0)));
        }


    }

    public static void println(Object o) {
        System.out.println(o);
    }
}
