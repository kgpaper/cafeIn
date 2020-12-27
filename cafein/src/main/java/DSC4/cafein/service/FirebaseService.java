package DSC4.cafein.service;

import DSC4.cafein.domain.Cafe;
import DSC4.cafein.domain.Member;

public interface FirebaseService {
    public String insertMember(Member member) throws Exception;
    public Member getMemberDetail(String id) throws Exception;
    public String updateMember(Member member) throws Exception;
    public String deleteMember(String id) throws Exception;

    public Cafe getCafeDetail(String id) throws Exception;
}
