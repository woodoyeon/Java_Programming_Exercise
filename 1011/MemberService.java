package member.file;

public interface MemberService {
    void regist(Member member);
    void remove(String id);
    boolean login(String id, String password);
    void logout(String id);
    void info(String id, String password);

    // 새로 추가된 메서드들
    void saveToTextFile();
    void saveToBinaryFile();
    void loadFromTextFile();
    void loadFromBinaryFile();
}
