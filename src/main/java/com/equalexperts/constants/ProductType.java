package com.equalexperts.constants;

public enum ProductType {
    Cheerios("cheerios"),
    Cornflakes("cornflakes"),
    Frosties("frosties"),
    Shreddies("shreddies"),
    Weetabix("weetabix");

    private final String apiName;

    ProductType(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return apiName;
    }

    public String getEndpoint() {
        return "/backend-take-home-test-data/" + apiName + ".json";
    }
}
