package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.CandidatoForm;
import com.example.BackTecVagas.dto.CandidatoResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Candidato;
import com.example.BackTecVagas.repositories.CandidatoRepository;
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
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private ModelMapper mapper;

    public CandidatoResponse cadastrarCandidato(@RequestBody CandidatoForm form) {

        Candidato candidato = new Candidato();

        BeanUtils.copyProperties(form, candidato);

        Candidato response = candidatoRepository.save(candidato);

        return mapper.map(response, CandidatoResponse.class);

    }

    public CandidatoResponse atualizarCandidato(@PathVariable Long id, @RequestBody CandidatoForm form) {

        Candidato candidato = candidatoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, candidato, "id");

        return mapper.map(candidatoRepository.save(candidato), CandidatoResponse.class);

    }

    public CandidatoResponse buscarCandidatoPorId(@PathVariable Long id) {

        Candidato candidato = candidatoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(candidato, CandidatoResponse.class);

    }

    public Page<CandidatoResponse> listarTodosCandidatos(PageRequest pageRequest) {
        Page<Candidato> page = candidatoRepository.findAll(pageRequest);

        List<CandidatoResponse> list = page.getContent().stream().map(Candidato -> mapper.map(Candidato, CandidatoResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarCandidato(@PathVariable Long id) {

        Candidato candidato = candidatoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        candidatoRepository.delete(candidato);

    }


}
