
import org.example.GUI;
import org.example.Logic;
import org.example.LogicTicTacToe;
import org.example.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestLogicTicTacToe { 

	Logic logic;
	GUI gui;
	
	@Before
	public void setUp() {
		logic = new LogicTicTacToe();
		gui = new GUI(logic);
	}

	@Test
	public void testMakeTurn() {
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		logic.makeTurn(0, 0);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		logic.makeTurn(1, 1);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"-", "O", "-"}, {"-", "-", "-"}});
	}

	@Test
	public void testMakeWrongTurn() {
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		logic.makeTurn(0, 0);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		Assert.assertFalse(logic.makeTurn(0, 0));
	}

	@Test
	public void testCheckVictoryCondition() {
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		logic.makeTurn(0, 0);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		logic.makeTurn(1, 1);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"-", "O", "-"}, {"-", "-", "-"}});
		logic.makeTurn(1, 0);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"X", "O", "-"}, {"-", "-", "-"}});
		logic.makeTurn(2, 1);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"X", "O", "-"}, {"-", "O", "-"}});
		logic.makeTurn(2, 0);
		Assert.assertArrayEquals(logic.getBoard(), new String[][]{{"X", "-", "-"}, {"X", "O", "-"}, {"X", "O", "-"}});
		Assert.assertTrue(logic.isGameOver());
		Assert.assertNotNull(logic.checkVictoryCondition(Player.X));
	}
	
	@Test
	public void testGUItoLogicConnection() {
		Assert.assertArrayEquals(gui.getLogic().getBoard(), new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		gui.getLogic().makeTurn(0, 0);
		Assert.assertArrayEquals(gui.getLogic().getBoard(), new String[][]{{"X", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
		gui.getNewGameBtn().doClick();
		Assert.assertArrayEquals(gui.getLogic().getBoard(), new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}});
	}

}
