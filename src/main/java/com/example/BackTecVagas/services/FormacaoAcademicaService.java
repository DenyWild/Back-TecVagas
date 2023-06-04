package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.CandidatoForm;
import com.example.BackTecVagas.dto.CandidatoResponse;
import com.example.BackTecVagas.dto.FormacaoAcademicaForm;
import com.example.BackTecVagas.dto.FormacaoAcademicaResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Candidato;
import com.example.BackTecVagas.models.FormacaoAcademica;
import com.example.BackTecVagas.repositories.FormacaoAcademicaRepository;
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
public class FormacaoAcademicaService {


    @Autowired
    private FormacaoAcademicaRepository formacaoAcademicaRepository;

    @Autowired
    private ModelMapper mapper;

    public FormacaoAcademicaResponse cadastrarFormmacaoAcademica(@RequestBody FormacaoAcademicaForm form) {

        FormacaoAcademica formacaoAcademica = new FormacaoAcademica();

        BeanUtils.copyProperties(form, formacaoAcademica);

        FormacaoAcademica response = formacaoAcademicaRepository.save(formacaoAcademica);

        return mapper.map(response, FormacaoAcademicaResponse.class);

    }

    public FormacaoAcademicaResponse atualizarFormmacaoAcademica(@PathVariable Long id, @RequestBody FormacaoAcademicaForm form) {

        FormacaoAcademica formacaoAcademica = formacaoAcademicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, formacaoAcademica, "id");

        return mapper.map(formacaoAcademicaRepository.save(formacaoAcademica), FormacaoAcademicaResponse.class);

    }

    public FormacaoAcademicaResponse buscarFormmacaoAcademicaPorId(@PathVariable Long id) {

        FormacaoAcademica formacaoAcademica = formacaoAcademicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(formacaoAcademica, FormacaoAcademicaResponse.class);

    }

    public Page<FormacaoAcademicaResponse> listarTodasFormmacoesAcademicas(PageRequest pageRequest) {
        Page<FormacaoAcademica> page = formacaoAcademicaRepository.findAll(pageRequest);

        List<FormacaoAcademicaResponse> list = page.getContent().stream().map(FormacaoAcademica -> mapper.map(FormacaoAcademica, FormacaoAcademicaResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarFormmacaoAcademica(@PathVariable Long id) {

        FormacaoAcademica formacaoAcademica = formacaoAcademicaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        formacaoAcademicaRepository.delete(formacaoAcademica);

    }
}
