package br.com.aleferamos.BookStore.Utils.shared;

import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioFormDto;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

@Service
public class BookStoreService<T> {

    @Autowired
    private AmazonS3Client awsS3Client;

    public String uploadFile(MultipartFile file, String bucketName){

        String key = UUID.randomUUID() + "." + StringUtils.getFilenameExtension((file.getOriginalFilename()));

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            awsS3Client.putObject(bucketName, key, file.getInputStream(), metadata);
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured while uploading the file");
        }

        awsS3Client.setObjectAcl(bucketName, key, CannedAccessControlList.PublicRead);

        return key;
    }

    public T fromJsonToEntity(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

}
