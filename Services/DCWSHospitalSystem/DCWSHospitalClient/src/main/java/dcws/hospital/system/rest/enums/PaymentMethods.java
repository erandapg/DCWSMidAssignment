package dcws.hospital.system.rest.enums;

public enum PaymentMethods {

	SAMPATH(0),

	MOBILE(1);

	private int value;

	private PaymentMethods(int value) {
		this.value = value;
	}

	public static PaymentMethods fromOrdinal(int ordinal) throws IllegalArgumentException {

		// Check for range
		if (ordinal >= PaymentMethods.values().length) {
			throw new IllegalArgumentException("Status ordinal value " + ordinal + " is invalid.");
		}

		return PaymentMethods.values()[ordinal];
	}

	public static PaymentMethods fromOrdinal(String ordinal) throws IllegalArgumentException {
		return PaymentMethods.fromOrdinal(Integer.parseInt(ordinal));
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
