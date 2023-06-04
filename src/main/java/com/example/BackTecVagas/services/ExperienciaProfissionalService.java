package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.CandidatoForm;
import com.example.BackTecVagas.dto.CandidatoResponse;
import com.example.BackTecVagas.dto.ExperienciaProfissionalForm;
import com.example.BackTecVagas.dto.ExperienciaProfissionalResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Candidato;
import com.example.BackTecVagas.models.ExperienciaProfissional;
import com.example.BackTecVagas.repositories.ExperienciaProfissionalRepository;
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
public class ExperienciaProfissionalService {


    @Autowired
    private ExperienciaProfissionalRepository experienciaProfissionalRepository;

    @Autowired
    private ModelMapper mapper;

    public ExperienciaProfissionalResponse cadastrarExperienciaProfissional(@RequestBody ExperienciaProfissionalForm form) {

        ExperienciaProfissional experienciaProfissional = new ExperienciaProfissional();

        BeanUtils.copyProperties(form, experienciaProfissional);

        ExperienciaProfissional response = experienciaProfissionalRepository.save(experienciaProfissional);

        return mapper.map(response, ExperienciaProfissionalResponse.class);

    }

    public ExperienciaProfissionalResponse atualizarExperienciaProfissional(@PathVariable Long id, @RequestBody ExperienciaProfissionalForm form) {

        ExperienciaProfissional experienciaProfissional = experienciaProfissionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, experienciaProfissional, "id");

        return mapper.map(experienciaProfissionalRepository.save(experienciaProfissional), ExperienciaProfissionalResponse.class);

    }

    public ExperienciaProfissionalResponse buscarExperienciaProfissionalPorId(@PathVariable Long id) {

        ExperienciaProfissional experienciaProfissional = experienciaProfissionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(experienciaProfissional, ExperienciaProfissionalResponse.class);

    }

    public Page<ExperienciaProfissionalResponse> listarTodasExperienciasProfissionais(PageRequest pageRequest) {
        Page<ExperienciaProfissional> page = experienciaProfissionalRepository.findAll(pageRequest);

        List<ExperienciaProfissionalResponse> list = page.getContent().stream().map(ExperienciaProfissional -> mapper.map(ExperienciaProfissional, ExperienciaProfissionalResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarExperienciaProfissional(@PathVariable Long id) {

        ExperienciaProfissional experienciaProfissional = experienciaProfissionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        experienciaProfissionalRepository.delete(experienciaProfissional);

    }
}
