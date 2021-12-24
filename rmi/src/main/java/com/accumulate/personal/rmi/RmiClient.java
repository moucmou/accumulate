package com.accumulate.personal.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RmiClient
 *
 * @author zhutao
 * @date 2021/12/14 3:14 下午
 */
public class RmiClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        // 连接到服务器localhost，端口1099:
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // 查找名称为"WorldClock"的服务并强制转型为WorldClock接口:
        registry.lookup("evil");
        // 正常调用接口方法:
        System.out.println();
    }

}
