package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.CursosForm;
import com.example.BackTecVagas.dto.CursosResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Cursos;
import com.example.BackTecVagas.repositories.CursosRepository;
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
public class CursosService {


    @Autowired
    private CursosRepository cursosRepository;

    @Autowired
    private ModelMapper mapper;

    public CursosResponse cadastrarCurso(@RequestBody CursosForm form) {

        Cursos cursos = new Cursos();

        BeanUtils.copyProperties(form, cursos);

        Cursos response = cursosRepository.save(cursos);

        return mapper.map(response, CursosResponse.class);

    }

    public CursosResponse atualizarCurso(@PathVariable Long id, @RequestBody CursosForm form) {

        Cursos cursos = cursosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, cursos, "id");

        return mapper.map(cursosRepository.save(cursos), CursosResponse.class);

    }

    public CursosResponse buscarCursoPorId(@PathVariable Long id) {

        Cursos cursos = cursosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(cursos, CursosResponse.class);

    }

    public Page<CursosResponse> listarTodosCursos(PageRequest pageRequest) {
        Page<Cursos> page = cursosRepository.findAll(pageRequest);

        List<CursosResponse> list = page.getContent().stream().map(Cursos -> mapper.map(Cursos, CursosResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarCurso(@PathVariable Long id) {

        Cursos cursos = cursosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        cursosRepository.delete(cursos);

    }
}
