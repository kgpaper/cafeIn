package DSC4.cafein.service;

import DSC4.cafein.domain.Cafe;
import DSC4.cafein.domain.Member;
import DSC4.cafein.domain.Seat;

public interface FirebaseService {
    public String joinMember(Member member) throws Exception;
    public Member getMemberDetail(String id) throws Exception;
    public String updateMember(Member member) throws Exception;
    public String deleteMember(String id) throws Exception;

    public Cafe getCafeDetail(String id) throws Exception;
    public String freeSeat(String id) throws Exception;
    public String occupySeat(String id) throws Exception;
}
