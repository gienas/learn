package behavioural.chainofresponsibility;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CheckAuthority {
	public static void main(String[] args) {
		ManagerPPower manager = new ManagerPPower();
		DirectorPPower director = new DirectorPPower();
		VicePresidentPPower vp = new VicePresidentPPower();
		PresidentPPower president = new PresidentPPower();
		manager.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(president);

		// Press Ctrl+C to end.
		try {
			while (true) {
				System.out.println("Enter the amount to check who should approve your expenditure.");
				System.out.print(">");
				double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
				manager.processRequest(new PurchaseRequest(d, "General"));
			}
		} catch (Exception e) {
			System.exit(1);
		}
	}
}

class PurchaseRequest {
	private double amount;
	private String purpose;

	public PurchaseRequest(double amount, String purpose) {
		this.amount = amount;
		this.purpose = purpose;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amt) {
		amount = amt;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String reason) {
		purpose = reason;
	}
}

abstract class PurchasePower {
	protected static final double BASE = 500;
	protected PurchasePower successor;

	public void setSuccessor(PurchasePower successor) {
		this.successor = successor;
	}

	abstract public void processRequest(PurchaseRequest request);
}
// Four implementations of the abstract class above: Manager, Director, Vice
// President, President

class ManagerPPower extends PurchasePower {
	private final double ALLOWABLE = 10 * BASE;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE) {
			System.out.println("Manager will approve $" + request.getAmount());
		} else if (successor != null) {
			successor.processRequest(request);
		}
	}
}

class DirectorPPower extends PurchasePower {
	private final double ALLOWABLE = 20 * BASE;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE) {
			System.out.println("Director will approve $" + request.getAmount());
		} else if (successor != null) {
			successor.processRequest(request);
		}
	}
}

class VicePresidentPPower extends PurchasePower {
	private final double ALLOWABLE = 40 * BASE;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE) {
			System.out.println("Vice President will approve $" + request.getAmount());
		} else if (successor != null) {
			successor.processRequest(request);
		}
	}
}

class PresidentPPower extends PurchasePower {
	private final double ALLOWABLE = 60 * BASE;

	public void processRequest(PurchaseRequest request) {
		if (request.getAmount() < ALLOWABLE) {
			System.out.println("President will approve $" + request.getAmount());
		} else {
			System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
		}
	}

}