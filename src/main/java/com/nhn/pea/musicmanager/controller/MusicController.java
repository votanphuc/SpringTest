package com.nhn.pea.musicmanager.controller;

import com.nhn.pea.musicmanager.ResponseJSON;
import com.nhn.pea.musicmanager.dto.MusicDTO;
import com.nhn.pea.musicmanager.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/song")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping({"", "/"})
    public ResponseJSON<List<MusicDTO>> getAll() {
        ResponseJSON<List<MusicDTO>> response;
        List<MusicDTO> musicsResult = musicService.getAll();
        if (musicsResult.isEmpty()) {
            response = new ResponseJSON<>(HttpStatus.NOT_FOUND, "Fail!", null);
            return response;
        }
        response = new ResponseJSON<>(musicsResult);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseJSON<MusicDTO> detail(@PathVariable("id") int id) {
        ResponseJSON<MusicDTO> response;
        MusicDTO musicResult = musicService.getSong(id);
        if (musicResult.equals(null)) {
            response = new ResponseJSON<>(HttpStatus.NOT_FOUND, "Fail!", null);
            return response;
        }
        response = new ResponseJSON<>(musicResult);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseJSON<MusicDTO> update(@RequestBody MusicDTO song) {
        boolean saveResult = musicService.save(song);
        ResponseJSON<MusicDTO> response;
        if (song.getName().isEmpty() || song.getGenre().isEmpty()) {
            response = new ResponseJSON<>(HttpStatus.NOT_FOUND, "Fail!", null);
            return response;
        }
        if (!saveResult) {
            response = new ResponseJSON<>(HttpStatus.FORBIDDEN, "Fail!", null);
            return response;
        }
        response = new ResponseJSON<>(musicService.getSong(song.getId()));
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseJSON<Boolean> delete(@PathVariable("id") int id) {
        ResponseJSON<Boolean> response;
        boolean deleteResult = musicService.delete(id);
        if (!deleteResult) {
            response = new ResponseJSON<>(HttpStatus.NOT_FOUND, "Fail!", Boolean.FALSE);
            return response;
        }
        response = new ResponseJSON<>(deleteResult);
        return response;
    }

//    @DeleteMapping("/m/")//@PathVariable("ids") String ids
//    public boolean multiDelete(){
//        int ids[] = {115,116,117};
//        List<Integer> idss = new ArrayList<>();
//        idss.add(115);
//        idss.add(116);
//        idss.add(117);
//        String s[] ={"100","124","111"};
//        musicService.multiDelete(ids);
//        return true;
//    }

    @PostMapping("/add")
    public ResponseJSON<MusicDTO> add(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,
                                      @RequestParam("genre") String genre) throws IOException {
        ResponseJSON<MusicDTO> response;

        if (file.isEmpty() || name.isEmpty() || genre.isEmpty()) {
            response = new ResponseJSON<>(HttpStatus.NOT_FOUND, "Fail!", null);
            return response;
        }

        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\" + file.getOriginalFilename();
        File convFile = new File(path);
        file.transferTo(convFile);

        MusicDTO song = new MusicDTO(null, name, genre, "/upload/" + file.getOriginalFilename());
        response = new ResponseJSON<>(song);
        return response;
    }

    @GetMapping("/search")
    public ResponseJSON<List<MusicDTO>> search(@RequestParam("name") String name) {
        ResponseJSON<List<MusicDTO>> response;
        String key = "%" + name + "%";
        List<MusicDTO> musicsResult = musicService.search(key);
        if (name.isEmpty() || musicsResult.isEmpty()) {
            response = new ResponseJSON<>(HttpStatus.NOT_FOUND, "Fail!", null);
            return response;
        }
        response = new ResponseJSON(musicsResult);
        return response;
    }




}