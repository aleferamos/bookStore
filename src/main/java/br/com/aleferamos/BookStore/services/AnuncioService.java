package br.com.aleferamos.BookStore.services;

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
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private BookStoreService bookStoreService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Long save(AnuncioFormDto anuncio, MultipartFile file) throws IOException {

        anuncio.setNomeImagem(bookStoreService.uploadFile(file, "bookstorebr"));
        anuncio.setData(LocalDate.now());

//        isEmpty(anuncio);

        return anuncioRepository.save(modelMapper.map(anuncio, Anuncio.class)).getId();

    }

    public Page<AnuncioDto> findAll(Pageable pageable, String nome){
       return anuncioRepository.findAllAnuncio(pageable, nome);
    }

    public void delete(Long id){
        anuncioRepository.delete(modelMapper.map(findAnuncioById(id), Anuncio.class));
    }

    public AnuncioDto findAnuncioById(Long id){
        return anuncioRepository.findAnuncioById(id).orElseThrow(() -> new RegraDeNegocioException("anuncio.naoEncontrado"));
    }


}