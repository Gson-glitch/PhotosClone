package com.gson.photosclone.web;

import com.gson.photosclone.model.Photo;
import com.gson.photosclone.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {
    private final PhotoService photoService;

    public PhotozController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping("/")
    public ModelAndView homepage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("upload.html");
        return modelAndView;
//        return "Hello, World!";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable  Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable  Integer id) {
        photoService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(),  file.getBytes());
    }
}
