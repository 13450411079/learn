package com.ssb.mysrpingboot01;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MySrpingBoot01ApplicationTests {

    @Test
    void contextLoads() {
    }


        @Autowired
        CuratorFramework curatorFramework;

        /**
         * 创建节点
         *
         * @throws Exception
         */
        @Test
        void createNode() throws Exception {
            // 添加持久节点
            String path="/curator-node/1";
            Stat stat = curatorFramework.checkExists().forPath(path);
            if(stat!=null){
                curatorFramework.delete().deletingChildrenIfNeeded().forPath(path);
            }
            curatorFramework.create().creatingParentsIfNeeded().forPath(path);
            System.out.println(String.format("curator create node :%s successfully.", path));

            // 添加临时序号节点,并赋值数据
            String path1 = curatorFramework.create()
                    .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                    .forPath(path, "some-data".getBytes());
            System.out.println(String.format("curator create node :%s successfully.", path));
            addNodeListener2(path);
            Thread.sleep(1000);
            curatorFramework.delete().deletingChildrenIfNeeded().forPath(path);
            // System.in.read()目的是阻塞客户端关闭，我们可以在这期间查看zk的临时序号节点
            // 当程序结束时候也就是客户端关闭的时候，临时序号节点会消失
            System.in.read();
        }

    @Test
    public void addNodeListener(String s) throws Exception {

        NodeCache nodeCache = new NodeCache(curatorFramework, s);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("{} path nodeChanged: "+ "/test");

            }
        });
        nodeCache.start();
        // 阻塞线程
//        System.in.read();
    }

    public void addNodeListener2(String patch) throws Exception{
        CuratorCache cache = CuratorCache.build(curatorFramework, patch,
                CuratorCache.Options.SINGLE_NODE_CACHE);
        cache.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData childData, ChildData childData1) {
                System.out.println(type);
            }
        });
        cache.start();
    }


        /**
         * 获取节点
         *
         * @throws Exception
         */
        @Test
        public void testGetData() throws Exception {
            // 在上面的方法执行后，创建了curator-node节点，但是我们并没有显示的去赋值
            // 通过这个方法去获取节点的值会发现，当我们通过Java客户端创建节点不赋值的话默认就是存储的创建节点的ip
            byte[] bytes = curatorFramework.getData().forPath("/curator-node");
            System.out.println(new String(bytes));
        }

        /**
         * 修改节点数据
         *
         * @throws Exception
         */
        @Test
        public void testSetData() throws Exception {
            curatorFramework.setData().forPath("/curator-node", "changed!".getBytes());
            byte[] bytes = curatorFramework.getData().forPath("/curator-node");
            System.out.println(new String(bytes));
        }

        /**
         * 创建节点同时创建⽗节点
         *
         * @throws Exception
         */
        @Test
        public void testCreateWithParent() throws Exception {
            String pathWithParent = "/node-parent/sub-node-1";
            String path = curatorFramework.create().creatingParentsIfNeeded().forPath(pathWithParent);
            System.out.println(String.format("curator create node :%s successfully.", path));
        }

        /**
         * 删除节点(包含子节点)
         *
         * @throws Exception
         */
        @Test
        public void testDelete() throws Exception {
            String pathWithParent = "/node-parent";
            curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath(pathWithParent);
        }

}

