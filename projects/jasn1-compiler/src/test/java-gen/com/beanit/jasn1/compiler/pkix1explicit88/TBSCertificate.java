/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1explicit88;

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


public class TBSCertificate implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public Version version = null;
	public CertificateSerialNumber serialNumber = null;
	public AlgorithmIdentifier signature = null;
	public Name issuer = null;
	public Validity validity = null;
	public Name subject = null;
	public SubjectPublicKeyInfo subjectPublicKeyInfo = null;
	public UniqueIdentifier issuerUniqueID = null;
	public UniqueIdentifier subjectUniqueID = null;
	public Extensions extensions = null;
	
	public TBSCertificate() {
	}

	public TBSCertificate(byte[] code) {
		this.code = code;
	}

	public TBSCertificate(Version version, CertificateSerialNumber serialNumber, AlgorithmIdentifier signature, Name issuer, Validity validity, Name subject, SubjectPublicKeyInfo subjectPublicKeyInfo, UniqueIdentifier issuerUniqueID, UniqueIdentifier subjectUniqueID, Extensions extensions) {
		this.version = version;
		this.serialNumber = serialNumber;
		this.signature = signature;
		this.issuer = issuer;
		this.validity = validity;
		this.subject = subject;
		this.subjectPublicKeyInfo = subjectPublicKeyInfo;
		this.issuerUniqueID = issuerUniqueID;
		this.subjectUniqueID = subjectUniqueID;
		this.extensions = extensions;
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
		int sublength;

		if (extensions != null) {
			sublength = extensions.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			reverseOS.write(0xA3);
			codeLength += 1;
		}
		
		if (subjectUniqueID != null) {
			codeLength += subjectUniqueID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
		}
		
		if (issuerUniqueID != null) {
			codeLength += issuerUniqueID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
		}
		
		codeLength += subjectPublicKeyInfo.encode(reverseOS, true);
		
		codeLength += subject.encode(reverseOS);
		
		codeLength += validity.encode(reverseOS, true);
		
		codeLength += issuer.encode(reverseOS);
		
		codeLength += signature.encode(reverseOS, true);
		
		codeLength += serialNumber.encode(reverseOS, true);
		
		if (version != null) {
			sublength = version.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
			codeLength += 1;
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
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			vByteCount += length.decode(is);
			version = new Version();
			vByteCount += version.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(CertificateSerialNumber.tag)) {
			serialNumber = new CertificateSerialNumber();
			vByteCount += serialNumber.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(AlgorithmIdentifier.tag)) {
			signature = new AlgorithmIdentifier();
			vByteCount += signature.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		issuer = new Name();
		numDecodedBytes = issuer.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(Validity.tag)) {
			validity = new Validity();
			vByteCount += validity.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		subject = new Name();
		numDecodedBytes = subject.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(SubjectPublicKeyInfo.tag)) {
			subjectPublicKeyInfo = new SubjectPublicKeyInfo();
			vByteCount += subjectPublicKeyInfo.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			issuerUniqueID = new UniqueIdentifier();
			vByteCount += issuerUniqueID.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			subjectUniqueID = new UniqueIdentifier();
			vByteCount += subjectUniqueID.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 3)) {
			vByteCount += length.decode(is);
			extensions = new Extensions();
			vByteCount += extensions.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
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
		boolean firstSelectedElement = true;
		if (version != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("version: ").append(version);
			firstSelectedElement = false;
		}
		
		if (!firstSelectedElement) {
			sb.append(",\n");
		}
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serialNumber != null) {
			sb.append("serialNumber: ").append(serialNumber);
		}
		else {
			sb.append("serialNumber: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (signature != null) {
			sb.append("signature: ");
			signature.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("signature: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (issuer != null) {
			sb.append("issuer: ");
			issuer.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("issuer: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (validity != null) {
			sb.append("validity: ");
			validity.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("validity: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subject != null) {
			sb.append("subject: ");
			subject.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("subject: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (subjectPublicKeyInfo != null) {
			sb.append("subjectPublicKeyInfo: ");
			subjectPublicKeyInfo.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("subjectPublicKeyInfo: <empty-required-field>");
		}
		
		if (issuerUniqueID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("issuerUniqueID: ").append(issuerUniqueID);
		}
		
		if (subjectUniqueID != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("subjectUniqueID: ").append(subjectUniqueID);
		}
		
		if (extensions != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("extensions: ");
			extensions.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

