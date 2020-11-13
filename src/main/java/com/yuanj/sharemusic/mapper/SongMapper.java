package com.yuanj.sharemusic.mapper;

import com.yuanj.sharemusic.bean.SongVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SongMapper {
    List<SongVO> querySongs();
}
