package homepage.MyOwnHomepage.domain.posts;

import homepage.MyOwnHomepage.domain.posts.user.Role;
import homepage.MyOwnHomepage.domain.posts.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


}
