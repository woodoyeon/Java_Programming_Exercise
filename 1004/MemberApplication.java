package 회원관리서비스;

import java.util.Scanner;

public class MemberApplication {
    
	// 현재 클래스에서만 사용가능한 memberService 객체 생성.
	private MyMemberService memberService = new MyMemberService();

	// 메인메서드에서 호출된 start 메서드. / 프로그램의 사작을 알림
    public void start() {
    	
    	// 입력받을 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 메뉴 선택의 값을 0으로 초기화 해준다.
        int menu = 0;

        // do~while 반복문으로 먼저 실행하고 반복문을 돌립니다.
        do {
        	// showMenuList()는 출력문을 담고있는 메서드이고 그 메서드를 호출합니다.
            showMenuList();
            System.out.print("선택>> ");
            
            // 예외처리를합니다. 스트링타입으로 입력받은것을 정수타입으로 변환해서 menu에 저장해줍니다.
            try {           
                menu = Integer.parseInt(scanner.nextLine());
            
            // 예외의 종류가 숫자이외의것이 입력되었을때 에러가 발생합니다.
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                
                //try문으로 올라가서 다시 숫자를 입력받습니다.
                continue;
            }
            // 정수가 입력되면 menu에 숫자가 입력되고 해당 케이스문이 실행됩니다.
            switch (menu) {
                case 1 -> registerMember();
                case 2 -> removeMember();
                case 3 -> loginMember();
                case 4 -> logoutMember();
                case 5 -> showMemberInfo();
                case 0 -> exit();
                default -> System.out.println("없는 메뉴 번호입니다.");
            }
          // 0 이 입력되면 프로그램이 종료되도록 설정됩니다.
        } while (menu != 0);
    }
    // 아래부터는 구현 메서드 입니다.
    // 메뉴를 보여주는 메서드 입니다.
    public void showMenuList() {
        System.out.println("1. 회원 등록 | 2. 회원 탈퇴 | 3. 로그인 | 4. 로그아웃 | 5. 회원 정보 조회 | 0. 종료");
    }

    // 회원정보를 추가하는 메서드입니다.
    private void registerMember() {
        
    	// 아이디, 이름, 비밀번호를 입력받습니다.
    	Scanner scanner = new Scanner(System.in);
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        // 입력받은 id, name, password를 member변수에 저아합니다.
        Member member = new Member(id, name, password);
        
        // MemberService의 regist 메서드에 member(id, name, password)정보를 인자값으로 보냅니다
        // 인자값으로 보낸 member는 HashMap 형태로 저장되고 "회원이 등록되었습니다." 라고 출력됩니다
        memberService.regist(member);
    }
    // 멤버를 삭제하는 메서드 입니다.
    private void removeMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 아이디: ");
        String id = scanner.nextLine();
        try {
            memberService.remove(id);
        } catch (NoMemberException e) {
            System.out.println(e.getMessage());
        }
    }
    // 로그인은 하는 메서드
    private void loginMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        try {
            memberService.login(id, password);
        } catch (NoMemberException e) {
            System.out.println(e.getMessage());
        }
    }
    // 로그아웃을 알리는 메서드
    private void logoutMember() {
        System.out.println("로그아웃되었습니다.");
    }
    
    private void showMemberInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        try {
            Member member = memberService.info(id, password);
            System.out.println("회원 정보: " + member.getId() + ", " + member.getName());
        } catch (NoMemberException e) {
            System.out.println(e.getMessage());
        }
    }

    private void exit() {
        System.out.println("프로그램 종료");
    }
}
