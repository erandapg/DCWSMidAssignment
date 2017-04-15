/*
 * 
 */
package dcws.hospital.system.rest.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dcws.hospital.system.rest.domain.DocAppointment;
import dcws.hospital.system.rest.domain.Doctor;
import dcws.hospital.system.rest.domain.ReserveAppointment;
import dcws.hospital.system.rest.enums.PaymentMethods;
import dcws.hospital.system.rest.enums.Status;
import dcws.hospital.system.rest.exceptions.HotelExceptions;
import dcws.hospital.system.rest.repository.DocAppoinmentRepository;
import dcws.hospital.system.rest.repository.DoctorRepository;
import dcws.hospital.system.rest.repository.ReserveAppoinmentRepository;
import dcws.hospital.system.rest.request.PaymentRequest;
import dcws.hospital.system.rest.request.SearchAppointmentRequest;
import dcws.hospital.system.rest.request.SearchDoctorsRequest;
import dcws.hospital.system.rest.response.ApointmentResponse;
import dcws.hospital.system.rest.response.DocAppointmentList;
import dcws.hospital.system.rest.response.DoctorResList;
import dcws.hospital.system.rest.response.PaymentResponse;
import dcws.hospital.system.rest.service.ReserveAppointmentService;
import dcws.hospital.system.rest.service.SendEmailService;
import dcws.hospital.system.rest.util.ErrorCodes;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author eranda_jkcs
 *
 */

@RestController
@RequestMapping(value = "/rest/hospital")
public class HospitalRestServices {

	@Value("${hospital.payment.cc.url}")
	private String ccUrl;

	@Value("${hospital.payment.mobile.url}")
	private String mobileUrl;

	@Autowired
	private ReserveAppointmentService reserveAppointmentService;
	@Autowired
	private ReserveAppoinmentRepository reserveAppoinmentRepository;
	@Autowired
	private DocAppoinmentRepository docAppoinmentRepository;

	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private SendEmailService sendEmailService;

	private static final Logger logInfo = LoggerFactory.getLogger("HOSPITAL_INFO");
	private static final Logger logErr = LoggerFactory.getLogger("HOSPITAL_ERROR");

	public HospitalRestServices() {
		DoctorResList doctorResList = new DoctorResList();
		DocAppointmentList appointmentList = new DocAppointmentList();
	}

