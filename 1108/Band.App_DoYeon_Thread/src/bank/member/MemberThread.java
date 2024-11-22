package bank.member;

import bank.exception.NoMemberException;
import bank.member.HJMemberService;

public class MemberThread extends Thread {
    private String taskName;
    private HJMemberService memberService;
    private int memberId;
    private String email;

    public MemberThread(String taskName, HJMemberService memberService, int memberId, String email) {
        this.taskName = taskName;
        this.memberService = memberService;
        this.memberId = memberId;
        this.email = email;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                if ("EmailUpdateThread".equals(taskName)) {
                    // 이메일 수정 작업 처리
                    if (memberService.updateEmail(memberId, email)) {
                        System.out.println("이메일 수정 완료.");
                    } else {
                        throw new NoMemberException(memberId); // 회원이 존재하지 않으면 예외 던지기
                    }
                }
            } catch (NoMemberException e) {
                System.out.println("회원 ID가 존재하지 않습니다: " + memberId);
            }
        }
    }
}
