package com.ytp.music.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ytp
 */
public class ProvinceConstant {

    private static final Map<Integer, String> P_MAP = new HashMap<>(16);

    static {
        P_MAP.put(110000, "北京");
        P_MAP.put(120000, "天津");
        P_MAP.put(130000, "河北");
        P_MAP.put(140000, "山西");
        P_MAP.put(150000, "内蒙");

        P_MAP.put(210000, "辽宁");
        P_MAP.put(220000, "吉林");
        P_MAP.put(230000, "黑龙江");
        P_MAP.put(310000, "上海");
        P_MAP.put(320000, "江苏");

        P_MAP.put(330000, "浙江");
        P_MAP.put(340000, "安徽");
        P_MAP.put(350000, "福建");
        P_MAP.put(360000, "江西");
        P_MAP.put(370000, "山东");

        P_MAP.put(410000, "河南");
        P_MAP.put(420000, "湖北");
        P_MAP.put(430000, "湖南");
        P_MAP.put(440000, "广东");
        P_MAP.put(450000, "广西");

        P_MAP.put(460000, "海南");
        P_MAP.put(500000, "重庆");
        P_MAP.put(510000, "四川");
        P_MAP.put(520000, "贵州");
        P_MAP.put(530000, "云南");

        P_MAP.put(540000, "西藏");
        P_MAP.put(610000, "陕西");
        P_MAP.put(620000, "甘肃");
        P_MAP.put(630000, "青海");
        P_MAP.put(640000, "宁夏");

        P_MAP.put(650000, "新疆");
        P_MAP.put(710000, "台湾");
        P_MAP.put(810000, "香港");
        P_MAP.put(820000, "澳门");
        P_MAP.put(990000, "海外");
    }

    public static String getValue(Integer id) {
        return P_MAP.get(id);
    }

}
