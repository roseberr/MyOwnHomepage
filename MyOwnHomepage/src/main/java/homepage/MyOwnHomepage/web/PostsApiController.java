package homepage.MyOwnHomepage.web;


import homepage.MyOwnHomepage.service.posts.PostsService;
import homepage.MyOwnHomepage.web.dto.PostsResponseDto;
import homepage.MyOwnHomepage.web.dto.PostsSaveRequestDto;
import homepage.MyOwnHomepage.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor //생성자 주입 autorized 역할
@RestController

public class PostsApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts")//등록할떄 사용
    public Long save(@RequestBody PostsSaveRequestDto
                     requestDto){
        return postsService.save(requestDto);
    }
    @PutMapping("/api/v1/posts/{id}")//수정할떄 사용
    public Long update(@PathVariable Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findByID(id);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
