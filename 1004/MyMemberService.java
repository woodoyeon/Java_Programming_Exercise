package 회원관리서비스;

import java.util.HashMap;
import java.util.Map;

public class MyMemberService implements MemberService {
    private Map<String, Member> memberMap = new HashMap<>();

    @Override
    public void regist(Member member) {
    	
    	// memberMap 변수에 키, 벨류 값으로 순서대로 id넘버값과 전달받은 member이 저장됩니다.
        memberMap.put(member.getId(), member);
        System.out.println("회원이 등록되었습니다.");
    }

    @Override
    public void remove(String id) throws NoMemberException {
        //containsKey : 지정된 키가 존재하는지 여부를 검사
    	//id가 존재하면 true를 반환하지만 !가있으니 존재하면 false를 반환합니다
    	if (!memberMap.containsKey(id)) {
            
    		// `NoMemberException` 예외 객체를 생성하고 발생시킴. 이 예외는 `remove()` 메서드를 호출한 호출자에게 전달된다.
    		throw new NoMemberException(id);

        }
        memberMap.remove(id);
        System.out.println("회원이 삭제되었습니다.");
    }

    @Override
    public boolean login(String id, String password) throws NoMemberException {
        Member member = memberMap.get(id);
        
	     // member가 null이면 예외가 발생하여 메서드를 종료하고, 호출자에게 예외가 전달됩니다.
	     // member가 null이 아니면 아래의 비밀번호 확인 로직으로 진행됩니다.
        if (member == null) {
            throw new NoMemberException(id);
        }
	     // member가 존재하고, 비밀번호가 일치하면 로그인 성공을 출력하고 true를 반환합니다.
	     // 비밀번호가 일치하지 않으면 로그인 실패를 출력하고 false를 반환합니다.
        if (member.getPassword().equals(password)) {
            System.out.println("로그인 성공");
            return true;
        }
        System.out.println("로그인 실패: 비밀번호가 틀렸습니다.");
        return false;
    }

    @Override
    public void logout(String id) {
        System.out.println("로그아웃되었습니다.");
    }

    @Override
    public Member info(String id, String password) throws NoMemberException {
    	//id의 값을 member에 저장합니다.
    	Member member = memberMap.get(id);
        
    	// member가 비어있지않거나 && 사용자가 입력한 비밀번호와 저장된 비밀번호가 같다면 member를 리턴합니다.
    	if (member != null && member.getPassword().equals(password)) {
            return member;
        }
        throw new NoMemberException(id);
    }
}
