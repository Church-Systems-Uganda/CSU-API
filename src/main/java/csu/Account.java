package tests;

public class Account {
	 float principal;
	 float rate;
	 int daysActive;
	 int accountType;
	 	
	 	    public static final int  STANDARD = 0;
	 	    public static final int  BUDGET = 1;
	 	    public static final int  PREMIUM = 2;
	 	    public static final int  PREMIUM_PLUS = 3;
	 	
	 	    float interestEarned() {
	 	        float years = daysActive / (float) 365.25;
	 	        float compoundInterest = principal * (float) Math.exp( rate * years );
	 	        return ( compoundInterest - principal );
	 	    }
	 	
	 	    public boolean isPremium() {
	 	        if (accountType == Account.PREMIUM || accountType == Account.PREMIUM_PLUS)
	 	            return true;
	 	        else
	 	            return false;
	 	    }
	 	
	 	
	 	float calculateFee(Account accounts[]) {
	 	    float totalFee = 0;
	 	    Account account;
	 	    for (int i = 0; i < accounts.length; i++) {
	 	        account = accounts[i];
	 	        if ( account.isPremium() ) {
	 	            totalFee += BROKER_FEE_PERCENT * account.interestEarned();
	 	        }
	 	    }
	 	    return totalFee;
	 	}
	 	
	 static final double BROKER_FEE_PERCENT = 0.0125;


}
