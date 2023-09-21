package com.uniquenick.service;

import java.util.List;

public interface JavaObjectService {
    String convertJavaObjectToJson(List<String> javaObject);
    List<String> convertJsonToJavaObject(String jsonString);
}