package com.nve.obono.spring.clientes.apirest.RestController;

import com.nve.obono.spring.clientes.apirest.Service.ServiceCliente;
import com.nve.obono.spring.clientes.apirest.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestCliente {

    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return serviceCliente.findAll();
    }

    @GetMapping("/clientes/{id}")
    public Cliente mostrarId(@PathVariable Long id){
        return serviceCliente.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente cliente){

        return serviceCliente.addCliente(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente modificar(@PathVariable Long id, @RequestBody Cliente cliente ){
        Cliente clienteActual = serviceCliente.findById(id);

        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());
        this.serviceCliente.addCliente(clienteActual);

        return serviceCliente.addCliente(clienteActual);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Long id){
        Cliente clienteAcutual = this.serviceCliente.findById(id);
        serviceCliente.deleteCliente(clienteAcutual);
    }
}
