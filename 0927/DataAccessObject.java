package 이혜정교수님과제;

// 데이터베이스 작업을 위한 인터페이스 정의
public interface DataAccessObject {
	void select();
	void insert();
	void update();
	void delete();
}
