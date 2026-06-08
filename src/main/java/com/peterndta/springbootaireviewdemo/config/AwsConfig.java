package com.peterndta.springbootaireviewdemo.config;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\nimport org.springframework.beans.factory.annotation.Value;\nimport org.springframework.context.annotation.Bean;\nimport org.springframework.context.annotation.Configuration;\nimport software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;\nimport software.amazon.awssdk.regions.Region;\nimport software.amazon.awssdk.services.s3.S3AsyncClient;\nimport software.amazon.awssdk.services.s3.S3Client;\nimport software.amazon.awssdk.services.ssm.SsmClient;

/**
 * Configuration for AWS services including SSM, S3 async and sync clients.
 */
@Configuration
@RequiredArgsConstructor
public class AwsConfig {
    private static final Logger log = LoggerFactory.getLogger(AwsConfig.class);

    @Value("${aws.region:us-east-1}")
    private String region;

    /**
     * Creates an SSM client with the specified region and default credentials
     * provider.
     *
     * @return The configured {@link SsmClient} instance.
     */
    @Bean
    public SsmClient ssmClient() {
        log.debug("Creating SSM client with region: {}", region);
        return SsmClient.builder().region(Region.of(region)).credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    /**
     * Creates an async S3 client with the specified region and default credentials
     * provider.
     *
     * @return The configured {@link S3AsyncClient} instance.
     */
    @Bean
    public S3AsyncClient s3AsyncClient() {
        log.debug("Creating S3 async client with region: {}", region);
        return S3AsyncClient.builder().region(Region.of(region))
                .credentialsProvider(DefaultCredentialsProvider.create()).build();
    }

    /**
     * Creates a sync S3 client with the specified region and default credentials
     * provider.
     *
     * @return The configured {@link S3Client} instance.
     */
    @Bean
    public S3Client s3Client() {
        log.debug("Creating S3 client with region: {}", region);
        return S3Client.builder().region(Region.of(region)).credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}
