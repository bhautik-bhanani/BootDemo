package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.GalleryRepository;
import com.example.demo.service.FileStorageService;
import com.example.demo.service.UploadFileResponse;

@RestController
public class PageController {
	
	@Autowired
	GalleryRepository galleryRepository;
	@Autowired
    private FileStorageService fileStorageService;
	
	@RequestMapping(value= {"/", "/home"},method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@PostMapping(value="/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("name") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
		return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
	}
	
	
}
