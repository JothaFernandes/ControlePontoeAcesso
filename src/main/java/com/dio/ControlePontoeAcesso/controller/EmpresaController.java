package com.dio.ControlePontoeAcesso.controller;

import com.dio.ControlePontoeAcesso.model.Empresa;
import com.dio.ControlePontoeAcesso.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    @GetMapping
    public List<Empresa> getEmpresaList(){
        return empresaService.findAll();
    }

    @GetMapping("/{idEmp}")
    public ResponseEntity<Empresa> getEmpresaByID(@PathVariable("idEmp") Long idEmp) throws Exception {
        return ResponseEntity.ok(empresaService.getByid(idEmp).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Empresa updateEmpresa(@RequestBody Empresa empresa){
        return empresaService.updateEmpresa(empresa);
    }

    @DeleteMapping("/{idEmp}")
    public ResponseEntity deleteByID(@PathVariable("idEmp") Long idEmp) throws Exception{
        try {
            empresaService.deleteEmpresa(idEmp);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok("Empresa deletada com sucesso!");
    }
}
