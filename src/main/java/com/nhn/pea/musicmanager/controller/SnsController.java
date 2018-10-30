package com.nhn.pea.musicmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sns")
public class SnsController {

    @RequestMapping(value = "/line", method = RequestMethod.GET)
    public String lineIndex(Model model) {
        String channelId = "1618167622";
        String encodedCallbackUrl = "index";
        String state = "123abc"; //gen by app
        String scope = "123abc"; //gen by app
        String nonce = "123abc"; //gen by app
        String url = "https://access.line.me/dialog/oauth/weblogin?response_type=code&"
                + "&client_id=" + channelId
                + "&redirect_uri=" + encodedCallbackUrl
                + "&state=" + state;
        return "redirect:" + url;
    }
}
