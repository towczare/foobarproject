package pl.sda.foobarproject;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImageStorageService {

    private final CloudinaryService cloudinaryService;
    private Map<String, Image> imageStorage;

    public ImageStorageService(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
        this.imageStorage = new HashMap<>();
    }

    public Image uploadImage(UploadImage upload) {
        String urlToFile = cloudinaryService.uploadFile(upload.getFile());
        Image image = upload.toImage(urlToFile);
        imageStorage.put(UUID.randomUUID().toString(), image);
        return image;
    }

    public Collection<Image> getImages() {
        return imageStorage.values();
    }
}
