package epam;

import epam.repository.StudentRepositoryTest;
import epam.util.StudentsWriterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({StudentRepositoryTest.class, StudentsWriterTest.class})
public class TestSuite {
}
