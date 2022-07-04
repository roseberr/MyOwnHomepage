package homepage.MyOwnHomepage.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
public interface PostsRepository extends JpaRepository<Posts, Long> {//jpa와  posts연결, 2번쨰 인자는 pk type
//interface통해서 jpa 연결한다.//post와 같은 디렉토리에 있어야함


}