package com.ytp.music;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicApplicationTests {

    @Test
    public void contextLoads() {

        for (int i = 0; i < 2; i++) {
            String uid = UUID.randomUUID().toString().replace("-", "");
            System.out.println(uid);
        }
    }

}
