package member.file;

import java.util.InputMismatchException;

public class MemberApplication {
    public static void main(String[] args) {
        MemberView view = new MemberView();
        MyMemberService service = new MyMemberService();

        int option;
        do {
            view.showMenu();
            try {
                option = view.getMenuSelection();

                switch (option) {
                    case 1:
                        String id = view.getId();
                        String password = view.getPassword();
                        String name = view.getName();
                        Member newMember = new Member(id, password, name);
                        service.regist(newMember);
                        break;
                    case 2:
                        id = view.getId();
                        service.remove(id);
                        break;
                    case 3:
                        id = view.getId();
                        password = view.getPassword();
                        service.login(id, password);
                        break;
                    case 4:
                        id = view.getId();
                        service.logout(id);
                        break;
                    case 5:
                        id = view.getId();
                        password = view.getPassword();
                        service.info(id, password);
                        break;
                    case 6:
                        service.saveToTextFile(); // 종료 시 텍스트 파일에 저장
                        service.saveToBinaryFile(); // 종료 시 바이너리 파일에 저장
                        view.showMessage("프로그램 종료");
                        break;
                    default:
                        view.showMessage("잘못된 입력입니다. 다시 선택해주세요.");
                        break;
                }
            } catch (InputMismatchException e) {
                view.showMessage("숫자를 입력해야 합니다. 다시 시도해주세요.");
                option = 0; // Reset option to continue the loop
                view.getMenuSelection(); // Clear the invalid input
            }
        } while (option != 6);
    }
}
