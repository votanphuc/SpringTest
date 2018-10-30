package com.nhn.pea.musicmanager.impl;

import com.nhn.pea.musicmanager.dto.MusicDTO;
import com.nhn.pea.musicmanager.mapper.MusicMapper;
import com.nhn.pea.musicmanager.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<MusicDTO> getAll() {
        return musicMapper.getAll();
    }

    @Override
    public MusicDTO getSong(int id) {
        return musicMapper.getSong(id);
    }

    @Override
    public boolean save(MusicDTO song) {
        return musicMapper.save(song);
    }

    @Override
    public boolean delete(int id) {
        return musicMapper.delete(id);
    }

//    @Override
//    public boolean multiDelete(int[] ids){
//        return musicMapper.multiDelete(ids);
//    }

    @Override
    public MusicDTO upload(MusicDTO song) {
        musicMapper.upload(song);
        return song;
    }

    @Override
    public List<MusicDTO> search(String name) {
        return musicMapper.search(name);
    }


}
