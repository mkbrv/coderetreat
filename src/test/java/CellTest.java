import com.miki.Cell;
import junit.framework.TestCase;

/**
 * Created by Miki on 11/15/2014.
 */
public class CellTest extends TestCase {


    public void testCellCreation() {
        Cell cell = new Cell(10, 10);
        assertNotNull(cell);
        assertEquals(cell.getColumn() == 10, cell.getLine() == 10);
    }


}
