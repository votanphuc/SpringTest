package com.nhn.pea.musicmanager.controller;

import com.nhn.pea.musicmanager.dto.MusicDTO;
import com.nhn.pea.musicmanager.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class MusicControllerThymeleaf {

    @Autowired
    private MusicService musicService;

    @GetMapping({"/", "/index"})
    public String listMusics(Model model) {
        model.addAttribute("musics", musicService.getAll());
        return "index";
    }

    @GetMapping("/detail/{id}") //old
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("song", musicService.getSong(id));
        return "detail";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("song", musicService.getSong(id));
        return "edit";
    }

    @PostMapping("/save")
    public String edit(@RequestParam("name") String name, @RequestParam("genre") String genre, @RequestParam("id") Integer id) {
        MusicDTO song = new MusicDTO(id, name, genre, "");
        musicService.save(song);
        return "redirect:detail/" + id;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        musicService.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/doUpload")
    public String doUpload(@RequestParam("file") MultipartFile file,
                           @RequestParam("name") String name,
                           @RequestParam("genre") String genre) throws IOException {
        if (file.isEmpty()) {
            //TODO: check file upload missing
        }

        String link = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\" + file.getOriginalFilename();
        File convFile = new File(link);
        file.transferTo(convFile);
        MusicDTO song = new MusicDTO(null, name, genre, "/upload/" + file.getOriginalFilename());
        musicService.upload(song);
        return "redirect:/index";
    }

    @GetMapping("/find")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("musics", musicService.search("%"+name+"%"));
        return "index";
    }
}