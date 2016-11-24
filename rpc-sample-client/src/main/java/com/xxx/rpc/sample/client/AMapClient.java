package com.xxx.rpc.sample.client;

import com.xxx.rpc.client.RpcProxy;
import com.xxx.rpc.sample.api.AMapService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by MK33 on 2016/11/23.
 */
public class AMapClient {

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);
        AMapService aMapService = rpcProxy.create(AMapService.class);
        String result = aMapService.request("http://restapi.amap.com/v3/geocode/geo?key=02ea79be41a433373fc8708a00a2c0fa&address=北京市朝阳区阜通东大街6号");
        System.out.println(result);


    }
}
