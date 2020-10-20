package vn.sps.study.wso2c;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Wso2amGeneratorApplication {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(Wso2amGeneratorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Wso2amGeneratorApplication.class, args)
            .getBean(Wso2amGeneratorApplication.class)
            .generate(args != null && args.length > 0 ? args[0] : null);
    }

    @Autowired
    private WSO2Generator defaultGenerator;

    @Autowired
    private SupportedProductProperties productProperties;

    public void generate(String product) {
        if (product != null) {
            defaultGenerator.generate(product);
        }
        else {
            LOGGER.warn(
                "Invalid input product. It should be one of {}",
                productProperties.getProducts().keySet());
        }
    }
}
