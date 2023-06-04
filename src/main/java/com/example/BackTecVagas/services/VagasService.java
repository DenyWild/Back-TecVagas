package com.example.BackTecVagas.services;

import com.example.BackTecVagas.dto.VagasForm;
import com.example.BackTecVagas.dto.VagasResponse;
import com.example.BackTecVagas.exceptions.ResourceNotFoundException;
import com.example.BackTecVagas.models.Empresa;
import com.example.BackTecVagas.models.Vagas;
import com.example.BackTecVagas.repositories.EmpresaRepository;
import com.example.BackTecVagas.repositories.VagasRepository;
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
public class VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper mapper;

    public VagasResponse cadastrarVaga(@RequestBody VagasForm form) {

        Vagas vaga = new Vagas();

        BeanUtils.copyProperties(form, vaga);

        Vagas response = vagasRepository.save(vaga);

        return mapper.map(response, VagasResponse.class);

    }

    public VagasResponse cadastrarVagaComEmpresa(Long id, String nomeEmpresa ) {

        Empresa empresa = empresaRepository.findByNomeEmpresa(nomeEmpresa);
        Vagas vaga = vagasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        String nomeEmpresaAtual = vaga.getEmpresa().getNomeEmpresa();
        String nomeEmpresaBuscada = empresa.getNomeEmpresa();

        Vagas vagaComEmpresa = new Vagas();

        if(nomeEmpresaAtual.equalsIgnoreCase(nomeEmpresaBuscada)){
             vagaComEmpresa = vagasRepository.save(vaga);
        }
        
        return mapper.map(vagaComEmpresa, VagasResponse.class);

    }

    public VagasResponse atualizarVaga(@PathVariable Long id, @RequestBody VagasForm form) {

        Vagas vaga = vagasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        BeanUtils.copyProperties(form, vaga, "id");

        return mapper.map(vagasRepository.save(vaga), VagasResponse.class);

    }

    public VagasResponse buscarVagaPorId(@PathVariable Long id) {

        Vagas vaga = vagasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

        return mapper.map(vaga, VagasResponse.class);

    }

    public Page<VagasResponse> listarTodasVagas(PageRequest pageRequest) {
        Page<Vagas> page = vagasRepository.findAll(pageRequest);

        List<VagasResponse> list = page.getContent().stream().map(Vagas -> mapper.map(Vagas, VagasResponse.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    public void deletarVaga(@PathVariable Long id) {

        Vagas vaga = vagasRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        vagasRepository.delete(vaga);

    }
}
