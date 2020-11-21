package DSC4.cafein.repository;

import DSC4.cafein.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    Member findByUsernameAndPassword(String name,String pw);
}
//public class MemberRepository {
//}
