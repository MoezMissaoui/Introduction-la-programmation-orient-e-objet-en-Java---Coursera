import java.util.ArrayList;

class Auteur {

    private String nom ;
    private boolean prim ;
    
    public Auteur(String nom, boolean prim) {
    	this.nom = nom ;
    	this.prim = prim ;
    }  
    public String getNom() {
    	return this.nom;
    }
    public boolean getPrix() {
    	return this.prim ? true : false;
    }

}

class Oeuvre {
 	private String titre ;
 	private Auteur aut ;
 	private String langue = "francais" ;
 	
 	public Oeuvre(String titre, Auteur aut, String langue) {
 		this.titre = titre;
 		this.aut = aut ;
 		this.langue = langue;
 	}
 	public Oeuvre(String titre, Auteur aut) {
 		this.titre = titre;
 		this.aut = aut ;
 	}
 	public String getTitre() {
    	return this.titre;
    }
 	public Auteur getAuteur() {
    	return this.aut;
    }
 	public String getLangue() {
    	return this.langue;
    }
 	public void afficher() {
 		System.out.println(this.titre+", " + this.aut.getNom() + ", en "+ this.langue);
    }
}

class Exemplaire {
	private Oeuvre oeuvre ;
	
	public Exemplaire(Oeuvre oeuvre) {
		this.oeuvre = oeuvre ;
		System.out.println("Nouvel exemplaire -> "+ this.oeuvre.getTitre() +", "+ this.oeuvre.getAuteur().getNom()+", en " + this.oeuvre.getLangue() );
	}
	
	public Exemplaire(Exemplaire exemp) {
		this.oeuvre = exemp.oeuvre  ;
		System.out.println("Copie d’un exemplaire de -> "+ this.oeuvre.getTitre() +", "+ this.oeuvre.getAuteur().getNom()+", en " + this.oeuvre.getLangue() +"\t" );
	}
	
	public Oeuvre getOeuvre() {
		return this.oeuvre ;
	}
	
	public void afficher() {
 		System.out.print("Un exemplaire de ");
 		this.oeuvre.afficher();
    }
	
}

class Bibliotheque {
	private String nom ;
	private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
	
	public Bibliotheque(String nom) {
		this.nom = nom ;
		System.out.println("La bibliothèque " + this.nom + " est ouverte !");
	}
	public String getNom() {
		return this.nom;
	}
	public int getNbExemplaires() {
		int count = 0 ;
		for (Exemplaire exemplaire : this.exemplaires) {
			count++;
		}
		return count;
	}
	
	public void stocker(Oeuvre ov , int nbr ) {
		for(int i = 0 ; i < nbr ; i++) {
			this.exemplaires.add(new Exemplaire(ov));
		}
	}
	
	public void stocker(Oeuvre ov ) {
		this.stocker(ov, 1);
	}
	
	public ArrayList<Exemplaire> listerExemplaires(String langue) {
		ArrayList<Exemplaire> tab = new ArrayList<Exemplaire>();
		for (Exemplaire exemplaire : this.exemplaires) {
			if(exemplaire.getOeuvre().getLangue() == langue) {
				tab.add(exemplaire);
			}
        }
		return tab;
		
	}
	
	public ArrayList<Exemplaire> listerExemplaires() {
		ArrayList<Exemplaire> tab = new ArrayList<Exemplaire>();
		for (Exemplaire exemplaire : this.exemplaires) {
			tab.add(exemplaire);
        }
		return tab;
	}
	
	public int compterExemplaires(Oeuvre ov) {
		int count = 0 ;
		for (Exemplaire exemplaire : this.exemplaires) {
			if(exemplaire.getOeuvre() == ov) {
				count++ ;
			}
		}
		return count;
	}
	
	public void afficherAuteur(boolean bool ) {
		if(bool) {
			for (Exemplaire exemplaire : this.exemplaires) {
				if(exemplaire.getOeuvre().getAuteur().getPrix()) {
					System.out.println(exemplaire.getOeuvre().getAuteur().getNom());
				}
			}
		}else {
			for (Exemplaire exemplaire : this.exemplaires) {
				if(exemplaire.getOeuvre().getAuteur().getPrix() == false) {
					System.out.println(exemplaire.getOeuvre().getAuteur().getNom());
				}
			}
		}
	}
	
	public void afficherAuteur()  {
		this.afficherAuteur(true);
	}
}




public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> exemplaires) {
    	
    	for (Exemplaire exemplaire : exemplaires) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }
}
