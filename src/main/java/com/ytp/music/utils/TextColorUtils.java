package com.ytp.music.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ytp
 * @date 2020/12/19
 */
@Slf4j
@Component
public class TextColorUtils {

    public static void main(String[] args) {
        System.out.print("\u001b[30m A \u001b[31m B \u001b[32m C \u001b[33m D \u001b[0m");
        System.out.print("\u001b[34m E \u001b[35m F \u001b[36m G \u001b[37m H \u001b[0m");
        System.out.print("\u001b[30;1m A \u001b[31;1m B \u001b[32;1m C \u001b[33;1m D \u001b[0m");
        System.out.print("\u001b[34;1m E \u001b[35;1m F \u001b[36;1m G \u001b[37;1m H \u001b[0m");

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int code = i * 16 + j;
                System.out.printf("\u001b[38;5;%dm%-4d", code, code);
            }
            System.out.println("\u001b[0m");
        }
        System.out.println("\u001b[7m./src/views/command/detail/ServiceCommandDetail.js\u001b[27m");
    }
}
