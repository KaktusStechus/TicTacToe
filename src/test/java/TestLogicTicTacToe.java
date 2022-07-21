
import org.example.Logic;
import org.example.LogicTicTacToe;
import org.example.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestLogicTicTacToe { 

	Logic logic;
	
	@Before
	public void setUp() {
		logic = new LogicTicTacToe();
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

}
