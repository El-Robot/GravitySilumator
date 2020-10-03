import javax.swing.SwingUtilities;
//committed Commot

public class Main { 

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				new MainFrame();
			}

		});

	}

}
