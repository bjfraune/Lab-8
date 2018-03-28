
public class Driver {

	protected static MainDirectory remoteDirectory;

	public static void main(String[] args) throws Exception {
		remoteDirectory = new MainDirectory();
		Server.main(null);
	}

}
