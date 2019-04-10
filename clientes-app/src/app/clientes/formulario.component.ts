import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html'
})
export class FormularioComponent implements OnInit {

  private cliente: Cliente = new Cliente();
  private titulo: string = 'Crear Cliente';

  constructor(private clienteService: ClienteService, private router: Router) { }

  ngOnInit() {
  }

  public create(): void{
    this.clienteService.createCliente(this.cliente).subscribe(
      response => this.router.navigate(['/clientes'])
    )
    console.log("clicked");
    console.log(this.cliente);
  }

}
