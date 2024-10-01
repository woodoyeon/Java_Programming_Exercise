package 이혜정교수님과제;

public class DaoExample {

	// DB 작업을 수행하는 메서드
	public static void executeDbTask(DataAccessObject daoObject) {
		daoObject.select();
		daoObject.insert();
		daoObject.update();
		daoObject.delete();
	}

	public static void main(String[] args) {
		// OracleDao와 MySqlDao의 DB 작업 수행
		executeDbTask(new OracleDao());
		executeDbTask(new MySqlDao());
	}
}
