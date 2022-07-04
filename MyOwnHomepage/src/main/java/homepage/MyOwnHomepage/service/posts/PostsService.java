package homepage.MyOwnHomepage.service.posts;


import homepage.MyOwnHomepage.domain.posts.Posts;
import homepage.MyOwnHomepage.domain.posts.PostsRepository;
import homepage.MyOwnHomepage.web.dto.PostsResponseDto;
import homepage.MyOwnHomepage.web.dto.PostsSaveRequestDto;
import homepage.MyOwnHomepage.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts=postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }
    @Transactional
    public PostsResponseDto findByID(Long id) {
        Posts entity=postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);

    }
}
