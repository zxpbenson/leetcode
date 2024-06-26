package com.benson.note.leetcode.zktest;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper("127.0.0.1:2181", 1000, null);
            List<Op> opl = new ArrayList<Op>();
            opl.add(Op.check("/givenchy", 0));
            //opl.add(Op.create("/givenchy", "master".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
            opl.add(Op.create("/givenchy/", "localhost".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL));
            List<OpResult> orl = zk.multi(opl);
            for(OpResult or : orl){
                System.out.println(or.getClass().getName());
            }
            List<String> childs = zk.getChildren("/", null);
            for (String child : childs) {
                System.out.println(child);
            }
            //String createResult = zk.create("/givenchy", "master".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //System.out.println("createResult : " + createResult);
            Thread.sleep(20000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } finally {
            if (zk != null) {
                try {
                    zk.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
