package br.com.aleferamos.BookStore.Utils.shared;


import com.google.gson.Gson;

import lombok.SneakyThrows;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
public class BookStoreService<T> {

    @SneakyThrows
    public String uploadFile(String pasta, MultipartFile arquivoCarregado){

        String nomeArquivo = UUID.randomUUID() + "." + StringUtils.getFilenameExtension((arquivoCarregado.getOriginalFilename()));

        File novoArquivo = new File(pasta + "/" + nomeArquivo);

        FileOutputStream saida = new FileOutputStream(novoArquivo);

        copiar(new BufferedInputStream(arquivoCarregado.getInputStream()), saida);

        return nomeArquivo;
    }

    private void copiar(InputStream origem, OutputStream destino) {

        int bite = 0;
        byte[] tamanhoMaximo = new byte[1024 * 8];

        try {
            while((bite = origem.read(tamanhoMaximo)) >= 0) {
                destino.write(tamanhoMaximo, 0, bite);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block e.printStackTrace();
        }
    }

    public T fromJsonToEntity(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

}
