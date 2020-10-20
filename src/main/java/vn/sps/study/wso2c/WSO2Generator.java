/*
 * Class: WSO2AMGenerator
 *
 * Created on Oct 15, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.sps.study.wso2c;

public interface WSO2Generator {

    String generate(String product);

    String productShortName();
}
