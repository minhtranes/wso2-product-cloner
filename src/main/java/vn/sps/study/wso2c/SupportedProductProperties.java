/*
 * Class: SupportedProductProperties
 *
 * Created on Oct 16, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.wso2c;

import java.util.HashMap;
import java.util.Map;

public class SupportedProductProperties {
    Map<String, AddonProperties> products = new HashMap<>();

    public Map<String, AddonProperties> getProducts() {
        return products;
    }

    public void setProducts(Map<String, AddonProperties> products) {
        this.products = products;
    }

}
