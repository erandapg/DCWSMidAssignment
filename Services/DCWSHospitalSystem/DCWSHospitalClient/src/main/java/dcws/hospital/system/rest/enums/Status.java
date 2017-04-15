package dcws.hospital.system.rest.enums;

public enum Status {

	/**
	 * INACTIVE (Ordinal 0).
	 */
	INACTIVE(0),

	/**
	 * ACTIVE (Ordinal 1).
	 */
	ACTIVE(1);

	private int value;

	private Status(int value) {
		this.value = value;
	}

	public static Status fromOrdinal(int ordinal) throws IllegalArgumentException {

		// Check for range
		if (ordinal >= Status.values().length) {
			throw new IllegalArgumentException("Status ordinal value " + ordinal + " is invalid.");
		}

		return Status.values()[ordinal];
	}

	public static Status fromOrdinal(String ordinal) throws IllegalArgumentException {
		return Status.fromOrdinal(Integer.parseInt(ordinal));
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
