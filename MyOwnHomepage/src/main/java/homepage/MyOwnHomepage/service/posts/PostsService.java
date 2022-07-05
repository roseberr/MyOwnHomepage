package homepage.MyOwnHomepage.service.posts;


import homepage.MyOwnHomepage.domain.posts.Posts;
import homepage.MyOwnHomepage.domain.posts.PostsRepository;
import homepage.MyOwnHomepage.web.dto.PostsListResponseDto;
import homepage.MyOwnHomepage.web.dto.PostsResponseDto;
import homepage.MyOwnHomepage.web.dto.PostsSaveRequestDto;
import homepage.MyOwnHomepage.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional(readOnly=true)

    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }// postsRepository에서 넘어온 결과를 postslistresponsedto로 map을 통해 변환하고 그걸 list로 반환하는 함수이다.
}
