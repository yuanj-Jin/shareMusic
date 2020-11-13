package com.yuanj.sharemusic.service.song.impl;

import com.google.gson.Gson;
import com.yuanj.sharemusic.mapper.SongMapper;
import com.yuanj.sharemusic.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongMapper songMapper;
    @Autowired
    Gson gson;
    @Override
    public String querySongs() {
        List result=songMapper.querySongs();
        return gson.toJson(result);
    }
}
