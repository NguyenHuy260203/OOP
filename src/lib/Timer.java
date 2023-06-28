package lib;

public class Timer {
	public Timer(long now) {
		timeBegin = now;
		timeNow = now;
	}
	public Timer() { this(0); }
	
	private long timeBegin;
	private long timeNow;
	private long t = 0;
	
	public void setT(long now) {
		if(timeBegin == 0) {
			timeBegin = timeNow = now;
		}
		long preDelta = (long) (( timeNow - timeBegin ) / 1e9);
		long Delta    = (long) (( now     - timeBegin ) / 1e9);
		
		if (Delta != preDelta) t++;
		timeNow = now;
		t = (long) (now/1e9);
		
	}
	
	public long getT() {
		return t;
	}
}
