/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pkix1implicit88;

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

import com.beanit.jasn1.compiler.pkix1explicit88.Attribute;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateSerialNumber;
import com.beanit.jasn1.compiler.pkix1explicit88.DirectoryString;
import com.beanit.jasn1.compiler.pkix1explicit88.Name;
import com.beanit.jasn1.compiler.pkix1explicit88.ORAddress;
import com.beanit.jasn1.compiler.pkix1explicit88.RelativeDistinguishedName;

public class PolicyMappings implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class SEQUENCE implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

		public byte[] code = null;
		public CertPolicyId issuerDomainPolicy = null;
		public CertPolicyId subjectDomainPolicy = null;
		
		public SEQUENCE() {
		}

		public SEQUENCE(byte[] code) {
			this.code = code;
		}

		public SEQUENCE(CertPolicyId issuerDomainPolicy, CertPolicyId subjectDomainPolicy) {
			this.issuerDomainPolicy = issuerDomainPolicy;
			this.subjectDomainPolicy = subjectDomainPolicy;
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
			codeLength += subjectDomainPolicy.encode(reverseOS, true);
			
			codeLength += issuerDomainPolicy.encode(reverseOS, true);
			
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

			if (berTag.equals(CertPolicyId.tag)) {
				issuerDomainPolicy = new CertPolicyId();
				vByteCount += issuerDomainPolicy.decode(is, false);
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match mandatory sequence component.");
			}
			
			if (berTag.equals(CertPolicyId.tag)) {
				subjectDomainPolicy = new CertPolicyId();
				vByteCount += subjectDomainPolicy.decode(is, false);
				if (lengthVal >= 0 && vByteCount == lengthVal) {
					return tlByteCount + vByteCount;
				}
				vByteCount += berTag.decode(is);
			}
			else {
				throw new IOException("Tag does not match mandatory sequence component.");
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
			if (issuerDomainPolicy != null) {
				sb.append("issuerDomainPolicy: ").append(issuerDomainPolicy);
			}
			else {
				sb.append("issuerDomainPolicy: <empty-required-field>");
			}
			
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			if (subjectDomainPolicy != null) {
				sb.append("subjectDomainPolicy: ").append(subjectDomainPolicy);
			}
			else {
				sb.append("subjectDomainPolicy: <empty-required-field>");
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
	public List<SEQUENCE> seqOf = null;

	public PolicyMappings() {
		seqOf = new ArrayList<SEQUENCE>();
	}

	public PolicyMappings(byte[] code) {
		this.code = code;
	}

	public PolicyMappings(List<SEQUENCE> seqOf) {
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

			if (!berTag.equals(SEQUENCE.tag)) {
				throw new IOException("Tag does not match mandatory sequence of/set of component.");
			}
			SEQUENCE element = new SEQUENCE();
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
			Iterator<SEQUENCE> it = seqOf.iterator();
			if (it.hasNext()) {
				it.next().appendAsString(sb, indentLevel + 1);
				while (it.hasNext()) {
					sb.append(",\n");
					for (int i = 0; i < indentLevel + 1; i++) {
						sb.append("\t");
					}
					it.next().appendAsString(sb, indentLevel + 1);
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

