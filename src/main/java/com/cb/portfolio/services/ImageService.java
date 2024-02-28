package com.cb.portfolio.services;

import com.cb.portfolio.entities.Image;

import java.util.List;

public interface ImageService {
    public Image saveImage(Image image);
    public Image getImage(Long id);
    public void deleteImage(Long id);
    public Image updateImage(Image image);
public List<Image> getImages();

}
