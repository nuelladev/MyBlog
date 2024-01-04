package com.example.MyBlog.config;





import com.example.MyBlog.models.Authority;
import com.example.MyBlog.models.Post;
import com.example.MyBlog.models.User;
import com.example.MyBlog.repositories.AuthorityRepository;
import com.example.MyBlog.services.FileService;
import com.example.MyBlog.services.PostService;
import com.example.MyBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class SampleData implements CommandLineRunner {

    @Autowired
    private FileService fileService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {

        fileService.init();

        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {

            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            User user1 = User
                    .builder()
                    .firstName("user_first")
                    .lastName("user_last")
                    .email("user.user@domain.com")
                    .password("password")
                    .build();

            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            user1.setAuthorities(authorities1);

            User user2 = User
                    .builder()
                    .firstName("admin_first")
                    .lastName("admin_last")
                    .email("admin.admin@domain.com")
                    .password("password")
                    .build();

            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);

            user2.setAuthorities(authorities2);

            userService.saveUser(user1);
            userService.saveUser(user2);

            Post post1 = Post.builder()
                    .title("What is Java Spring Boot?")
                    .body("Spring Boot is an open-source Java-based framework that simplifies the process of building and deploying production-ready applications with minimal configuration. It is part of the larger Spring Framework ecosystem and is designed to make it easy to create stand-alone, production-grade Spring-based applications.\n\n"
                            + "Here are some key features and concepts associated with Spring Boot:\n\n"
                            + "Convention over Configuration:\n\n"
                            + "Spring Boot follows the principle of convention over configuration, reducing the need for explicit configurations. It provides sensible defaults for many aspects, allowing developers to focus more on application logic than on boilerplate configuration.\n\n"
                            + "Embedded Web Servers:\n\n"
                            + "Spring Boot includes embedded web servers (such as Tomcat, Jetty, or Undertow) that allow you to run your application as a standalone JAR file. This eliminates the need for deploying your application on a separate web server.\n\n"
                            + "Auto-Configuration:\n\n"
                            + "Spring Boot employs auto-configuration to automatically configure application components based on the project's dependencies. This can significantly reduce the amount of boilerplate code needed.\n\n"
                            + "Microservices Architecture:\n\n"
                            + "Spring Boot is well-suited for building microservices-based architectures. It provides features like Spring Cloud for building distributed systems, service discovery, and configuration management.\n\n"
                            + "Dependency Management:\n\n"
                            + "Spring Boot uses a convention-based approach for dependency management. It provides a set of starter templates that include commonly used dependencies for specific use cases, making it easy to add functionality to your application.\n\n"
                            + "Spring Boot Starters:\n\n"
                            + "Starters are pre-configured templates that help streamline the inclusion of specific dependencies and technologies into your project. For example, there are starters for web applications, data access, messaging, etc.\n\n"
                            + "Spring Boot Actuator:\n\n"
                            + "Actuator is a set of production-ready features that help monitor and manage your application. It provides endpoints for health checks, application metrics, and more.\n\n"
                            + "Spring Boot CLI:\n\n"
                            + "The Spring Boot Command-Line Interface (CLI) allows for quick development and testing of Spring Boot applications using Groovy scripts.\n\n"
                            + "In summary, Spring Boot simplifies the development of Java applications by providing a set of conventions, defaults, and tools, allowing developers to quickly build and deploy production-ready applications with minimal effort and configuration. It is widely used for building a variety of applications, including web applications, microservices, and enterprise-level systems.")
                    .imageFilePath("https://cdn.pixabay.com/photo/2021/04/19/08/26/daffodils-6190863_1280.jpg")
                    .user(user1)
                    .build();


            Post post2 = Post.builder()
                    .title("Exploring the Wonders of Nature Through Photography")
                    .body("Nature has an incredible way of captivating our hearts and inspiring awe. In this blog post, we embark on a journey to explore the wonders of the natural world through the lens of a camera.\n\n"
                            + "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Magna eget est lorem ipsum dolor sit amet consectetur adipiscing. Tempus quam pellentesque nec nam aliquam sem et tortor. Pellentesque sit amet porttitor eget. Sed augue lacus viverra vitae congue eu consequat. Ultrices vitae auctor eu augue. Mattis rhoncus urna neque viverra. Consectetur lorem donec massa sapien faucibus et molestie ac feugiat. Sociis natoque penatibus et magnis dis parturient montes nascetur. Cursus turpis massa tincidunt dui ut ornare lectus. Odio pellentesque diam volutpat commodo sed egestas egestas fringilla. Id cursus metus aliquam eleifend mi. Nibh nisl condimentum id venenatis a condimentum.\n\n"
                            + "Photography allows us to capture the fleeting moments of beauty that nature offers. From the vibrant colors of a sunrise to the delicate details of a flower petal, every shot tells a unique story. As we delve into the world of photography, we discover the art of seeing and appreciating the intricate balance of the ecosystem.\n\n"
                            + "Our journey takes us through lush forests, serene lakes, and breathtaking mountain landscapes. Each photograph serves as a visual poem, a testament to the diversity and magnificence of our planet.\n\n"
                            + "Join us in this visual adventure as we celebrate the harmony of nature and the artistry of the lens. Let these images inspire you to venture outdoors, explore the natural world, and capture your own moments of awe and wonder.\n\n"
                            + "Remember, every photograph is a story waiting to be told, and nature is the most eloquent storyteller of them all.")
                    .user(user2)
                    .imageFilePath("https://example.com/nature-photography.jpg") // Replace with your actual image URL
                    .build();


            postService.savePost(post1);
            postService.savePost(post2);
        }
    }

}