	/* This method for search doctors using any search criteria */
	/**
	 * @param searchDoctorsRequest
	 * @return
	 */
	@ApiOperation(value = "serachDoctors", nickname = "serachDoctors")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DoctorResList.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/serachDoctors", method = RequestMethod.GET)
	public ResponseEntity<?> serachDoctors(@Validated @RequestBody SearchDoctorsRequest searchDoctorsRequest) {
		logInfo.info("serachDoctors Request received" + searchDoctorsRequest.toString());
		DoctorResList doctorResList = new DoctorResList();
		try {
			doctorResList = reserveAppointmentService.serachDoctors(searchDoctorsRequest);
			logInfo.info("serachDoctors Response sent" + doctorResList.toString());
			if (doctorResList.getResponseStatus() == 0) {
				return ResponseEntity.ok(doctorResList);
			} else {
				return prepareCorrectError(doctorResList.getResponseStatus(), doctorResList);
			}
		} catch (HotelExceptions e) {
			logInfo.info("serachDoctors Exception" + e.getMessage());
			logErr.error("serachDoctors Exception", e);
			doctorResList.setErrorDesc(e.getMessage());
			doctorResList.setResponseStatus(e.getErrorCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(doctorResList);
		} catch (Exception e1) {
			logInfo.info("serachDoctors Exception" + e1.getMessage());
			logErr.error("serachDoctors Exception", e1);
			doctorResList.setErrorDesc(e1.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(doctorResList);
		}
	}

	/* This method for get apointment by Doctor ID */
	/**
	 * @param appointmentRequest
	 * @return
	 */
	@ApiOperation(value = "getApointmentsByDocId", nickname = "getApointmentsByDocId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DocAppointmentList.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/getApointmentsByDocId", method = RequestMethod.GET)
	public ResponseEntity<?> getApointmentsByDocId(
			@Validated @RequestBody SearchAppointmentRequest appointmentRequest) {
		logInfo.info("getApointmentsByDocId Request received" + appointmentRequest.toString());
		DocAppointmentList appointmentList = new DocAppointmentList();
		try {
			appointmentList = reserveAppointmentService.getApointmentsByDocId(appointmentRequest);
			logInfo.info("getSMEById Response sent" + appointmentList.toString());
			if (appointmentList.getResponseStatus() == 0) {
				return ResponseEntity.ok(appointmentList);
			} else {
				return prepareCorrectError(appointmentList.getResponseStatus(), appointmentList);
			}
		} catch (HotelExceptions e) {
			logInfo.info("getApointmentsByDocId Exception" + e.getMessage());
			logErr.error("getApointmentsByDocId Exception", e);
			appointmentList.setErrorDesc(e.getMessage());
			appointmentList.setResponseStatus(e.getErrorCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appointmentList);
		} catch (Exception e1) {
			logInfo.info("getApointmentsByDocId Exception" + e1.getMessage());
			logErr.error("getApointmentsByDocId Exception", e1);
			appointmentList.setErrorDesc(e1.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appointmentList);
		}
	}

	/* This method for get all apointments available in the DB */
	/**
	 * @return
	 */
	@ApiOperation(value = "getAllApointments", nickname = "getAllApointments")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DocAppointmentList.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/getAllApointments", method = RequestMethod.GET)
	public ResponseEntity<?> getAllApointments() {

		DocAppointmentList appointmentList = new DocAppointmentList();
		try {
			List<DocAppointment> appointments = reserveAppointmentService.getAllApointments();

			List<ApointmentResponse> apointmentResponses = new ArrayList<ApointmentResponse>();
			for (DocAppointment appointment : appointments) {
				ApointmentResponse apointmentResponse = new ApointmentResponse();
				apointmentResponse.setApoimentId(appointment.getAppointments().getApoId().toString());
				apointmentResponse.setDocName(appointment.getDoctor().getName());
				apointmentResponse.setHospitalName(appointment.getAppointments().getHostpital());
				apointmentResponse.setApoimentTime(appointment.getAppointments().getDateTime());
				apointmentResponse.setSpeciality(appointment.getDoctor().getSpeciality());
				apointmentResponse.setStatus(appointment.getStatus().name());
				apointmentResponse.setCharge(appointment.getCharge());
				apointmentResponses.add(apointmentResponse);

			}
			appointmentList.setAppointmentList(apointmentResponses);
			appointmentList.setResponseStatus(0);
			appointmentList.setErrorDesc("SUCCESS");
			// logInfo.info("getAllApointments Response sent" +
			// appointmentList.toString());
			if (appointmentList.getResponseStatus() == 0) {
				return ResponseEntity.ok(appointmentList);
			} else {
				return prepareCorrectError(appointmentList.getResponseStatus(), appointmentList);
			}
		} catch (HotelExceptions e) {
			logInfo.info("getAllApointments Exception" + e.getMessage());
			logErr.error("getAllApointments Exception", e);
			appointmentList.setErrorDesc(e.getMessage());
			appointmentList.setResponseStatus(e.getErrorCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appointmentList);
		} catch (Exception e1) {
			logInfo.info("getAllApointments Exception" + e1.getMessage());
			logErr.error("getAllApointments Exception", e1);
			appointmentList.setErrorDesc(e1.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appointmentList);
		}
	}

	/*
	 * This is a tet payment gateway method for this assignment to enable invoke
	 * from ESB side
	 */
	/**
	 * @param paymentRequest
	 * @return
	 */
	@ApiOperation(value = "invokePaymentGateway", nickname = "invokePaymentGateway")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PaymentResponse.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(value = "/invokePaymentGateway", method = RequestMethod.POST)
	public ResponseEntity<?> invokePaymentGateway(@Validated @RequestBody PaymentRequest paymentRequest) {

		PaymentResponse paymentResponse = new PaymentResponse();
		try {

			Random random = new Random();
			paymentResponse.setTransactionId(String.valueOf(random.nextLong()));
			paymentResponse.setStatus("SUCCESS");
			return ResponseEntity.ok(paymentResponse);

		} catch (HotelExceptions e) {
			logInfo.info("invokePaymentGateway Exception" + e.getMessage());
			logErr.error("invokePaymentGateway Exception", e);
			paymentResponse.setStatus("ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentResponse);
		} catch (Exception e1) {
			logInfo.info("invokePaymentGateway Exception" + e1.getMessage());
			logErr.error("invokePaymentGateway Exception", e1);
			paymentResponse.setStatus("ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentResponse);
		}
	}

	/*
	 * This is server side method for Sampath payment gateway invoke from fron
	 * end
	 */
	/**
	 * @param amount
	 * @param ccNumber
	 * @param cardHolderName
	 * @param cvcNumber
	 * @param orderId
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "callHospitalCCPG", nickname = "callHospitalCCPG")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PaymentResponse.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cvcNumber", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ccNumber", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cardHolderName", required = true, example = "Test", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/callHospitalCCPG/{amount}/{ccNumber}/{cardHolderName}/{cvcNumber}/{orderId}/{userId}", method = RequestMethod.POST)
	public ResponseEntity<?> callHospitalCCPG(@Validated @PathVariable String amount,
			@Validated @PathVariable String ccNumber, @Validated @PathVariable String cardHolderName,
			@Validated @PathVariable String cvcNumber, @Validated @PathVariable String orderId,
			@Validated @PathVariable String userId) {
		logInfo.info("callHospitalCCPG Request received" + " " + cvcNumber + " " + ccNumber + " " + cardHolderName + " "
				+ orderId + " " + amount + " " + userId);

		PaymentResponse paymentResponse = new PaymentResponse();
		try {

			String urlStr = ccUrl + amount + "/" + cardHolderName + "/" + ccNumber + "/" + cvcNumber;

			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			} else {
				ReserveAppointment reserveAppointment = new ReserveAppointment();
				reserveAppointment.setCreatedDate(new Date());
				reserveAppointment.setCharge(Double.parseDouble(amount));
				reserveAppointment.setPaymentMethods(PaymentMethods.SAMPATH);
				reserveAppointment.setDescription(userId);
				reserveAppointment.setUser(userId);
				reserveAppointment.setDocAppointment(docAppoinmentRepository.findByDocApoId(Long.parseLong(orderId)));
				reserveAppointment.setStatus(Status.ACTIVE);
				reserveAppoinmentRepository.save(reserveAppointment);

				sendEmailService.sendEmail(reserveAppointment);

			}

			conn.disconnect();

			logInfo.info("callHospitalCCPG Response sent" + paymentResponse.toString());
			if (paymentResponse.getStatus() == "0") {
				return ResponseEntity.ok(paymentResponse);
			} else {
				return prepareCorrectError(Integer.parseInt(paymentResponse.getStatus()), paymentResponse);
			}
		} catch (HotelExceptions e) {
			logInfo.info("callHospitalCCPG Exception" + e.getMessage());
			logErr.error("callHospitalCCPG Exception", e);
			paymentResponse.setStatus("ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentResponse);
		} catch (Exception e1) {
			logInfo.info("callHospitalCCPG Exception" + e1.getMessage());
			logErr.error("callHospitalCCPG Exception", e1);
			paymentResponse.setStatus("ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentResponse);
		}
	}

	/*
	 * This is server side method for Dialog payment gateway invoke from fron
	 * end
	 */
	/**
	 * @param amount
	 * @param phonNumber
	 * @param pin
	 * @param orderId
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "callHospitalMobilePG", nickname = "callHospitalMpbilePG")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PaymentResponse.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "amount", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "phonNumber", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pin", required = true, example = "Test", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/callHospitalMobilePG/{amount}/{phonNumber}/{pin}/{orderId}/{userId}", method = RequestMethod.POST)
	public ResponseEntity<?> callHospitalMobilePG(@Validated @PathVariable String amount,
			@Validated @PathVariable String phonNumber, @Validated @PathVariable String pin,
			@Validated @PathVariable String orderId, @Validated @PathVariable String userId) {
		logInfo.info("callHospitalCCPG Request received" + " " + phonNumber + " " + pin + " " + orderId + " " + amount
				+ " " + userId);

		PaymentResponse paymentResponse = new PaymentResponse();
		try {

			String urlStr = ccUrl + amount + "/" + phonNumber + "/" + pin;

			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			} else {
				ReserveAppointment reserveAppointment = new ReserveAppointment();
				reserveAppointment.setCreatedDate(new Date());
				reserveAppointment.setCharge(Double.parseDouble(amount));
				reserveAppointment.setPaymentMethods(PaymentMethods.MOBILE);
				reserveAppointment.setDescription(userId);
				reserveAppointment.setUser(userId);
				reserveAppointment.setDocAppointment(docAppoinmentRepository.findByDocApoId(Long.parseLong(orderId)));
				reserveAppointment.setStatus(Status.ACTIVE);
				reserveAppoinmentRepository.save(reserveAppointment);

			}

			conn.disconnect();

			logInfo.info("callHospitalCCPG Response sent" + paymentResponse.toString());
			if (paymentResponse.getStatus() == "0") {
				return ResponseEntity.ok(paymentResponse);
			} else {
				return prepareCorrectError(Integer.parseInt(paymentResponse.getStatus()), paymentResponse);
			}
		} catch (HotelExceptions e) {
			logInfo.info("callHospitalCCPG Exception" + e.getMessage());
			logErr.error("callHospitalCCPG Exception", e);
			paymentResponse.setStatus("ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentResponse);
		} catch (Exception e1) {
			logInfo.info("callHospitalCCPG Exception" + e1.getMessage());
			logErr.error("callHospitalCCPG Exception", e1);
			paymentResponse.setStatus("ERROR");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paymentResponse);
		}
	}

	/**
	 * @param docName
	 * @param ccNumber
	 * @param hospitalName
	 * @param cvcNumber
	 * @param specialization
	 * @param date
	 * @return
	 */
	@ApiOperation(value = "getApointmentsBySearchCrit", nickname = "getApointmentsBySearchCrit")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = DocAppointmentList.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 500, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "docName", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "hospitalName", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "specialization", required = true, example = "Test", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "date", required = true, example = "Test", paramType = "query", dataType = "Date") })
	@RequestMapping(value = "/getApointmentsBySearchCrit/{docName}/{hospitalName}/{specialization}/{date}", method = RequestMethod.GET)
	public ResponseEntity<?> getApointmentsBySearchCrit(@Validated @PathVariable String docName,
			@Validated @PathVariable String ccNumber, @Validated @PathVariable String hospitalName,
			@Validated @PathVariable String cvcNumber, @Validated @PathVariable String specialization,
			@Validated @PathVariable Date date) {
		logInfo.info("getApointmentsBySearchCrit Request received" + " " + docName + " " + hospitalName + " "
				+ specialization + " " + date);

		DocAppointmentList appointmentList = new DocAppointmentList();
		SearchAppointmentRequest appointmentRequest = new SearchAppointmentRequest();

		try {

			Doctor doctor = doctorRepository.findByName(docName);
			if (null != doctor) {
				appointmentRequest.setDocId(doctor.getDocId());
			}

			appointmentList = reserveAppointmentService.getApointmentsByDocId(appointmentRequest);
			logInfo.info("getSMEById Response sent" + appointmentList.toString());
			if (appointmentList.getResponseStatus() == 0) {
				return ResponseEntity.ok(appointmentList);
			} else {
				return prepareCorrectError(appointmentList.getResponseStatus(), appointmentList);
			}
		} catch (HotelExceptions e) {
			logInfo.info("getApointmentsByDocId Exception" + e.getMessage());
			logErr.error("getApointmentsByDocId Exception", e);
			appointmentList.setErrorDesc(e.getMessage());
			appointmentList.setResponseStatus(e.getErrorCode());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appointmentList);
		} catch (Exception e1) {
			logInfo.info("getApointmentsByDocId Exception" + e1.getMessage());
			logErr.error("getApointmentsByDocId Exception", e1);
			appointmentList.setErrorDesc(e1.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(appointmentList);
		}
	}

	/* This method for error handling part for REST services */
	/**
	 * @param errCode
	 * @param res
	 * @return
	 */
	private ResponseEntity<?> prepareCorrectError(int errCode, Object res) {
		if (errCode == ErrorCodes.ERROR_ID_NOT_FOUND_OR_INVALID) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		} else if (errCode == ErrorCodes.ERROR_STATUS_NOT_FOUND_OR_INVALID) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		} else if (errCode == ErrorCodes.ERROR_ILLEGAL_ARGUMENT) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
		} else if (errCode == ErrorCodes.ERROR_UNKOWN) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

}
