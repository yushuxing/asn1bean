/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pedefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class ApplicationInstance implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class ProcessData implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public ProcessData() {
			seqOf = new ArrayList<BerOctetString>();
		}

		public ProcessData(byte[] code) {
			this.code = code;
		}

		public ProcessData(List<BerOctetString> seqOf) {
			this.seqOf = seqOf;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {
			return encode(reverseOS, true);
		}

		public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

			if (code != null) {
				reverseOS.write(code);
				if (withTag) {
					return tag.encode(reverseOS) + code.length;
				}
				return code.length;
			}

			int codeLength = 0;
			for (int i = (seqOf.size() - 1); i >= 0; i--) {
				codeLength += seqOf.get(i).encode(reverseOS, true);
			}

			codeLength += BerLength.encodeLength(reverseOS, codeLength);

			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}

			return codeLength;
		}

		@Override public int decode(InputStream is) throws IOException {
			return decode(is, true);
		}

		public int decode(InputStream is, boolean withTag) throws IOException {
			int tlByteCount = 0;
			int vByteCount = 0;
			BerTag berTag = new BerTag();
			if (withTag) {
				tlByteCount += tag.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			tlByteCount += length.decode(is);
			int lengthVal = length.val;

			while (vByteCount < lengthVal || lengthVal < 0) {
				vByteCount += berTag.decode(is);

				if (lengthVal < 0 && berTag.equals(0, 0, 0)) {
					vByteCount += BerLength.readEocByte(is);
					break;
				}

				if (!berTag.equals(BerOctetString.tag)) {
					throw new IOException("Tag does not match mandatory sequence of/set of component.");
				}
				BerOctetString element = new BerOctetString();
				vByteCount += element.decode(is, false);
				seqOf.add(element);
			}
			if (lengthVal >= 0 && vByteCount != lengthVal) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + lengthVal + " but has " + vByteCount);

			}
			return tlByteCount + vByteCount;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS, false);
			code = reverseOS.getArray();
		}

		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			sb.append("{\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(",\n");
						for (int i = 0; i < indentLevel + 1; i++) {
							sb.append("\t");
						}
						sb.append(it.next());
					}
				}
			}

			sb.append("\n");
			for (int i = 0; i < indentLevel; i++) {
				sb.append("\t");
			}
			sb.append("}");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public ApplicationIdentifier applicationLoadPackageAID = null;
	public ApplicationIdentifier classAID = null;
	public ApplicationIdentifier instanceAID = null;
	public ApplicationIdentifier extraditeSecurityDomainAID = null;
	public BerOctetString applicationPrivileges = null;
	public BerOctetString lifeCycleState = null;
	public BerOctetString applicationSpecificParametersC9 = null;
	public ApplicationSystemParameters systemSpecificParameters = null;
	public UICCApplicationParameters applicationParameters = null;
	public ProcessData processData = null;
	
	public ApplicationInstance() {
	}

	public ApplicationInstance(byte[] code) {
		this.code = code;
	}

	public ApplicationInstance(ApplicationIdentifier applicationLoadPackageAID, ApplicationIdentifier classAID, ApplicationIdentifier instanceAID, ApplicationIdentifier extraditeSecurityDomainAID, BerOctetString applicationPrivileges, BerOctetString lifeCycleState, BerOctetString applicationSpecificParametersC9, ApplicationSystemParameters systemSpecificParameters, UICCApplicationParameters applicationParameters, ProcessData processData) {
		this.applicationLoadPackageAID = applicationLoadPackageAID;
		this.classAID = classAID;
		this.instanceAID = instanceAID;
		this.extraditeSecurityDomainAID = extraditeSecurityDomainAID;
		this.applicationPrivileges = applicationPrivileges;
		this.lifeCycleState = lifeCycleState;
		this.applicationSpecificParametersC9 = applicationSpecificParametersC9;
		this.systemSpecificParameters = systemSpecificParameters;
		this.applicationParameters = applicationParameters;
		this.processData = processData;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (processData != null) {
			codeLength += processData.encode(reverseOS, true);
		}
		
		if (applicationParameters != null) {
			codeLength += applicationParameters.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, CONSTRUCTED, 10
			reverseOS.write(0xEA);
			codeLength += 1;
		}
		
		if (systemSpecificParameters != null) {
			codeLength += systemSpecificParameters.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, CONSTRUCTED, 15
			reverseOS.write(0xEF);
			codeLength += 1;
		}
		
		codeLength += applicationSpecificParametersC9.encode(reverseOS, false);
		// write tag: PRIVATE_CLASS, PRIMITIVE, 9
		reverseOS.write(0xC9);
		codeLength += 1;
		
		if (lifeCycleState != null) {
			codeLength += lifeCycleState.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			reverseOS.write(0x83);
			codeLength += 1;
		}
		
		codeLength += applicationPrivileges.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		reverseOS.write(0x82);
		codeLength += 1;
		
		if (extraditeSecurityDomainAID != null) {
			codeLength += extraditeSecurityDomainAID.encode(reverseOS, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			reverseOS.write(0x4F);
			codeLength += 1;
		}
		
		codeLength += instanceAID.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		reverseOS.write(0x4F);
		codeLength += 1;
		
		codeLength += classAID.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		reverseOS.write(0x4F);
		codeLength += 1;
		
		codeLength += applicationLoadPackageAID.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 15
		reverseOS.write(0x4F);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			applicationLoadPackageAID = new ApplicationIdentifier();
			vByteCount += applicationLoadPackageAID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			classAID = new ApplicationIdentifier();
			vByteCount += classAID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			instanceAID = new ApplicationIdentifier();
			vByteCount += instanceAID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 15)) {
			extraditeSecurityDomainAID = new ApplicationIdentifier();
			vByteCount += extraditeSecurityDomainAID.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			applicationPrivileges = new BerOctetString();
			vByteCount += applicationPrivileges.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			lifeCycleState = new BerOctetString();
			vByteCount += lifeCycleState.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 9)) {
			applicationSpecificParametersC9 = new BerOctetString();
			vByteCount += applicationSpecificParametersC9.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 15)) {
			systemSpecificParameters = new ApplicationSystemParameters();
			vByteCount += systemSpecificParameters.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.CONSTRUCTED, 10)) {
			applicationParameters = new UICCApplicationParameters();
			vByteCount += applicationParameters.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(ProcessData.tag)) {
			processData = new ProcessData();
			vByteCount += processData.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (applicationLoadPackageAID != null) {
			sb.append("applicationLoadPackageAID: ").append(applicationLoadPackageAID);
		}
		else {
			sb.append("applicationLoadPackageAID: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (classAID != null) {
			sb.append("classAID: ").append(classAID);
		}
		else {
			sb.append("classAID: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (instanceAID != null) {
			sb.append("instanceAID: ").append(instanceAID);
		}
		else {
			sb.append("instanceAID: <empty-required-field>");
		}
		
		if (extraditeSecurityDomainAID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("extraditeSecurityDomainAID: ").append(extraditeSecurityDomainAID);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (applicationPrivileges != null) {
			sb.append("applicationPrivileges: ").append(applicationPrivileges);
		}
		else {
			sb.append("applicationPrivileges: <empty-required-field>");
		}
		
		if (lifeCycleState != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("lifeCycleState: ").append(lifeCycleState);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (applicationSpecificParametersC9 != null) {
			sb.append("applicationSpecificParametersC9: ").append(applicationSpecificParametersC9);
		}
		else {
			sb.append("applicationSpecificParametersC9: <empty-required-field>");
		}
		
		if (systemSpecificParameters != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("systemSpecificParameters: ");
			systemSpecificParameters.appendAsString(sb, indentLevel + 1);
		}
		
		if (applicationParameters != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("applicationParameters: ");
			applicationParameters.appendAsString(sb, indentLevel + 1);
		}
		
		if (processData != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("processData: ");
			processData.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

