package com.ytp.music.controller;

import org.jooby.Jooby;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pinge
 * @date 2020/12/13
 */
@RestController
public class JoobyController extends Jooby {

    {
        get("/", () -> "Hey Jooby!");
    }

    public static void main(final String[] args) throws Exception {
        new JoobyController().start(args);
    }
}
