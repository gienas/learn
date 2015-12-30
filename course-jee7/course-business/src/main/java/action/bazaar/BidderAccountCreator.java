package action.bazaar;

import javax.annotation.PostConstruct;
import javax.ejb.PostActivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class BidderAccountCreator {

	private LoginInfo loginInfo;
	private BiographicalInfo biographicalInfo;
	private BillingInfo billingInfo;
	@PostConstruct
	@PostActivate
	public void openConnection() {
		// TODO open connections to resources
	}
	public void addLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	public void addBiographicalInfo(BiographicalInfo biographicalInfo) throws WorkflowOrderViolationException {
		if (loginInfo == null) {
			throw new WorkflowOrderViolationException("Login info must be set before biographical info");
		}
		this.biographicalInfo = biographicalInfo;
	}
	public void addBillingInfo(BillingInfo billingInfo) throws WorkflowOrderViolationException {
		if (biographicalInfo == null) {
			throw new WorkflowOrderViolationException("Biographical info must be set before billing info");
		}
		this.billingInfo = billingInfo;
	}
	@Remove
	public void cancelAccountCreation() {
		loginInfo = null;
		biographicalInfo = null;
		billingInfo = null;
	}
	@Remove
	public void createAccount() {
		//TODO account persistence
	}
}
