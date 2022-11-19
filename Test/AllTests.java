import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    public static Test suite() {
        TestSuite suite = new TestSuite("Test for Clinic package");
        //$JUnit-BEGIN$
        suite.addTestSuite(TestR1_Patients.class);
        suite.addTestSuite(TestR2_Doctors.class);
        suite.addTestSuite(TestR3_PatientRegistration.class);
        suite.addTestSuite(TestR4_Loading.class);
        suite.addTestSuite(TestR5_Statistics.class);
        //$JUnit-END$
        return suite;
    }
}
