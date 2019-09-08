package pl.sda.foobarproject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageStorageController {

    private final ImageStorageService imageStorageService;

    public ImageStorageController(ImageStorageService imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("images", imageStorageService.getImages());
        return "images";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        imageStorageService.uploadImage(new UploadImage(file, file.getOriginalFilename()));
        return "redirect:/";
    }
}
