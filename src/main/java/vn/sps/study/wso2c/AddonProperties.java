/*
 * Class: AddonProperties
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

import java.util.HashSet;
import java.util.Set;

public class AddonProperties {
    private String sourceDir;

    private Set<MapTo> mapTos = new HashSet<>();

    private String zipName;

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }

    public Set<MapTo> getMapTos() {
        return mapTos;
    }

    public void setMapTos(Set<MapTo> mapTos) {
        this.mapTos = mapTos;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public String getZipName() {
        return zipName;
    }

}
