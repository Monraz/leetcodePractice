package may;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LargestRectangleInHistogramTest {
    private final LargestRectangleInHistogramV1 largestRectangleInHistogram= new LargestRectangleInHistogramV1();

    @Test
    public void setLargestRectangleInHistogramTest1() {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int result = largestRectangleInHistogram.largestRectangleArea(heights);
        assertThat(result).isEqualTo(10);
    }
}
