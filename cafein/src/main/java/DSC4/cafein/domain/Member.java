package DSC4.cafein.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="login")
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private String email;
    private String name;
    private String pw;
    public Member(){

    }

    public Member(String email,String name,String pw){
        this.email = email;
        this.name = name;
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }






}
