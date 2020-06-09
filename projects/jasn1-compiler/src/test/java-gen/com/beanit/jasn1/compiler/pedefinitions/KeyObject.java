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


public class KeyObject implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class KeyCompontents implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		public static class SEQUENCE implements BerType, Serializable {

			private static final long serialVersionUID = 1L;

			public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

			public byte[] code = null;
			public BerOctetString keyType = null;
			public BerOctetString keyData = null;
			public UInt8 macLength = null;
			
			public SEQUENCE() {
			}

			public SEQUENCE(byte[] code) {
				this.code = code;
			}

			public SEQUENCE(BerOctetString keyType, BerOctetString keyData, UInt8 macLength) {
				this.keyType = keyType;
				this.keyData = keyData;
				this.macLength = macLength;
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
				if (macLength != null) {
					codeLength += macLength.encode(reverseOS, false);
					// write tag: CONTEXT_CLASS, PRIMITIVE, 7
					reverseOS.write(0x87);
					codeLength += 1;
				}
				
				codeLength += keyData.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 6
				reverseOS.write(0x86);
				codeLength += 1;
				
				codeLength += keyType.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				reverseOS.write(0x80);
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

				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
					keyType = new BerOctetString();
					vByteCount += keyType.decode(is, false);
					vByteCount += berTag.decode(is);
				}
				else {
					throw new IOException("Tag does not match mandatory sequence component.");
				}
				
				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 6)) {
					keyData = new BerOctetString();
					vByteCount += keyData.decode(is, false);
					if (lengthVal >= 0 && vByteCount == lengthVal) {
						return tlByteCount + vByteCount;
					}
					vByteCount += berTag.decode(is);
				}
				else {
					throw new IOException("Tag does not match mandatory sequence component.");
				}
				
				if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 7)) {
					macLength = new UInt8();
					vByteCount += macLength.decode(is, false);
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
				if (keyType != null) {
					sb.append("keyType: ").append(keyType);
				}
				else {
					sb.append("keyType: <empty-required-field>");
				}
				
				sb.append(",\n");
				for (int i = 0; i < indentLevel + 1; i++) {
					sb.append("\t");
				}
				if (keyData != null) {
					sb.append("keyData: ").append(keyData);
				}
				else {
					sb.append("keyData: <empty-required-field>");
				}
				
				if (macLength != null) {
					sb.append(",\n");
					for (int i = 0; i < indentLevel + 1; i++) {
						sb.append("\t");
					}
					sb.append("macLength: ").append(macLength);
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

		public KeyCompontents() {
			seqOf = new ArrayList<SEQUENCE>();
		}

		public KeyCompontents(byte[] code) {
			this.code = code;
		}

		public KeyCompontents(List<SEQUENCE> seqOf) {
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

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public BerOctetString keyUsageQualifier = null;
	public BerOctetString keyAccess = null;
	public BerOctetString keyIdentifier = null;
	public BerOctetString keyVersionNumber = null;
	public BerOctetString keyCounterValue = null;
	public KeyCompontents keyCompontents = null;
	
	public KeyObject() {
	}

	public KeyObject(byte[] code) {
		this.code = code;
	}

	public KeyObject(BerOctetString keyUsageQualifier, BerOctetString keyAccess, BerOctetString keyIdentifier, BerOctetString keyVersionNumber, BerOctetString keyCounterValue, KeyCompontents keyCompontents) {
		this.keyUsageQualifier = keyUsageQualifier;
		this.keyAccess = keyAccess;
		this.keyIdentifier = keyIdentifier;
		this.keyVersionNumber = keyVersionNumber;
		this.keyCounterValue = keyCounterValue;
		this.keyCompontents = keyCompontents;
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
		codeLength += keyCompontents.encode(reverseOS, true);
		
		if (keyCounterValue != null) {
			codeLength += keyCounterValue.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 5
			reverseOS.write(0x85);
			codeLength += 1;
		}
		
		codeLength += keyVersionNumber.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 3
		reverseOS.write(0x83);
		codeLength += 1;
		
		codeLength += keyIdentifier.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		reverseOS.write(0x82);
		codeLength += 1;
		
		if (keyAccess != null) {
			codeLength += keyAccess.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 22
			reverseOS.write(0x96);
			codeLength += 1;
		}
		
		codeLength += keyUsageQualifier.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 21
		reverseOS.write(0x95);
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

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 21)) {
			keyUsageQualifier = new BerOctetString();
			vByteCount += keyUsageQualifier.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 22)) {
			keyAccess = new BerOctetString();
			vByteCount += keyAccess.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			keyIdentifier = new BerOctetString();
			vByteCount += keyIdentifier.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			keyVersionNumber = new BerOctetString();
			vByteCount += keyVersionNumber.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			keyCounterValue = new BerOctetString();
			vByteCount += keyCounterValue.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(KeyCompontents.tag)) {
			keyCompontents = new KeyCompontents();
			vByteCount += keyCompontents.decode(is, false);
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
		if (keyUsageQualifier != null) {
			sb.append("keyUsageQualifier: ").append(keyUsageQualifier);
		}
		else {
			sb.append("keyUsageQualifier: <empty-required-field>");
		}
		
		if (keyAccess != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("keyAccess: ").append(keyAccess);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (keyIdentifier != null) {
			sb.append("keyIdentifier: ").append(keyIdentifier);
		}
		else {
			sb.append("keyIdentifier: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (keyVersionNumber != null) {
			sb.append("keyVersionNumber: ").append(keyVersionNumber);
		}
		else {
			sb.append("keyVersionNumber: <empty-required-field>");
		}
		
		if (keyCounterValue != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("keyCounterValue: ").append(keyCounterValue);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (keyCompontents != null) {
			sb.append("keyCompontents: ");
			keyCompontents.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("keyCompontents: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

