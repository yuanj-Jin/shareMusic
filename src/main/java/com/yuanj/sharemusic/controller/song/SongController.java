package com.yuanj.sharemusic.controller.song;

import com.yuanj.sharemusic.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

    @RequestMapping("query")
    @ResponseBody
    public String query(){
        return songService.querySongs();
    }
}
