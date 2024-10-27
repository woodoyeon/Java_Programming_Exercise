package member.file;

import java.io.*;
import java.util.HashMap;

public class MyMemberService implements MemberService {
    private HashMap<String, Member> members = new HashMap<>();
    private String currentUserId = null;

    public MyMemberService() {
        loadFromTextFile();
        loadFromBinaryFile();
    }

    @Override
    public void regist(Member member) {
        if (members.containsKey(member.getId())) {
            System.out.println("이미 존재하는 회원입니다.");
        } else {
            members.put(member.getId(), member);
            System.out.println("회원이 성공적으로 등록되었습니다.");
        }
    }

    @Override
    public void remove(String id) {
        if (members.containsKey(id)) {
            members.remove(id);
            System.out.println("회원이 성공적으로 탈퇴되었습니다.");
        } else {
            System.out.println("해당 ID를 가진 회원이 없습니다.");
        }
    }

    @Override
    public boolean login(String id, String password) {
        Member member = members.get(id);
        if (member != null && member.getPassword().equals(password)) {
            currentUserId = id;
            System.out.println("로그인 성공");
            return true;
        } else {
            System.out.println("회원 정보가 일치하지 않습니다.");
            return false;
        }
    }

    @Override
    public void logout(String id) {
        if (id.equals(currentUserId)) {
            currentUserId = null;
            System.out.println("로그아웃 성공");
        } else {
            System.out.println("현재 로그인된 사용자가 아닙니다.");
        }
    }

    @Override
    public void info(String id, String password) {
        Member member = members.get(id);
        if (member != null && member.getPassword().equals(password)) {
            member.displayMemberInfo();
        } else {
            System.out.println("회원 정보를 확인할 수 없습니다.");
        }
    }

    // 텍스트 파일 저장
    @Override
    public void saveToTextFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("memberDB.txt"))) {
            for (Member member : members.values()) {
                writer.write(member.getId() + "," + member.getPassword() + "," + member.getName());
                writer.newLine();
            }
            System.out.println("텍스트 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("텍스트 파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 바이너리 파일 저장
    @Override
    public void saveToBinaryFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("memberDB.obj"))) {
            oos.writeObject(members);
            System.out.println("바이너리 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("바이너리 파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 텍스트 파일 로딩
    @Override
    public void loadFromTextFile() {
        File file = new File("memberDB.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (data.length == 3) {
                        Member member = new Member(data[0], data[1], data[2]);
                        members.put(member.getId(), member);
                    }
                }
                System.out.println("텍스트 파일에서 로딩되었습니다.");
            } catch (IOException e) {
                System.out.println("텍스트 파일 로딩 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    // 바이너리 파일 로딩
    @Override
    public void loadFromBinaryFile() {
        File file = new File("memberDB.obj");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                members = (HashMap<String, Member>) ois.readObject();
                System.out.println("바이너리 파일에서 로딩되었습니다.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("바이너리 파일 로딩 중 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }
}
