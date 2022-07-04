package homepage.MyOwnHomepage.domain.posts;



import org.aspectj.lang.annotation.After;
//import org.junit.After;
//import org.junit.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest

class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After("")
    public void cleanup(){
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        //given

        String title="테스트 게시글";
        String content="테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("bsc981111@gmail.com")
                .build());

        //when

        List<Posts> postsList=postsRepository.findAll();

        //then

        Posts posts=postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);

    }


}