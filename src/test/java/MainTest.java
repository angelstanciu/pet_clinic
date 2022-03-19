import repositorytest.BaseRepositoryTest;

public class MainTest {
    public static void main(String[] args) {
        BaseRepositoryTest baseRepositoryTest = new BaseRepositoryTest();
        baseRepositoryTest.saveTest();
        baseRepositoryTest.deleteTest();
        baseRepositoryTest.updateTest();
        baseRepositoryTest.findAllTest();
    }
}