package com.cb.portfolio.services.Impl;

import com.cb.portfolio.entities.Image;
import com.cb.portfolio.repositories.ImageRepository;
import com.cb.portfolio.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public Image saveImage(Image image) {
        return this.imageRepository.save(image);
    }

    @Override
    public Image getImage(Long id) {
        return null;
    }

    @Override
    public void deleteImage(Long id) {

    }

    @Override
    public Image updateImage(Image image) {
        return null;
    }

    @Override
    public List<Image> getImages() {
        return this.imageRepository.findAll();
    }
}
