package IM.attribute;

import io.netty.util.AttributeKey;

/**
 * @author lixt
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
