package heap.stark.nio.timeServer;

/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-06-23")
public class Bean implements org.apache.thrift.TBase<Bean, Bean._Fields>, java.io.Serializable, Cloneable, Comparable<Bean> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("heap.stark.thrift.Bean");

  private static final org.apache.thrift.protocol.TField INT_TEST_FIELD_DESC = new org.apache.thrift.protocol.TField("intTest", org.apache.thrift.protocol.TType.I32, (short)-1);
  private static final org.apache.thrift.protocol.TField LONG_TEST_FIELD_DESC = new org.apache.thrift.protocol.TField("longTest", org.apache.thrift.protocol.TType.I64, (short)-2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BeanStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BeanTupleSchemeFactory();

  public int intTest; // required
  public long longTest; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INT_TEST((short)-1, "intTest"),
    LONG_TEST((short)-2, "longTest");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case -1: // INT_TEST
          return INT_TEST;
        case -2: // LONG_TEST
          return LONG_TEST;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __INTTEST_ISSET_ID = 0;
  private static final int __LONGTEST_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INT_TEST, new org.apache.thrift.meta_data.FieldMetaData("intTest", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LONG_TEST, new org.apache.thrift.meta_data.FieldMetaData("longTest", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Bean.class, metaDataMap);
  }

  public Bean() {
  }

  public Bean(
    int intTest,
    long longTest)
  {
    this();
    this.intTest = intTest;
    setIntTestIsSet(true);
    this.longTest = longTest;
    setLongTestIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Bean(Bean other) {
    __isset_bitfield = other.__isset_bitfield;
    this.intTest = other.intTest;
    this.longTest = other.longTest;
  }

  public Bean deepCopy() {
    return new Bean(this);
  }

  @Override
  public void clear() {
    setIntTestIsSet(false);
    this.intTest = 0;
    setLongTestIsSet(false);
    this.longTest = 0;
  }

  public int getIntTest() {
    return this.intTest;
  }

  public Bean setIntTest(int intTest) {
    this.intTest = intTest;
    setIntTestIsSet(true);
    return this;
  }

  public void unsetIntTest() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __INTTEST_ISSET_ID);
  }

  /** Returns true if field intTest is set (has been assigned a value) and false otherwise */
  public boolean isSetIntTest() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __INTTEST_ISSET_ID);
  }

  public void setIntTestIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __INTTEST_ISSET_ID, value);
  }

  public long getLongTest() {
    return this.longTest;
  }

  public Bean setLongTest(long longTest) {
    this.longTest = longTest;
    setLongTestIsSet(true);
    return this;
  }

  public void unsetLongTest() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LONGTEST_ISSET_ID);
  }

  /** Returns true if field longTest is set (has been assigned a value) and false otherwise */
  public boolean isSetLongTest() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LONGTEST_ISSET_ID);
  }

  public void setLongTestIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LONGTEST_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case INT_TEST:
      if (value == null) {
        unsetIntTest();
      } else {
        setIntTest((Integer)value);
      }
      break;

    case LONG_TEST:
      if (value == null) {
        unsetLongTest();
      } else {
        setLongTest((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INT_TEST:
      return getIntTest();

    case LONG_TEST:
      return getLongTest();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case INT_TEST:
      return isSetIntTest();
    case LONG_TEST:
      return isSetLongTest();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Bean)
      return this.equals((Bean)that);
    return false;
  }

  public boolean equals(Bean that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_intTest = true;
    boolean that_present_intTest = true;
    if (this_present_intTest || that_present_intTest) {
      if (!(this_present_intTest && that_present_intTest))
        return false;
      if (this.intTest != that.intTest)
        return false;
    }

    boolean this_present_longTest = true;
    boolean that_present_longTest = true;
    if (this_present_longTest || that_present_longTest) {
      if (!(this_present_longTest && that_present_longTest))
        return false;
      if (this.longTest != that.longTest)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + intTest;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(longTest);

    return hashCode;
  }

  @Override
  public int compareTo(Bean other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetIntTest()).compareTo(other.isSetIntTest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIntTest()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.intTest, other.intTest);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLongTest()).compareTo(other.isSetLongTest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLongTest()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.longTest, other.longTest);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("heap.stark.thrift.Bean(");
    boolean first = true;

    sb.append("intTest:");
    sb.append(this.intTest);
    first = false;
    if (!first) sb.append(", ");
    sb.append("longTest:");
    sb.append(this.longTest);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BeanStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BeanStandardScheme getScheme() {
      return new BeanStandardScheme();
    }
  }

  private static class BeanStandardScheme extends org.apache.thrift.scheme.StandardScheme<Bean> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Bean struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case -1: // INT_TEST
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.intTest = iprot.readI32();
              struct.setIntTestIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case -2: // LONG_TEST
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.longTest = iprot.readI64();
              struct.setLongTestIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Bean struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(LONG_TEST_FIELD_DESC);
      oprot.writeI64(struct.longTest);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(INT_TEST_FIELD_DESC);
      oprot.writeI32(struct.intTest);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BeanTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BeanTupleScheme getScheme() {
      return new BeanTupleScheme();
    }
  }

  private static class BeanTupleScheme extends org.apache.thrift.scheme.TupleScheme<Bean> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Bean struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetIntTest()) {
        optionals.set(0);
      }
      if (struct.isSetLongTest()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetIntTest()) {
        oprot.writeI32(struct.intTest);
      }
      if (struct.isSetLongTest()) {
        oprot.writeI64(struct.longTest);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Bean struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.intTest = iprot.readI32();
        struct.setIntTestIsSet(true);
      }
      if (incoming.get(1)) {
        struct.longTest = iprot.readI64();
        struct.setLongTestIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

