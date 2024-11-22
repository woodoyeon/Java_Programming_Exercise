package bank.member;

import java.util.Date;

public class MemberVO {
    private int memberId;
    private String name;
    private String email;
    private Date regDate;

    public MemberVO(int memberId, String name, String email, Date regDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.regDate = regDate;
    }

    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Date getRegDate() { return regDate; }
    public void setRegDate(Date regDate) { this.regDate = regDate; }

    @Override
    public String toString() {
        return "MemberVO [memberId=" + memberId + ", name=" + name + ", email=" + email + ", regDate=" + regDate + "]";
    }
}
