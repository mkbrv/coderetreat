import com.miki.Cell;
import com.miki.GridController;
import junit.framework.TestCase;

/**
 * Created by Miki on 11/15/2014.
 */
public class GridControllerTest extends TestCase {

    GridController gridController = new GridController();

    public void testAddCellInGrid() {
        assertEquals(Boolean.TRUE, gridController.addCell(new Cell(10, 10)));
        assertEquals(Boolean.FALSE, gridController.addCell(new Cell(10, 10)));
        //don't allow us to add the same cell twice
    }


    public void testGetSmallest() {
        gridController.addCell(new Cell(-1, -2));
        assertEquals(gridController.getSmallestCellByLine().getLine(), -1);
        assertEquals(gridController.getSmallestCellByColumn().getColumn(), -2);
    }

    public void testGetBiggest() {
        gridController.addCell(new Cell(10, 20));
        assertEquals(gridController.getBiggestByLine().getLine(), 10);
        assertEquals(gridController.getBiggestByColumn().getColumn(), 20);
    }


    public void testToString() {
        gridController.addCell(new Cell(1, 0));
        gridController.addCell(new Cell(0, 0));
        gridController.addCell(new Cell(2, 1));
        gridController.addCell(new Cell(1, 1));
        String gridToString = gridController.toString();
        assertNotNull(gridToString);
        assertTrue(gridToString.contains("\r\n"));
        System.out.println(gridToString);
    }

    public void test100Generations(){
        GridController gridController = new GridController();
        gridController.addCell(new Cell(1, 1));
        gridController.addCell(new Cell(1, 2));
        gridController.addCell(new Cell(1, 3));
        gridController.addCell(new Cell(2, 0));
        gridController.addCell(new Cell(2, 1));
        gridController.addCell(new Cell(2, 2));
        gridController.generateGenerations(100);
    }

    public void testNGenerations(){
        GridController gridController = new GridController();
        gridController.addCell(new Cell(3, 4));
        gridController.addCell(new Cell(4, 3));
        gridController.addCell(new Cell(4, 4));
        gridController.addCell(new Cell(4, 5));
        gridController.generateGenerations(100);
    }

}
