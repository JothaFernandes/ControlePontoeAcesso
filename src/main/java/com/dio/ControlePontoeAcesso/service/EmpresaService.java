package com.dio.ControlePontoeAcesso.service;

import com.dio.ControlePontoeAcesso.model.Empresa;
import com.dio.ControlePontoeAcesso.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa saveEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getByid(Long idEmp) {
        return empresaRepository.findById(idEmp);
    }

    public Empresa updateEmpresa(Empresa empresa){
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Long idEmp) {
        empresaRepository.deleteById(idEmp);
    }
}
