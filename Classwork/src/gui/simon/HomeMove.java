package gui.simon;

public class HomeMove implements MoveInterfaceHans {
	private ButtonInterfaceHans button;
	public HomeMove(ButtonInterfaceHans b) {
		this.button = b;
	}

	@Override
	public ButtonInterfaceHans getButton() {
		return button;
	}

}
