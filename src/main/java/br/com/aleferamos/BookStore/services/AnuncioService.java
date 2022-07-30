package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.Utils.Enum.StatusAnuncioEnum;
import br.com.aleferamos.BookStore.Utils.shared.BookStoreService;
import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioDto;
import br.com.aleferamos.BookStore.controllers.dto.anuncio.AnuncioFormDto;
import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import br.com.aleferamos.BookStore.models.Anuncio;
import br.com.aleferamos.BookStore.repositories.AnuncioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

@Service
@SuppressWarnings("unchecked")
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public Long save(String anuncio, MultipartFile file) {

      AnuncioFormDto anuncioSave = (AnuncioFormDto) bookStoreService.fromJsonToEntity(anuncio, AnuncioFormDto.class);

        anuncioSave.setNomeImagem(bookStoreService
                .uploadFile("/home/alefep/Documentos/bookstore-angular/src/assets/images_posts", file));

        anuncioSave.setData(LocalDate.now());
        anuncioSave.setStatus(StatusAnuncioEnum.CREATED);
        return anuncioRepository.save(modelMapper.map(anuncioSave, Anuncio.class)).getId();

    }

    public Page<AnuncioDto> findAll(Pageable pageable, String nome){
       return anuncioRepository.findAllAnuncio(pageable, nome);
    }

    public void delete(Long id){
        anuncioRepository.delete(modelMapper.map(findAnuncioById(id), Anuncio.class));
    }

    public AnuncioDto findAnuncioById(Long id){
        return anuncioRepository.findAnuncioById(id)
                .orElseThrow(() -> new RegraDeNegocioException("anuncio.NaoEncontrado"));
    }

    public Page<AnuncioDto> findAllByStatus(Pageable pageable, String status){
        switch (status){
            case "CREATED":
                return anuncioRepository.findAllByStatus(pageable, StatusAnuncioEnum.CREATED)
                        .map(anuncioConvert -> modelMapper.map(anuncioConvert, AnuncioDto.class));

            case "AUTHORIZED":
                return anuncioRepository.findAllByStatus(pageable, StatusAnuncioEnum.AUTHORIZED)
                        .map(anuncioConvert -> modelMapper.map(anuncioConvert, AnuncioDto.class));
            case "UNAUTHORIZED":
                return anuncioRepository.findAllByStatus(pageable, StatusAnuncioEnum.UNAUTHORIZED)
                        .map(anuncioConvert -> modelMapper.map(anuncioConvert, AnuncioDto.class));
            default:
                return null;
        }

    }

    @Transactional
    public void changeStatus(Long id, Integer status){

        AnuncioDto anuncio = findAnuncioById(id);

        switch (status){
            case 0:
                anuncio.setStatus(StatusAnuncioEnum.CREATED);
                break;
            case 1:
                anuncio.setStatus(StatusAnuncioEnum.AUTHORIZED);
            break;
            case 2:
                anuncio.setStatus(StatusAnuncioEnum.UNAUTHORIZED);
                break;
        }

        anuncioRepository.save(modelMapper.map(anuncio, Anuncio.class));
    }


}