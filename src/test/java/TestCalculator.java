import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;

public class TestCalculator {
    @Test
    public void SumarTest(){
        try{
            Calculator calculator = new Calculator();
            long a = 1, b = 2, result = 3;
            Assertions.assertEquals(calculator.sumar(a,b), 3);
        }
        catch (Exception ex){
            ex.printStackTrace();
            Assertions.fail("Error", ex);
        }
    }

    //http://code-mentor.com/blog/2017/junit5-parameterized-tests.html
    //https://github.com/junit-team/junit5/blob/master/documentation/src/test/java/example/ParameterizedTestDemo.java
    static Collection<Object[]> dataRestar() {
        return Arrays.asList(new Object[][]{
                {3,2,1},
                {5,2,3},
                {1,1,0}
        });
    }

    @ParameterizedTest
    @MethodSource("dataRestar")
    public void RestarTest(long a, long b, long result){
        try{
            Calculator calculator = new Calculator();
            Assertions.assertEquals(calculator.restar(a,b), result);
        }
        catch (Exception ex){
            ex.printStackTrace();
            Assertions.fail("Error", ex);
        }
    }

    //https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
    @DisplayName("Test de multiplicacion")
    @Test
    public void MultiplicacionTest(){
        try{

            Assertions.assertAll("multiplicacion",
                    () -> assertMultiplicacion(3,2, 6),
                    () -> assertMultiplicacion(2,6, 12)
            );
        }
        catch (Exception ex){
            ex.printStackTrace();
            Assertions.fail("Error", ex);
        }
    }

    private void assertMultiplicacion(long a, long b, long result){
        Calculator calculator = new Calculator();
        Assertions.assertEquals(calculator.multiplicar(a,b), result);
    }

    @Test
    public void DividirTest(){
        Calculator calculator = new Calculator();
        Assertions.assertThrows(Exception.class, () ->{
           calculator.dividir(3, 0);
        });
    }
}
