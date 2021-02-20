package com.yuanj.sharemusic.controller.qrcode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/qr")
public class H5Controller {

    @RequestMapping(value = "/toShow",method = RequestMethod.GET)
    public String toShow(){
        return "hello";
    }

    @RequestMapping(value = "/toRote",method = RequestMethod.GET)
    public String toRote(){
        return "rote";
    }

    @RequestMapping(value = "/toConfess",method = RequestMethod.GET)
    public String toConfess(){
        return "confession";
    }
}
