package may;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCompressionTest {

    private final StringCompression stringCompression = new StringCompression();

    @Test
    public void stringCompression1Test() {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int result = stringCompression.compress(chars);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void stringCompression2Test() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int result = stringCompression.compress(chars);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void stringCompression3Test() {
        char[] chars = {'a'};
        int result = stringCompression.compress(chars);
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void stringCompression4Test() {
        char[] chars = {'a', 'b', 'c'};
        int result = stringCompression.compress(chars);
        assertThat(result).isEqualTo(3);
    }
}
