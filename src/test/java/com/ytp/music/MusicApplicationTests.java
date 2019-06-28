package com.ytp.music;

import com.ytp.music.dao.UserDao;
import com.ytp.music.entity.local.UserDO;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    public void contextLoads() {

        for (int i = 0; i < 2; i++) {
            String uid = UUID.randomUUID().toString().replace("-", "");
            System.out.println(uid);
        }
    }

    @Test
    public void testSql() {
        Date date = new Date();
        String time = DateFormatUtils.format(date, "yyyy年MM月");

        try {
            Date date1 = DateUtils.parseDate("2019-05", "yyyy-MM");
            Date date2 = DateUtils.parseDate("2019-04-15", "yyyy-MM-dd");
            System.out.println(date1.getTime()>date2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
