package fr.rowlaxx.binanceapi.core.futures.marketdata;

public enum Period {

	//Enumération
	MINUTE_5(5),
	MINUTE_15(15),
	MINUTE_30(30),
	HOUR_1(1*60),
	HOUR_2(2*60),
	HOUR_4(4*60),
	HOUR_6(6*60),
	HOUR_12(12*60),
	DAY_1(1*24*60);

	//Variables
	private final int minutes;

	//Constructeurs
	private Period(int minutes) {
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

	@Override
	public String toString() {
		if (getDay() > 0)
			return getDay() + "d";
		if (getHour() > 0)
			return getHour() + "h";
		return getMinutes() + "m";
	}

}
