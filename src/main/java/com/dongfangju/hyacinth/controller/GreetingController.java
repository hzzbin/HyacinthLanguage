package com.dongfangju.hyacinth.controller;

import com.dongfangju.hyacinth.entity.Greeting;
import com.dongfangju.hyacinth.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        // 模拟后端异步处理消息延迟
        Thread.sleep(1000);

        return new Greeting("Hello" + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
