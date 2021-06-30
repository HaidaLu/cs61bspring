import static org.junit.Assert.*;
import org.junit.Test;

public class FilkTest {
    @Test
    public void isSameNumberTest() {
        Integer i = 128;
        Integer j = 128;
        assertTrue(Flik.isSameNumber(i, j));
        //fail. The bug is in Flik enterprise's library
        /*Integer类内部 通过静态内部类提供了一个缓存池，范围在-128~127之间，如果超过这个范围 Integer 值都是new出来的对象，比较的话肯定会出错！*/
    }
}
