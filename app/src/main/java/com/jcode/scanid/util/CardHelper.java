package com.jcode.scanid.util;



import android.util.Base64;

import com.jcode.scanid.model.CardData;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by otimj on 8/17/2019.
 */
public class CardHelper {


//	- Applicants name details (surname, givenname, other names) in capital letters and full length (up to 50 characters each)
//- Date of Birth in format DDMMYYYY
//- Date of Issue in format DDMMYYYY
//- Date of Expiry in format DDMMYYYY
//- NIN (14 characters long)
//- Card number (9 characters long)
//- 1 fingerprint (minutia) including information about that finger. Same fingerprint as
//	printed as image (see 1.1.2.1 ) will be used

	public static CardData extractCardData (String dataToExtractFrom) throws ParseException , NumberFormatException, UnsupportedEncodingException {

		if(isValid(dataToExtractFrom)){

			String[] array = splitScanResult(dataToExtractFrom);
			//TODO: Fix decoding issue for names. Seems not to be working
			String surName =  String.valueOf(Base64.decode(array[0].getBytes("UTF-8"), Base64.CRLF));
			String givenNames = String.valueOf(Base64.decode(array[1].getBytes("UTF-8"), Base64.CRLF));
			String otherNames = String.valueOf(Base64.decode(array[2].getBytes("UTF-8"), Base64.CRLF));


			String dateOfBirth = array[3];
			String dateOfIssue = array[4];
			String dateOfExpiry = array[5];
			String nationalId = array[6];
			String documentNumber = array[7];
			String fingerPrintData = array[8];
			String fingerPrintMinutiaNumber = array[9];
			String whatIsThis = array[10];


			CardData data = new CardData();
			data.setSurName(surName);
			data.setGivenName(givenNames);
			data.setOtherName(otherNames);
			data.setDateOfBirth(preformatDate(dateOfBirth));
			data.setDateOfIssue(preformatDate(dateOfIssue));
			data.setDateOfExpiry(preformatDate(dateOfExpiry));
			data.setNationalId(nationalId);
			data.setDocumentNumber(documentNumber);
			data.setFingerPrintData(fingerPrintData);
			data.setFingerPrintMinuatiaCount(Integer.valueOf(fingerPrintMinutiaNumber));
			data.setOtherData(whatIsThis);

			return data;

		}else{
			return null;

		}
	}

	private static Date preformatDate(String dateOfBirth) throws ParseException {
		String pattern = "ddMMyyyy"; //11121991 = 11 December 1991
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date date = simpleDateFormat.parse(dateOfBirth);
		return date;

	}

	private static boolean isValid(String dataToExtractFrom) {
		String[] cardData = splitScanResult(dataToExtractFrom);
		if(cardData.length != 11){
			return false;
		}
		return true;
	}

	private static String[] splitScanResult(String scanResult) throws IllegalArgumentException {
		String[] scanArray = null;
		if(scanResult.length() == 0 || scanResult.trim().length() == 0){
			//Empty string passed
			throw new IllegalArgumentException("Passed encrypted data can not be empty!");
		}else {
			scanArray = scanResult.split(";");
		}
		return scanArray;

	}
}
