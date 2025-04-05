package com.marlonzl7.kon.converters;

import java.util.List;

public interface Converter {
    public double convert(String from, String to, double value);
    public List<String> getSupportedConversions();
    public String getConversionByIndex(int index);
}
