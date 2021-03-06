package DSC4.cafein.service;

import DSC4.cafein.domain.Cafe;
import DSC4.cafein.domain.Member;
import DSC4.cafein.domain.Seat;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class FirebaseServiceImpl implements FirebaseService{
    public static final String COLLECTION_NAME = "Member";
    @Override
    public String joinMember(Member member) throws Exception{
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture =
                firestore.collection(COLLECTION_NAME).document(member.getEmail()).set(member);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Member getMemberDetail(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =
                firestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        Member member = null;
        if(documentSnapshot.exists()){
            member = documentSnapshot.toObject(Member.class);
            return member;
        }
        else{
            return null;
        }
    }

    @Override
    public String updateMember(Member member) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture
                = firestore.collection(COLLECTION_NAME).document(member.getEmail()).set(member);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteMember(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture
                = firestore.collection(COLLECTION_NAME).document(id).delete();
        return "Document id: "+id+" delete";
    }




    @Override
    public Cafe getCafeDetail(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =
                firestore.collection("cafe").document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        Cafe cafe = null;
        if(documentSnapshot.exists()){
            cafe = documentSnapshot.toObject(Cafe.class);
            return cafe;
        }
        else{
            return null;
        }
    }


    //일단 cafe1 으로만 했습니다.
    @Override
    public String freeSeat(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference docRef
                = firestore.collection("cafe").document("cafe1")
                .collection("curr_seat").document(id);
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture
                = docRef.update("avail",true,"customer","");
        return "[ Free "+id+" ] ";
        // return "[ Free "+id+" ] "+apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String occupySeat(String id) throws Exception {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference docRef
                = firestore.collection("cafe").document("cafe1")
                .collection("curr_seat").document(id);
        ApiFuture<com.google.cloud.firestore.WriteResult> apiFuture
                = docRef.update("avail",false,"customer","kang");
        return "[ Occupy "+id+" ] ";
    }


}
