package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.models.Pagamento;
import br.com.aleferamos.BookStore.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional
    public Pagamento save(Pagamento pagamento){
        pagamento.setDataPagamento(LocalDate.now());
        return pagamentoRepository.save(pagamento);
    }
}
