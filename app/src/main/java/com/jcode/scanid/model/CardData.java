package com.jcode.scanid.model;

import java.util.Date;

/**
 * Created by otimj on 8/17/2019.
 */
public class CardData {
	private String mSurName;
	private String mGivenName;
	private String mOtherName;
	private Date mDateOfBirth;
	private String mNationalId;
	private String mDocumentNumber;
	private Date mDateOfIssue;
	private Date mDateOfExpiry;
	private String mFingerPrintData;
	private int mFingerPrintMinuatiaCount;
	private String mOtherData;

	//TODO Add logic to identify fingerprints e.g. LEFT_THUMB etc

	public CardData(){


	}

	public String getGivenName() {
		return mGivenName;
	}

	public void setGivenName(String givenName) {
		this.mGivenName = givenName;
	}

	public String getSurName() {
		return mSurName;
	}

	public void setSurName(String surName) {
		this.mSurName = surName;
	}

	public String getOtherName() {
		return mOtherName;
	}

	public void setOtherName(String otherName) {
		this.mOtherName = otherName;
	}

	public Date getDateOfBirth() {
		return mDateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.mDateOfBirth = dateOfBirth;
	}

	public String getNationalId() {
		return mNationalId;
	}

	public void setNationalId(String nationalId) {
		this.mNationalId = nationalId;
	}

	public Date getDateOfIssue() {
		return mDateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.mDateOfIssue = dateOfIssue;
	}

	public Date getDateOfExpiry() {
		return mDateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.mDateOfExpiry = dateOfExpiry;
	}

	public String getDocumentNumber() {
		return mDocumentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		mDocumentNumber = documentNumber;
	}

	public String getFingerPrintData() {
		return mFingerPrintData;
	}

	public void setFingerPrintData(String fingerPrintData) {
		mFingerPrintData = fingerPrintData;
	}

	public int getFingerPrintMinuatiaCount() {
		return mFingerPrintMinuatiaCount;
	}

	public void setFingerPrintMinuatiaCount(int fingerPrintMinuatiaCount) {
		mFingerPrintMinuatiaCount = fingerPrintMinuatiaCount;
	}

	public String getOtherData() {
		return mOtherData;
	}

	public void setOtherData(String otherData) {
		mOtherData = otherData;
	}
}

