package com.deadk.awsproject;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;  

public class Quickstart {

	private static final String AMAZON_ACCESS_KEY = "AKIAI5PZJDA2MDMOTDTQ";
	private static final String AMAZON_SECRET_KEY = "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";
	private static final String S3_BUCKET_NAME = "g5bucket";

//	static BasicAWSCredentials awsCredentials;
//	static AmazonS3 s3Client;
//
//	static {
//
//		awsCredentials = new BasicAWSCredentials(AMAZON_ACCESS_KEY, AMAZON_SECRET_KEY);
//		s3Client = new AmazonS3Client(awsCredentials);
//	}

    public static String UploadFile(MultipartFile file) {


		String link = "";

		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AMAZON_ACCESS_KEY, AMAZON_SECRET_KEY);
		AmazonS3 s3client = new AmazonS3Client(awsCredentials);

		try{

				InputStream input = file.getInputStream();
				String name = file.getOriginalFilename().split("\\.")[0]
						+ "_"
						+ UUID.randomUUID().toString().replaceAll("-", "");
				String ext = FilenameUtils.getExtension(file.getOriginalFilename());
				String nameExt = name + "." + ext;
				s3client.putObject(new PutObjectRequest(S3_BUCKET_NAME, nameExt, input,new ObjectMetadata())
						.withCannedAcl(CannedAccessControlList.PublicRead));

			 	link = s3client
					.getObject(new GetObjectRequest(S3_BUCKET_NAME, nameExt))
					.getObjectContent()
					.getHttpRequest()
					.getURI()
					.toString();

			}
			catch (Exception ex){
				ex.printStackTrace();
				link = "Upload failed!";
		}

		return link;
    } 
}
