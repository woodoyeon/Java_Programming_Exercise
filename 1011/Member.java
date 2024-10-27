package member.file;

public class Member {
    private String id;
    private String password;
    private String name;

    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void displayMemberInfo() {
        System.out.println("ID: " + id);
        System.out.println("이름: " + name);
    }
}
