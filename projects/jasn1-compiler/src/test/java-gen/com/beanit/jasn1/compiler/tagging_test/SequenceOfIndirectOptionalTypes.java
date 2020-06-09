/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.tagging_test;

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


public class SequenceOfIndirectOptionalTypes implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private UntaggedInteger untaggedInt = null;
	private ExplicitlyTaggedInteger untaggedInt2 = null;
	private ImplicitlyTaggedInteger untaggedInt3 = null;
	private UntaggedInteger explicitlyTaggedInt = null;
	private ExplicitlyTaggedInteger explicitlyTaggedInt2 = null;
	private ImplicitlyTaggedInteger explicitlyTaggedInt3 = null;
	private UntaggedInteger implicitlyTaggedInt = null;
	private ExplicitlyTaggedInteger implicitlyTaggedInt2 = null;
	private ImplicitlyTaggedInteger implicitlyTaggedInt3 = null;
	private UntaggedChoice untaggedChoice = null;
	private TaggedChoice untaggedChoice2 = null;
	private UntaggedChoice taggedChoice = null;
	private TaggedChoice taggedChoice2 = null;
	private TaggedAny untaggedAny = null;
	private UntaggedAny taggedAny = null;
	private TaggedAny taggedAny2 = null;
	
	public SequenceOfIndirectOptionalTypes() {
	}

	public SequenceOfIndirectOptionalTypes(byte[] code) {
		this.code = code;
	}

	public void setUntaggedInt(UntaggedInteger untaggedInt) {
		this.untaggedInt = untaggedInt;
	}

	public UntaggedInteger getUntaggedInt() {
		return untaggedInt;
	}

	public void setUntaggedInt2(ExplicitlyTaggedInteger untaggedInt2) {
		this.untaggedInt2 = untaggedInt2;
	}

	public ExplicitlyTaggedInteger getUntaggedInt2() {
		return untaggedInt2;
	}

	public void setUntaggedInt3(ImplicitlyTaggedInteger untaggedInt3) {
		this.untaggedInt3 = untaggedInt3;
	}

	public ImplicitlyTaggedInteger getUntaggedInt3() {
		return untaggedInt3;
	}

	public void setExplicitlyTaggedInt(UntaggedInteger explicitlyTaggedInt) {
		this.explicitlyTaggedInt = explicitlyTaggedInt;
	}

	public UntaggedInteger getExplicitlyTaggedInt() {
		return explicitlyTaggedInt;
	}

	public void setExplicitlyTaggedInt2(ExplicitlyTaggedInteger explicitlyTaggedInt2) {
		this.explicitlyTaggedInt2 = explicitlyTaggedInt2;
	}

	public ExplicitlyTaggedInteger getExplicitlyTaggedInt2() {
		return explicitlyTaggedInt2;
	}

	public void setExplicitlyTaggedInt3(ImplicitlyTaggedInteger explicitlyTaggedInt3) {
		this.explicitlyTaggedInt3 = explicitlyTaggedInt3;
	}

	public ImplicitlyTaggedInteger getExplicitlyTaggedInt3() {
		return explicitlyTaggedInt3;
	}

	public void setImplicitlyTaggedInt(UntaggedInteger implicitlyTaggedInt) {
		this.implicitlyTaggedInt = implicitlyTaggedInt;
	}

	public UntaggedInteger getImplicitlyTaggedInt() {
		return implicitlyTaggedInt;
	}

	public void setImplicitlyTaggedInt2(ExplicitlyTaggedInteger implicitlyTaggedInt2) {
		this.implicitlyTaggedInt2 = implicitlyTaggedInt2;
	}

	public ExplicitlyTaggedInteger getImplicitlyTaggedInt2() {
		return implicitlyTaggedInt2;
	}

	public void setImplicitlyTaggedInt3(ImplicitlyTaggedInteger implicitlyTaggedInt3) {
		this.implicitlyTaggedInt3 = implicitlyTaggedInt3;
	}

	public ImplicitlyTaggedInteger getImplicitlyTaggedInt3() {
		return implicitlyTaggedInt3;
	}

	public void setUntaggedChoice(UntaggedChoice untaggedChoice) {
		this.untaggedChoice = untaggedChoice;
	}

	public UntaggedChoice getUntaggedChoice() {
		return untaggedChoice;
	}

	public void setUntaggedChoice2(TaggedChoice untaggedChoice2) {
		this.untaggedChoice2 = untaggedChoice2;
	}

	public TaggedChoice getUntaggedChoice2() {
		return untaggedChoice2;
	}

	public void setTaggedChoice(UntaggedChoice taggedChoice) {
		this.taggedChoice = taggedChoice;
	}

	public UntaggedChoice getTaggedChoice() {
		return taggedChoice;
	}

	public void setTaggedChoice2(TaggedChoice taggedChoice2) {
		this.taggedChoice2 = taggedChoice2;
	}

	public TaggedChoice getTaggedChoice2() {
		return taggedChoice2;
	}

	public void setUntaggedAny(TaggedAny untaggedAny) {
		this.untaggedAny = untaggedAny;
	}

	public TaggedAny getUntaggedAny() {
		return untaggedAny;
	}

	public void setTaggedAny(UntaggedAny taggedAny) {
		this.taggedAny = taggedAny;
	}

	public UntaggedAny getTaggedAny() {
		return taggedAny;
	}

	public void setTaggedAny2(TaggedAny taggedAny2) {
		this.taggedAny2 = taggedAny2;
	}

	public TaggedAny getTaggedAny2() {
		return taggedAny2;
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

		if (taggedAny2 != null) {
			codeLength += taggedAny2.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 18
			reverseOS.write(0xB2);
			codeLength += 1;
		}
		
		if (taggedAny != null) {
			sublength = taggedAny.encode(reverseOS);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
			reverseOS.write(0xA8);
			codeLength += 1;
		}
		
		if (untaggedAny != null) {
			codeLength += untaggedAny.encode(reverseOS, true);
		}
		
		if (taggedChoice2 != null) {
			codeLength += taggedChoice2.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 15
			reverseOS.write(0xAF);
			codeLength += 1;
		}
		
		if (taggedChoice != null) {
			sublength = taggedChoice.encode(reverseOS);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			reverseOS.write(0xA5);
			codeLength += 1;
		}
		
		if (untaggedChoice2 != null) {
			codeLength += untaggedChoice2.encode(reverseOS, true);
		}
		
		if (untaggedChoice != null) {
			codeLength += untaggedChoice.encode(reverseOS);
		}
		
		if (implicitlyTaggedInt3 != null) {
			codeLength += implicitlyTaggedInt3.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 23
			reverseOS.write(0x97);
			codeLength += 1;
		}
		
		if (implicitlyTaggedInt2 != null) {
			codeLength += implicitlyTaggedInt2.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 12
			reverseOS.write(0xAC);
			codeLength += 1;
		}
		
		if (implicitlyTaggedInt != null) {
			codeLength += implicitlyTaggedInt.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
		}
		
		if (explicitlyTaggedInt3 != null) {
			sublength = explicitlyTaggedInt3.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 21
			reverseOS.write(0xB5);
			codeLength += 1;
		}
		
		if (explicitlyTaggedInt2 != null) {
			sublength = explicitlyTaggedInt2.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 11
			reverseOS.write(0xAB);
			codeLength += 1;
		}
		
		if (explicitlyTaggedInt != null) {
			sublength = explicitlyTaggedInt.encode(reverseOS, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(reverseOS, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			reverseOS.write(0xA1);
			codeLength += 1;
		}
		
		if (untaggedInt3 != null) {
			codeLength += untaggedInt3.encode(reverseOS, true);
		}
		
		if (untaggedInt2 != null) {
			codeLength += untaggedInt2.encode(reverseOS, true);
		}
		
		if (untaggedInt != null) {
			codeLength += untaggedInt.encode(reverseOS, true);
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
		if (lengthVal == 0) {
			return tlByteCount;
		}
		vByteCount += berTag.decode(is);

		if (berTag.equals(UntaggedInteger.tag)) {
			untaggedInt = new UntaggedInteger();
			vByteCount += untaggedInt.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(ExplicitlyTaggedInteger.tag)) {
			untaggedInt2 = new ExplicitlyTaggedInteger();
			vByteCount += untaggedInt2.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(ImplicitlyTaggedInteger.tag)) {
			untaggedInt3 = new ImplicitlyTaggedInteger();
			vByteCount += untaggedInt3.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			vByteCount += length.decode(is);
			explicitlyTaggedInt = new UntaggedInteger();
			vByteCount += explicitlyTaggedInt.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 11)) {
			vByteCount += length.decode(is);
			explicitlyTaggedInt2 = new ExplicitlyTaggedInteger();
			vByteCount += explicitlyTaggedInt2.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 21)) {
			vByteCount += length.decode(is);
			explicitlyTaggedInt3 = new ImplicitlyTaggedInteger();
			vByteCount += explicitlyTaggedInt3.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			implicitlyTaggedInt = new UntaggedInteger();
			vByteCount += implicitlyTaggedInt.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 12)) {
			implicitlyTaggedInt2 = new ExplicitlyTaggedInteger();
			vByteCount += implicitlyTaggedInt2.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 23)) {
			implicitlyTaggedInt3 = new ImplicitlyTaggedInteger();
			vByteCount += implicitlyTaggedInt3.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		untaggedChoice = new UntaggedChoice();
		numDecodedBytes = untaggedChoice.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			untaggedChoice = null;
		}
		if (berTag.equals(TaggedChoice.tag)) {
			untaggedChoice2 = new TaggedChoice();
			vByteCount += untaggedChoice2.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			vByteCount += length.decode(is);
			taggedChoice = new UntaggedChoice();
			vByteCount += taggedChoice.decode(is, null);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 15)) {
			taggedChoice2 = new TaggedChoice();
			vByteCount += taggedChoice2.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(TaggedAny.tag)) {
			untaggedAny = new TaggedAny();
			vByteCount += untaggedAny.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 8)) {
			vByteCount += length.decode(is);
			taggedAny = new UntaggedAny();
			vByteCount += taggedAny.decode(is, null);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 18)) {
			taggedAny2 = new TaggedAny();
			vByteCount += taggedAny2.decode(is, false);
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
		if (untaggedInt != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedInt: ").append(untaggedInt);
			firstSelectedElement = false;
		}
		
		if (untaggedInt2 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedInt2: ").append(untaggedInt2);
			firstSelectedElement = false;
		}
		
		if (untaggedInt3 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedInt3: ").append(untaggedInt3);
			firstSelectedElement = false;
		}
		
		if (explicitlyTaggedInt != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("explicitlyTaggedInt: ").append(explicitlyTaggedInt);
			firstSelectedElement = false;
		}
		
		if (explicitlyTaggedInt2 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("explicitlyTaggedInt2: ").append(explicitlyTaggedInt2);
			firstSelectedElement = false;
		}
		
		if (explicitlyTaggedInt3 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("explicitlyTaggedInt3: ").append(explicitlyTaggedInt3);
			firstSelectedElement = false;
		}
		
		if (implicitlyTaggedInt != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("implicitlyTaggedInt: ").append(implicitlyTaggedInt);
			firstSelectedElement = false;
		}
		
		if (implicitlyTaggedInt2 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("implicitlyTaggedInt2: ").append(implicitlyTaggedInt2);
			firstSelectedElement = false;
		}
		
		if (implicitlyTaggedInt3 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("implicitlyTaggedInt3: ").append(implicitlyTaggedInt3);
			firstSelectedElement = false;
		}
		
		if (untaggedChoice != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedChoice: ");
			untaggedChoice.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (untaggedChoice2 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedChoice2: ");
			untaggedChoice2.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (taggedChoice != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("taggedChoice: ");
			taggedChoice.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (taggedChoice2 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("taggedChoice2: ");
			taggedChoice2.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (untaggedAny != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedAny: ").append(untaggedAny);
			firstSelectedElement = false;
		}
		
		if (taggedAny != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("taggedAny: ").append(taggedAny);
			firstSelectedElement = false;
		}
		
		if (taggedAny2 != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("taggedAny2: ").append(taggedAny2);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

