package bank.app;

import java.util.List;
import java.util.Scanner;

import bank.exception.NoMemberException;
import bank.member.HJMemberService;
import bank.member.MemberVO;
import bank.member.OracleMemberDAO;

public class MemberApplication {

    private static Scanner sc = new Scanner(System.in);
    private static HJMemberService memberService;

    public static void main(String[] args) {
        
        // DB 연결을 위한 DAO 주입
        memberService = new HJMemberService(new OracleMemberDAO());
        
        int menu = 0;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("1. 회원 가입 | 2. 회원 목록 | 3. 회원 이메일 수정 | 4. 회원 삭제 | 5. 종료");
            System.out.println("------------------------------------------------");
            System.out.print("선택> ");
            
            menu = Integer.parseInt(sc.nextLine());
            
            switch (menu) {
                case 1 : // 회원 가입
                    createMember();
                    break;
                case 2 : // 회원 목록
                    viewMemberList();
                    break;
                case 3 : // 이메일 수정
                    updateMemberEmail();
                    break;
                case 4 : // 회원 삭제
                    removeMember();
                    break;
                case 5 : // 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default :
                    System.out.println("잘못된 입력입니다.");
            }
        } while (menu != 5);
    }

    private static void createMember() {
        System.out.print("이름: ");
        String name = sc.nextLine();
        
        System.out.print("이메일: ");
        String email = sc.nextLine();

        if (memberService.createMember(name, email)) {
            System.out.println("회원이 성공적으로 등록되었습니다.");
        }
    }

    private static void viewMemberList() {
        List<MemberVO> members = memberService.listAllMembers();
        if (members != null) {
            for (MemberVO member : members) {
                System.out.println(member);
            }
        } else {
            System.out.println("등록된 회원이 없습니다.");
        }
    }

    private static void updateMemberEmail() {
        System.out.print("회원 ID: ");
        int memberId = Integer.parseInt(sc.nextLine());

        System.out.print("새 이메일: ");
        String email = sc.nextLine();

        try {
            if (memberService.updateEmail(memberId, email)) {
                System.out.println("이메일이 성공적으로 수정되었습니다.");
            } else {
                System.out.println("이메일 수정 실패.");
            }
        } catch (NoMemberException e) {
            System.out.println(e.toString());  // 예외 처리: 회원이 없을 경우 예외 메시지 출력
        }
    }

    private static void removeMember() {
        System.out.print("회원 ID: ");
        int memberId = Integer.parseInt(sc.nextLine());

        try {
            if (memberService.deleteMember(memberId)) {
                System.out.println("회원이 성공적으로 삭제되었습니다.");
            }
        } catch (NoMemberException e) {
            System.out.println(e.toString());  // 예외 처리: 회원이 없을 경우 예외 메시지 출력
        }
    }
}
