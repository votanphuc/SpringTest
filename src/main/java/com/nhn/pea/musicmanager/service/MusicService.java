package com.nhn.pea.musicmanager.service;

import com.nhn.pea.musicmanager.dto.MusicDTO;

import java.util.List;

public interface MusicService {
    List<MusicDTO> getAll();

    MusicDTO getSong(int id);

    boolean save(MusicDTO song);

    boolean delete(int id);

//    boolean multiDelete(int[] ids);

    MusicDTO upload(MusicDTO song);

    List<MusicDTO> search(String name);

}
