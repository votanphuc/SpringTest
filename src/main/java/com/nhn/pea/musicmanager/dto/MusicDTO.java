package com.nhn.pea.musicmanager.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MusicDTO {
    private Integer id;
    private String name;
    private String genre;
    private String link;
    private Date lastUpdate;

    public MusicDTO(Integer id, String name, String genre, String link) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
