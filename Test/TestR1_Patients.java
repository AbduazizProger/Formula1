import junit.framework.TestCase;

public class TestR1_Patients extends TestCase {
    public void testCreatePatients() {

        Clinic c = new Clinic();

        c.addPatient("Mario", "Rossi", "MRARSS56T12L435F");

        Person p = new Person("Mario", "Rossi", "MRARSS56T12L435F");
        Person p1 = null;
        try {
            p1 = c.getPatient("MRARSS56T12L435F");
            assertEquals(p1.getFirst(), p.getFirst());
            assertEquals(p1.getLast(), p.getLast());
            assertEquals(p1.getSSN(), p.getSSN());
        } catch (NoSuchPatient e) {

            assertTrue("no patient created",p1!=null);
        }

    }

    public void testNoSuchPatient() {

        Clinic c = new Clinic();

        try {
            c.getPatient("MRARSS52342L435F");

        } catch (Exception e) {


            assertTrue(e instanceof NoSuchPatient);
        }

    }
}
