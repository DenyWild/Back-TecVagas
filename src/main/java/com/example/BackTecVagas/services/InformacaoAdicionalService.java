package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.InformacaoAdicionalForm;
import com.example.BackTecVagas.dto.InformacaoAdicionalResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.InformacaoAdicional;
import com.example.BackTecVagas.repositories.InformacaoAdicionalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformacaoAdicionalService {


    @Autowired
    private InformacaoAdicionalRepository informacaoAdicionalRepository;

    @Autowired
    private ModelMapper mapper;

    public InformacaoAdicionalResponse cadastrarInformacaoAdicional(@RequestBody InformacaoAdicionalForm form) {

        InformacaoAdicional informacaoAdicional = new InformacaoAdicional();

        BeanUtils.copyProperties(form, informacaoAdicional);

        InformacaoAdicional response = informacaoAdicionalRepository.save(informacaoAdicional);

        return mapper.map(response, InformacaoAdicionalResponse.class);

    }

    public InformacaoAdicionalResponse atualizarInformacaoAdicional(@PathVariable Long id, @RequestBody InformacaoAdicionalForm form) {

        InformacaoAdicional informacaoAdicional = informacaoAdicionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, informacaoAdicional, "id");

        return mapper.map(informacaoAdicionalRepository.save(informacaoAdicional), InformacaoAdicionalResponse.class);

    }

    public InformacaoAdicionalResponse buscarInformacaoAdicionalPorId(@PathVariable Long id) {

        InformacaoAdicional informacaoAdicional = informacaoAdicionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(informacaoAdicional, InformacaoAdicionalResponse.class);

    }

    public Page<InformacaoAdicionalResponse> listarTodosInformacoesAdicionais(PageRequest pageRequest) {
        Page<InformacaoAdicional> page = informacaoAdicionalRepository.findAll(pageRequest);

        List<InformacaoAdicionalResponse> list = page.getContent().stream().map(InformacaoAdicional -> mapper.map(InformacaoAdicional, InformacaoAdicionalResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarInformacaoAdicional(@PathVariable Long id) {

        InformacaoAdicional informacaoAdicional = informacaoAdicionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        informacaoAdicionalRepository.delete(informacaoAdicional);

    }
}
