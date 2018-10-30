package com.nhn.pea.musicmanager.mapper;

import com.nhn.pea.musicmanager.dto.MusicDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MusicMapper {
    @Select("select * from music")
    List<MusicDTO> getAll();

    @Select("select * from music where id = #{id}")
    MusicDTO getSong(int id);

    @Update("update music set name = #{name}, genre = #{genre}, lastUpdate = now() where id = #{id}")
    boolean save(MusicDTO song);

    @Delete("delete from music where id = #{id}")
    boolean delete(int id);

//    @Delete("delete from music where id=ANY(#{ids, jdbcType=ARRAY})")
//    boolean multiDelete(@Param("ids") int[] ids);

    @Insert("insert into music( name, genre, link, lastUpdate ) value( #{name}, #{genre}, #{link}, now()) ")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int upload(MusicDTO song);

    @Select("select * from music where name like #{name} ")
    List<MusicDTO> search(String name);

}
