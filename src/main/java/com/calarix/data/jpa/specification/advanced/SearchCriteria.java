package com.calarix.data.jpa.specification.advanced;

import lombok.Data;

@Data
public class SearchCriteria {
    private String key;
    private SearchOperation operation;
    private Object value;
}
