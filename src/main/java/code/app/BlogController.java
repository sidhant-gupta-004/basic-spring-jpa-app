package code.app;

import java.util.List;
import java.util.Map;

import code.database.BlogRepository;
import code.service.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping("/")
    public String index() {

        return "Hello there!\n";
    }

    @GetMapping("/blog")
    public List<Blog> show() {

        return blogRepository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Blog showOne (@PathVariable String id) {

        int blogId = Integer.parseInt(id);
        return blogRepository.findOne(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search (@RequestBody Map<String, String> body) {

        String search = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(search, search);
    }

    @PostMapping("/blog/{id}")
    public Blog add (@PathVariable String id, @RequestBody Map<String, String> body) {

        int newId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");

        return blogRepository.save (new Blog(newId, title, content));
    }

    @PutMapping("/blog/{id}")
    public Blog update (@PathVariable String id, @RequestBody Map<String, String> body) {

        int updateId = Integer.parseInt(id);
        Blog updatedBlog = blogRepository.findOne(updateId);

        String title = body.get("title");
        String content = body.get("content");

        return blogRepository.save(updatedBlog);
    }

    @DeleteMapping("/blog/{id}")
    public boolean delete (@PathVariable String id) {

        int deleteId = Integer.parseInt(id);

        blogRepository.delete(deleteId);

        return true;
    }
}
