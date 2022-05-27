package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto;
import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import br.com.aleferamos.BookStore.models.Anuncio;
import br.com.aleferamos.BookStore.repositories.AnuncioRepository;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.UUID;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private AmazonS3Client awsS3Client;

    @Transactional
    public Long save(Anuncio anuncio, MultipartFile file) throws IOException {

        Anuncio anuncioSave = new Anuncio(anuncio.getDescricao(), uploadFile(file), anuncio.getData(),
                anuncio.getDataModificacao(), anuncio.getPreco(), anuncio.getLivro() , anuncio.getPessoa());

        isEmpty(anuncioSave);

        return anuncioRepository.save(anuncioSave).getId();

    }

    public Page<AnuncioDto> findAll(Pageable pageable, String nome){
       return anuncioRepository.findAllAnuncio(pageable, nome);
    }

    private String uploadFile(MultipartFile file){

        String extension = StringUtils.getFilenameExtension((file.getOriginalFilename()));

        String key = UUID.randomUUID().toString() + "." + extension;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            awsS3Client.putObject("bookstorebr", key, file.getInputStream(), metadata);
        } catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured while uploading the file");
        }

        awsS3Client.setObjectAcl("bookstorebr", key, CannedAccessControlList.PublicRead);

        return key;
    }

    public void isEmpty(Anuncio anuncio){
        if(anuncio.getDescricao().isEmpty()
                || anuncio.getDescricao() == null
                || anuncio.getNomeImagem().isEmpty()
                || anuncio.getLivro() == null){
            throw new RegraDeNegocioException("atributo.isNull");
        }
    }

}