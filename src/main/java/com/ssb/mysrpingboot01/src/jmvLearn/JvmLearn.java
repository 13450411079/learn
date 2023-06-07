package com.ssb.mysrpingboot01.src.jmvLearn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;

public class JvmLearn {
    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity(10, "hi daddy", false, new HashMap() {{
            put("String", "abc");
        }}, 123l);

        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (testEntity) {
                    Thread.sleep(10000);
                }
            }
        });
        t1.start();
        String toPrintable = ClassLayout.parseInstance(testEntity).toPrintable();
        System.out.println(toPrintable);
    }

}



@Data
@AllArgsConstructor
class TestEntity {
    private Integer head;
    private String body;
    private Boolean detail;
    private HashMap<String, String> data;
    private Long tail;
}
