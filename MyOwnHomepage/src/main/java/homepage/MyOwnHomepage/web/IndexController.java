package homepage.MyOwnHomepage.web;

import homepage.MyOwnHomepage.service.posts.PostsService;
import homepage.MyOwnHomepage.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller

public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());//postsService로 가져온 결과를 posts로 index에 전달
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")

    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto=postsService.findByID(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
