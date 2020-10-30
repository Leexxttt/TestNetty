package IM.serialize;

public interface Serializer {
    byte JSON_SERIALIZER = 1;
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     */
    byte getSerializerAlgorithm();

    /**
     * 对象转为二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转为对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
