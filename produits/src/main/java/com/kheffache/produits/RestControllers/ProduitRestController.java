package com.kheffache.produits.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kheffache.produits.Service.ProduitService;
import com.kheffache.produits.models.Produit;

@RestController // wEB SERVICE 
@RequestMapping("/api")// chemin d'acces au projet. apres /produits declarer dans fichier.prepreties
@CrossOrigin // toute les adresses peuvent acceder et consommer le service 

public class ProduitRestController {
	@Autowired
	public ProduitService produitService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits(){
		return produitService.getAllProduits();
	}
	
	@RequestMapping(value="/{idProduit}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("idProduit") Long id) {
		return produitService.getProduit(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Produit createProduit(@RequestBody Produit produit) {
		return produitService.saveProduit(produit);
		}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
		}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
		public void deleteProduit(@PathVariable("id") Long id)
		{
		produitService.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieIdCat(idCat);
		}
	@RequestMapping(value="/prodsByName/{nom}",method = RequestMethod.GET)
	public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
		return produitService.findByNomProduitContains(nom);
	}
}
