package examples.mod05;

public class PrepaidPhone {
	private int limit;

	public PrepaidPhone(int startLimit) {
		limit = startLimit;
	}
	
	public void makeCall(int min) {
		limit -= min;
		System.out.println("\tNice talk...");
	}
	
	public int getLimit() {
		return limit;
	}

	public void addToLimit(int min) {
		limit += min;
	}
}
