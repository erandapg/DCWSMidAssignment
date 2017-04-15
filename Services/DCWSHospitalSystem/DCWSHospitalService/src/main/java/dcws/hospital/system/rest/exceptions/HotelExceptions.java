/**
 * 
 */
package dcws.hospital.system.rest.exceptions;


public class HotelExceptions extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer errorCode;
	private String message;
	
	private Object params[];

	public HotelExceptions(Integer errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public HotelExceptions(Integer errorCode, String message,Object params[]) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.params = params;
	}

	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}
