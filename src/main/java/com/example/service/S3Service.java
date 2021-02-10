package com.example.service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.micronaut.context.annotation.Value;

import javax.inject.Singleton;

@Singleton
public class S3Service {

    private static final Regions REGION = Regions.EU_CENTRAL_1;

    //local run
//    @Value("${aws.s3AccessKeyId}")
//    private String accessKeyId;
//    @Value("${aws.s3SecretKey}")
//    private String secretKey;

    //deploy
    private final String accessKeyId = System.getenv("AWS_S3_ACCESS_KEY_ID");
    private final String secretKey = System.getenv("AWS_S3_SECRET_KEY");

    public void connectToS3() {
        AmazonS3 amazonS3Client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(this.getAWSCredentials()))
                .withRegion(REGION)
                .build();
        System.out.printf("S3 region: %s%n", amazonS3Client.getRegion().name());
    }


    private AWSCredentials getAWSCredentials() {
        return new BasicAWSCredentials(this.accessKeyId, this.secretKey);
    }
}
