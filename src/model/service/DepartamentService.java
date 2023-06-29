package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Departament;

public class DepartamentService {
	
	public List<Departament> findAll(){
		List<Departament> listaDepart = new ArrayList<>();
		listaDepart.add(new Departament(1,"Livros"));
		listaDepart.add(new Departament(2,"Computadores"));
		listaDepart.add(new Departament(3,"Eletrônicos"));
		
		return listaDepart;
	}

}
