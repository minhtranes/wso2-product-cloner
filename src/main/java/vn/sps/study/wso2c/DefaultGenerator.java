/*
 * Class: WSO2310Generator
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultGenerator extends AbstractGenerator
        implements WSO2Generator {

    private static Logger LOGGER = LoggerFactory
        .getLogger(DefaultGenerator.class);

    @Autowired
    private SupportedProductProperties productProperties;

    @Value("${source.path}")
    private String sourcePath;

    @Override
    public String generate(String product) {

        AddonProperties addonProperties = productProperties.getProducts()
            .get(product);

        if (addonProperties == null) {
            LOGGER.warn(
                "Invalid input product. It should be one of {}",
                productProperties.getProducts().keySet());
            return null;
        }

        String zipName = addonProperties.getZipName();

        Path currentDir = Paths.get(sourcePath != null ? sourcePath : "");
        Path originalFilePath = currentDir.resolve(zipName + ".zip")
            .toAbsolutePath();
        Path destPath = currentDir
            .resolve(zipName + "_" + System.currentTimeMillis())
            .toAbsolutePath();
        LOGGER.info("Unzip file [{}]...", originalFilePath);
        unzip(originalFilePath.toString(), destPath.toString());

        LOGGER.info(
            "Destination path [{}]",
            destPath.resolve(zipName).toAbsolutePath());

        addonProperties.getMapTos().forEach((m) -> {

            String source = m.getSource();
            Path addonFilePath = Paths.get(source).toAbsolutePath();
            Path mapTopFilePath = Paths
                .get(destPath.resolve(zipName).toString(), m.getDestination())
                .toAbsolutePath();
            try {

                File mapToFile = mapTopFilePath.toFile();
                if (!mapToFile.exists()) {
                    mapToFile.createNewFile();
                }
                LOGGER.info(
                    "Copied file [{}] to [{}]...",
                    source,
                    mapTopFilePath);
                if (addonFilePath.toFile().isFile()) {
                    FileUtils.copyFile(
                        addonFilePath.toFile(),
                        mapTopFilePath.toFile());
                }
                else {
                    FileUtils.copyDirectory(
                        addonFilePath.toFile(),
                        mapTopFilePath.toFile());
                }

            }
            catch (IOException e) {
                LOGGER.error(
                    "Failed to copy addon file [{}] to [{}]",
                    source,
                    mapTopFilePath,
                    e);
            }
        });

        return null;
    }

    @Override
    public String productShortName() {
        return "am310";
    }

}
