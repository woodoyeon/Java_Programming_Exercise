package 이혜정교수님과제;

// MySQL DB 작업을 수행하는 클래스
public class MySqlDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("MySQL 데이터베이스에서 데이터 검색");
	}

	@Override
	public void insert() {
		System.out.println("MySQL 데이터베이스에 데이터 삽입");
	}

	@Override
	public void update() {
		System.out.println("MySQL 데이터베이스의 데이터 수정");
	}

	@Override
	public void delete() {
		System.out.println("MySQL 데이터베이스에서 데이터 삭제");
	}
}
