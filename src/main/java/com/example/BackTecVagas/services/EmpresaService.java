package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.EmpresaForm;
import com.example.BackTecVagas.dto.EmpresaResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Empresa;
import com.example.BackTecVagas.repositories.EmpresaRepository;
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
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper mapper;

    public EmpresaResponse cadastrarEmpresa(@RequestBody EmpresaForm form) {

        Empresa empresa = new Empresa();

        BeanUtils.copyProperties(form, empresa);

        Empresa response = empresaRepository.save(empresa);

        return mapper.map(response, EmpresaResponse.class);

    }

    public EmpresaResponse atualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaForm form) {

        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, empresa, "id");

        return mapper.map(empresaRepository.save(empresa), EmpresaResponse.class);

    }

    public EmpresaResponse buscarEmpresaPorId(@PathVariable Long id) {

        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(empresa, EmpresaResponse.class);

    }

    public Page<EmpresaResponse> listarTodasEmpresas(PageRequest pageRequest) {
        Page<Empresa> page = empresaRepository.findAll(pageRequest);

        List<EmpresaResponse> list = page.getContent().stream().map(Empresa -> mapper.map(Empresa, EmpresaResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarEmpresa(@PathVariable Long id) {

        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        empresaRepository.delete(empresa);

    }
}
