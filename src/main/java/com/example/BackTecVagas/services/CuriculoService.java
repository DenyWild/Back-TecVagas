package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.CurriculoForm;
import com.example.BackTecVagas.dto.CurriculoResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Curriculo;
import com.example.BackTecVagas.repositories.CurriculoRepository;
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
public class CuriculoService {


    @Autowired
    private CurriculoRepository curriculoRepository;

    @Autowired
    private ModelMapper mapper;

    public CurriculoResponse cadastrarCurriculo(@RequestBody CurriculoForm form) {

        Curriculo curriculo = new Curriculo();

        BeanUtils.copyProperties(form, curriculo);

        Curriculo response = curriculoRepository.save(curriculo);

        return mapper.map(response, CurriculoResponse.class);

    }

    public CurriculoResponse atualizarCurriculo(@PathVariable Long id, @RequestBody CurriculoForm form) {

        Curriculo curriculo = curriculoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, curriculo, "id");

        return mapper.map(curriculoRepository.save(curriculo), CurriculoResponse.class);

    }

    public CurriculoResponse buscarCurriculoPorId(@PathVariable Long id) {

        Curriculo curriculo = curriculoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(curriculo, CurriculoResponse.class);

    }

    public Page<CurriculoResponse> listarTodosCurriculos(PageRequest pageRequest) {
        Page<Curriculo> page = curriculoRepository.findAll(pageRequest);

        List<CurriculoResponse> list = page.getContent().stream().map(Curriculo -> mapper.map(Curriculo, CurriculoResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarCurriculo(@PathVariable Long id) {

        Curriculo curriculo = curriculoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        curriculoRepository.delete(curriculo);

    }
}
