import javax.swing.SwingUtilities;
//test 2

public class Main { 

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new MainFrame();
			}

		});

	}

}
