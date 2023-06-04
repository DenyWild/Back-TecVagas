package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.CandidatoForm;
import com.example.BackTecVagas.dto.CandidatoResponse;
import com.example.BackTecVagas.dto.IdiomaForm;
import com.example.BackTecVagas.dto.IdiomaResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Candidato;
import com.example.BackTecVagas.models.Idioma;
import com.example.BackTecVagas.repositories.IdiomaRepository;
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
public class IdiomaService {


    @Autowired
    private IdiomaRepository idiomaRepository;

    @Autowired
    private ModelMapper mapper;

    public IdiomaResponse cadastrarIdioma(@RequestBody IdiomaForm form) {

        Idioma idioma = new Idioma();

        BeanUtils.copyProperties(form, idioma);

        Idioma response = idiomaRepository.save(idioma);

        return mapper.map(response, IdiomaResponse.class);

    }

    public IdiomaResponse atualizarIdioma(@PathVariable Long id, @RequestBody IdiomaForm form) {

        Idioma idioma = idiomaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, idioma, "id");

        return mapper.map(idiomaRepository.save(idioma), IdiomaResponse.class);

    }

    public IdiomaResponse buscarIdiomaPorId(@PathVariable Long id) {

        Idioma idioma = idiomaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(idioma, IdiomaResponse.class);

    }

    public Page<IdiomaResponse> listarTodosIdiomas(PageRequest pageRequest) {
        Page<Idioma> page = idiomaRepository.findAll(pageRequest);

        List<IdiomaResponse> list = page.getContent().stream().map(Idioma -> mapper.map(Idioma, IdiomaResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarIdioma(@PathVariable Long id) {

        Idioma idioma = idiomaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        idiomaRepository.delete(idioma);

    }
}
