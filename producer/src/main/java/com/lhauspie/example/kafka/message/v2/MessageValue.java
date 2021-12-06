/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.lhauspie.example.kafka.message.v2;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class MessageValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1312083456623378044L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MessageValue\",\"namespace\":\"com.lhauspie.example.kafka.message\",\"fields\":[{\"name\":\"orgId\",\"type\":[\"null\",\"string\"]},{\"name\":\"objectId\",\"type\":[\"null\",\"string\"]},{\"name\":\"code\",\"type\":[\"null\",\"string\"]},{\"name\":\"label\",\"type\":[\"null\",\"string\"]},{\"name\":\"value\",\"type\":[\"null\",\"int\"]},{\"name\":\"dateTime\",\"type\":[\"null\",{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = SpecificData.get(); // Modified since new SpecificData() is not working well
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<MessageValue> ENCODER =
      new BinaryMessageEncoder<MessageValue>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MessageValue> DECODER =
      new BinaryMessageDecoder<MessageValue>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MessageValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MessageValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MessageValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<MessageValue>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MessageValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MessageValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MessageValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MessageValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private CharSequence orgId;
  private CharSequence objectId;
  private CharSequence code;
  private CharSequence label;
  private Integer value;
  private java.time.Instant dateTime;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MessageValue() {}

  /**
   * All-args constructor.
   * @param orgId The new value for orgId
   * @param objectId The new value for objectId
   * @param code The new value for code
   * @param label The new value for label
   * @param value The new value for value
   * @param dateTime The new value for dateTime
   */
  public MessageValue(CharSequence orgId, CharSequence objectId, CharSequence code, CharSequence label, Integer value, java.time.Instant dateTime) {
    this.orgId = orgId;
    this.objectId = objectId;
    this.code = code;
    this.label = label;
    this.value = value;
    this.dateTime = dateTime;
  }

  public SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return orgId;
    case 1: return objectId;
    case 2: return code;
    case 3: return label;
    case 4: return value;
    case 5: return dateTime;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: orgId = (CharSequence)value$; break;
    case 1: objectId = (CharSequence)value$; break;
    case 2: code = (CharSequence)value$; break;
    case 3: label = (CharSequence)value$; break;
    case 4: value = (Integer)value$; break;
    case 5: dateTime = (java.time.Instant)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'orgId' field.
   * @return The value of the 'orgId' field.
   */
  public CharSequence getOrgId() {
    return orgId;
  }


  /**
   * Sets the value of the 'orgId' field.
   * @param value the value to set.
   */
  public void setOrgId(CharSequence value) {
    this.orgId = value;
  }

  /**
   * Gets the value of the 'objectId' field.
   * @return The value of the 'objectId' field.
   */
  public CharSequence getObjectId() {
    return objectId;
  }


  /**
   * Sets the value of the 'objectId' field.
   * @param value the value to set.
   */
  public void setObjectId(CharSequence value) {
    this.objectId = value;
  }

  /**
   * Gets the value of the 'code' field.
   * @return The value of the 'code' field.
   */
  public CharSequence getCode() {
    return code;
  }


  /**
   * Sets the value of the 'code' field.
   * @param value the value to set.
   */
  public void setCode(CharSequence value) {
    this.code = value;
  }

  /**
   * Gets the value of the 'label' field.
   * @return The value of the 'label' field.
   */
  public CharSequence getLabel() {
    return label;
  }


  /**
   * Sets the value of the 'label' field.
   * @param value the value to set.
   */
  public void setLabel(CharSequence value) {
    this.label = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public Integer getValue() {
    return value;
  }


  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(Integer value) {
    this.value = value;
  }

  /**
   * Gets the value of the 'dateTime' field.
   * @return The value of the 'dateTime' field.
   */
  public java.time.Instant getDateTime() {
    return dateTime;
  }


  /**
   * Sets the value of the 'dateTime' field.
   * @param value the value to set.
   */
  public void setDateTime(java.time.Instant value) {
    this.dateTime = value;
  }

  /**
   * Creates a new MessageValue RecordBuilder.
   * @return A new MessageValue RecordBuilder
   */
  public static MessageValue.Builder newBuilder() {
    return new MessageValue.Builder();
  }

  /**
   * Creates a new MessageValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MessageValue RecordBuilder
   */
  public static MessageValue.Builder newBuilder(MessageValue.Builder other) {
    if (other == null) {
      return new MessageValue.Builder();
    } else {
      return new MessageValue.Builder(other);
    }
  }

  /**
   * Creates a new MessageValue RecordBuilder by copying an existing MessageValue instance.
   * @param other The existing instance to copy.
   * @return A new MessageValue RecordBuilder
   */
  public static MessageValue.Builder newBuilder(MessageValue other) {
    if (other == null) {
      return new MessageValue.Builder();
    } else {
      return new MessageValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for MessageValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MessageValue>
    implements org.apache.avro.data.RecordBuilder<MessageValue> {

    private CharSequence orgId;
    private CharSequence objectId;
    private CharSequence code;
    private CharSequence label;
    private Integer value;
    private java.time.Instant dateTime;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(MessageValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.orgId)) {
        this.orgId = data().deepCopy(fields()[0].schema(), other.orgId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.objectId)) {
        this.objectId = data().deepCopy(fields()[1].schema(), other.objectId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.code)) {
        this.code = data().deepCopy(fields()[2].schema(), other.code);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.label)) {
        this.label = data().deepCopy(fields()[3].schema(), other.label);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.value)) {
        this.value = data().deepCopy(fields()[4].schema(), other.value);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.dateTime)) {
        this.dateTime = data().deepCopy(fields()[5].schema(), other.dateTime);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing MessageValue instance
     * @param other The existing instance to copy.
     */
    private Builder(MessageValue other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.orgId)) {
        this.orgId = data().deepCopy(fields()[0].schema(), other.orgId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.objectId)) {
        this.objectId = data().deepCopy(fields()[1].schema(), other.objectId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.code)) {
        this.code = data().deepCopy(fields()[2].schema(), other.code);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.label)) {
        this.label = data().deepCopy(fields()[3].schema(), other.label);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.value)) {
        this.value = data().deepCopy(fields()[4].schema(), other.value);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.dateTime)) {
        this.dateTime = data().deepCopy(fields()[5].schema(), other.dateTime);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'orgId' field.
      * @return The value.
      */
    public CharSequence getOrgId() {
      return orgId;
    }


    /**
      * Sets the value of the 'orgId' field.
      * @param value The value of 'orgId'.
      * @return This builder.
      */
    public MessageValue.Builder setOrgId(CharSequence value) {
      validate(fields()[0], value);
      this.orgId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'orgId' field has been set.
      * @return True if the 'orgId' field has been set, false otherwise.
      */
    public boolean hasOrgId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'orgId' field.
      * @return This builder.
      */
    public MessageValue.Builder clearOrgId() {
      orgId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'objectId' field.
      * @return The value.
      */
    public CharSequence getObjectId() {
      return objectId;
    }


    /**
      * Sets the value of the 'objectId' field.
      * @param value The value of 'objectId'.
      * @return This builder.
      */
    public MessageValue.Builder setObjectId(CharSequence value) {
      validate(fields()[1], value);
      this.objectId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'objectId' field has been set.
      * @return True if the 'objectId' field has been set, false otherwise.
      */
    public boolean hasObjectId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'objectId' field.
      * @return This builder.
      */
    public MessageValue.Builder clearObjectId() {
      objectId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'code' field.
      * @return The value.
      */
    public CharSequence getCode() {
      return code;
    }


    /**
      * Sets the value of the 'code' field.
      * @param value The value of 'code'.
      * @return This builder.
      */
    public MessageValue.Builder setCode(CharSequence value) {
      validate(fields()[2], value);
      this.code = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'code' field has been set.
      * @return True if the 'code' field has been set, false otherwise.
      */
    public boolean hasCode() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'code' field.
      * @return This builder.
      */
    public MessageValue.Builder clearCode() {
      code = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'label' field.
      * @return The value.
      */
    public CharSequence getLabel() {
      return label;
    }


    /**
      * Sets the value of the 'label' field.
      * @param value The value of 'label'.
      * @return This builder.
      */
    public MessageValue.Builder setLabel(CharSequence value) {
      validate(fields()[3], value);
      this.label = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'label' field has been set.
      * @return True if the 'label' field has been set, false otherwise.
      */
    public boolean hasLabel() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'label' field.
      * @return This builder.
      */
    public MessageValue.Builder clearLabel() {
      label = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public Integer getValue() {
      return value;
    }


    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public MessageValue.Builder setValue(Integer value) {
      validate(fields()[4], value);
      this.value = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public MessageValue.Builder clearValue() {
      value = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'dateTime' field.
      * @return The value.
      */
    public java.time.Instant getDateTime() {
      return dateTime;
    }


    /**
      * Sets the value of the 'dateTime' field.
      * @param value The value of 'dateTime'.
      * @return This builder.
      */
    public MessageValue.Builder setDateTime(java.time.Instant value) {
      validate(fields()[5], value);
      this.dateTime = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'dateTime' field has been set.
      * @return True if the 'dateTime' field has been set, false otherwise.
      */
    public boolean hasDateTime() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'dateTime' field.
      * @return This builder.
      */
    public MessageValue.Builder clearDateTime() {
      dateTime = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MessageValue build() {
      try {
        MessageValue record = new MessageValue();
        record.orgId = fieldSetFlags()[0] ? this.orgId : (CharSequence) defaultValue(fields()[0]);
        record.objectId = fieldSetFlags()[1] ? this.objectId : (CharSequence) defaultValue(fields()[1]);
        record.code = fieldSetFlags()[2] ? this.code : (CharSequence) defaultValue(fields()[2]);
        record.label = fieldSetFlags()[3] ? this.label : (CharSequence) defaultValue(fields()[3]);
        record.value = fieldSetFlags()[4] ? this.value : (Integer) defaultValue(fields()[4]);
        record.dateTime = fieldSetFlags()[5] ? this.dateTime : (java.time.Instant) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MessageValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<MessageValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MessageValue>
    READER$ = (org.apache.avro.io.DatumReader<MessageValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










