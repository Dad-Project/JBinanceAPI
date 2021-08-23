package fr.rowlaxx.binanceapi.core.market;

public enum Intervals {

	//Enumération
	MINUTE_1(1),
	MINUTE_3(3),
	MINUTE_5(5),
	MINUTE_15(15),
	MINUTE_30(30),
	HOUR_1(1*60),
	HOUR_2(2*60),
	HOUR_4(4*60),
	HOUR_6(6*60),
	HOUR_8(8*60),
	HOUR_12(12*60),
	DAY_1(1*24*60),
	DAY_3(3*24*60),
	WEEK_1(1*7*24*60),
	MONTH_1(1*30*24*60);
	
	//Variables
	private final int minutes;
	
	//Constructeurs
	private Intervals(int minutes) {
		if (minutes <= 0)
			throw new IllegalArgumentException("minutes must be greater than 0.");
		this.minutes = minutes;
	}
	
	//Methodes
	public int getMinutes() {
		return minutes;
	}
	
	public int getHour() {
		return getMinutes()/60;
	}
	
	public int getDay() {
		return getHour()/24;
	}
	
	public int getWeek() {
		return getDay()/7;
	}
	
	public int getMonth() {
		return getDay()/30;
	}
	
	@Override
	public String toString() {
		if (getMonth() > 0)
			return getMonth() + "M";
		if (getWeek() > 0)
			return getWeek() + "w";
		if (getDay() > 0)
			return getDay() + "d";
		if (getHour() > 0)
			return getHour() + "h";
		return getMinutes() + "m";
	}
	
}
