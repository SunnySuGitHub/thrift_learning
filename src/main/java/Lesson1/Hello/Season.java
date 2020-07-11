/**
 * @(#)Season.java, 7月 08, 2020.
 * <p>
 * Copyright 2020 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package Lesson1.Hello;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Optional;

/**
 * @author suxinyu
 */
public enum Season {

    SPRING(1,"春天"),
    SUMMER(2, "夏天"),
    AUTUMN(3, "秋天"),
    WINTER(4, "冬天");

    private int value;

    private String name;

    Season(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Optional<Season> findByInt(int value) {
        for (Season item : Season.values()) {
            if (item.value == value) {
                return Optional.of(item);
            }
        }

        return Optional.empty();
    }

    public static Optional<Season> findByString(String name) {
        for (Season item : Season.values()) {
            if (item.name.equals(name)) {
                return Optional.of(item);
            }
        }

        return Optional.empty();
    }

    @JsonCreator
    public static Season findNullableByString(String name) {
        for (Season item : Season.values()) {
            if (item.name.equals(name)) {
                return item;
            }
        }

        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.name;
    }

    public int toInt() {
        return this.value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
