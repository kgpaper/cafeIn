package DSC4.cafein.service;

import DSC4.cafein.domain.Member;
import DSC4.cafein.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repo;

    public Member login(String name, String pw){
        Member member = repo.findByUsernameAndPassword(name,pw);
        return member;
    }
}
