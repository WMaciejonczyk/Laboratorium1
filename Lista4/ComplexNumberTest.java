import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Klasa testująca metody klasy ComplexNumber.
 */
public class ComplexNumberTest {
    protected ComplexNumber z1;

    protected ComplexNumber z2;

    protected ComplexNumber z3;

    @BeforeEach
    void setUpBeforeEach() {
        this.z1 = new ComplexNumber(3.0, 4.0);
        this.z2 = new ComplexNumber(-2.5, 2.5);
        this.z3 = new ComplexNumber(0, 0);
    }

    @Test
    public void testInput() {
        String[] input = {"3.0 + i4.0", "3.0+i4.0", "3.0+i*4.0", "3.0 + i * 4.0", "5.0exp(i0.93)", "5.0*exp(i*0.93)",
                "5.0 * exp(i * 0.93)"};
        Arrays.stream(input).map(s -> new ByteArrayInputStream(s.getBytes())).forEach(in -> {
            System.setIn(in);
            ComplexNumber userNumber = ComplexNumber.Input();
            String result = z1.toString().split("\n")[0];
            String estimated = userNumber.toString().split("\n")[0];
            assertEquals(result, estimated);
            System.setIn(System.in);
        });
    }

    @Test
    public void testInputBledny() {
        String input = "kaasadda";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(InvalidInputException.class, () -> {
            ComplexNumber.Input();
        });
        System.setIn(System.in);
    }

    @Test
    public void testModul() {
        assertEquals(z1.modul(), 5.0);
    }

    @Test
    public void testArgument() {
        assertEquals(z1.argument(), Math.atan2(4.0, 3.0));
    }

    @Test
    public void testDodawanie() {
        Vector2D result = z1.dodawanie(z2);
        assertEquals(new ComplexNumber(0.5, 6.5), result);
    }

    @Test
    public void testDodawanieStat() {
        ComplexNumber result = ComplexNumber.dodawanieStat(z1, z2);
        assertEquals(new ComplexNumber(0.5, 6.5), result);
    }

    @Test
    public void testOdejmowanie() {
        Vector2D result = z1.odejmowanie(z2);
        assertEquals(new ComplexNumber(5.5, 1.5), result);
    }

    @Test
    public void testOdejmowanieStat() {
        ComplexNumber result = ComplexNumber.odejmowanieStat(z1, z2);
        assertEquals(new ComplexNumber(5.5, 1.5), result);
    }

    @Test
    public void testMnozenie() {
        ComplexNumber result = z1.mnozenie(z2);
        assertEquals(new ComplexNumber(-17.5, -2.5), result);
    }

    @Test
    public void testMnozenieStat() {
        ComplexNumber result = ComplexNumber.mnozenieStat(z1, z2);
        assertEquals(new ComplexNumber(-17.5, -2.5), result);
    }

    @Test
    public void testDzieleniePoprawne() {
        ComplexNumber result = z1.dzielenie(z2);
        assertEquals(new ComplexNumber(0.2, -1.4), result);
    }

    @Test
    public void testDzieleniePrzezZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            z1.dzielenie(z3);
        });
    }

    @Test
    public void testDzielenieStatPoprawne() {
        ComplexNumber result = ComplexNumber.dzielenieStat(z1, z2);
        assertEquals(new ComplexNumber(0.2, -1.4), result);
    }

    @Test
    public void testDzielenieStatPrzezZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            ComplexNumber.dzielenieStat(z1, z3);
        });
    }

    @Test
    public void testPotegowaniePoprawne() {
        ComplexNumber result = z1.potegowanie(2);
        double rzecz = 25 * Math.cos(2 * Math.atan2(4.0, 3.0));
        double uroj = 25 * Math.sin(2 * Math.atan2(4.0, 3.0));
        assertEquals(new ComplexNumber(rzecz, uroj), result);
    }

    @Test
    public void testPotegowaniePrzezZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            z3.potegowanie(0);
        });
    }


    @Test
    public void testPotegowanieStatPoprawne() {
        ComplexNumber result = ComplexNumber.potegowanieStat(z1, 2);
        double rzecz = 25 * Math.cos(2 * Math.atan2(4.0, 3.0));
        double uroj = 25 * Math.sin(2 * Math.atan2(4.0, 3.0));
        assertEquals(new ComplexNumber(rzecz, uroj), result);
    }

    @Test
    public void testPotegowanieStatPrzezZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            ComplexNumber.potegowanieStat(z3, 0.0);
        });
    }

    @Test
    public void testRepBieg() {
        String result = z1.repBieg();
        assertEquals("z = (5.0, 0.93)", result);
    }

    @Test
    public void testEquals() {
        ComplexNumber zCopy = new ComplexNumber(3.0, 4.0);
        assertTrue(z1.equals(zCopy));
    }

    @Test
    public void testToStringDodatniaCzescUrojona() {
        String result = z1.toString();
        String estimated = "5.0exp(i0.93)\nz = 3.0 + i4.0";
        assertEquals(estimated, result);
    }

    @Test
    public void testToStringUjemnaCzescUrojona() {
        ComplexNumber z = new ComplexNumber(2.0, -2.0);
        String estimated = "2.83exp(-i0.79)\nz = 2.0 - i2.0";
        assertEquals(estimated, z.toString());
    }
}