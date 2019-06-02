package code.data;

import code.service.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogData {

    private List<Blog> blogs;

    private static BlogData instance = null;

    public static BlogData getInstance() {

        if (instance == null) {

            instance = new BlogData();
        }

        return instance;
    }

    public BlogData() {

        blogs = new ArrayList<Blog>();

        blogs.add(new Blog(1, "A", "AAAA"));
        blogs.add(new Blog(2, "B", "BBBB"));
        blogs.add(new Blog(3, "C", "CCCC"));
    }

    public List<Blog> getBlogs() {

        return blogs;
    }

    public Blog getBlogById (int id) {

        for (Blog b: blogs) {

            if (b.getId() == id) {

                return b;
            }
        }
        return null;
    }

    public List<Blog> searchBlogs (String searchTerm) {

        List <Blog> searchedBlogs = new ArrayList<Blog>();

        for (Blog b: blogs) {

            if (b.getContent().contains(searchTerm)) {

                searchedBlogs.add(b);
            }
        }

        return searchedBlogs;
    }

    public Blog createBlog (int id, String title, String content) {

        Blog newBlog = new Blog(id, title, content);
        blogs.add(newBlog);

        return newBlog;
    }

    public Blog updateBlog (int id, String title, String content) {

        for (Blog b: blogs) {

            if (b.getId() == id) {
                b.setTitle(title);
                b.setContent(content);

                return b;
            }
        }

        return null;
    }

    public boolean deleteBlog (int id) {

        int deleteIndex = -1;

        for (Blog b: blogs) {

            if (b.getId() == id) {

                deleteIndex = blogs.indexOf(b);
            }
        }

        if (deleteIndex != -1) {

            blogs.remove(deleteIndex);
            return true;
        }

        else {

            return false;
        }
    }

}
