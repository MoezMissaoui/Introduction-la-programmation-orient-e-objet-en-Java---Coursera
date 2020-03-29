class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;
    private int poids ;
    private String couleur ;
    private int age = 0 ;
    private int esperanceVie = ESPERANCE_VIE_DEFAUT ;
    private boolean clonee ;
    
    public Souris(int poids, String couleur, int age, int ev) {
    	this.poids = poids ;
    	this.couleur = couleur ;
    	this.age = age ;
    	this.esperanceVie = ev ;
    	System.out.println("Une nouvelle souris !");
    }
    public Souris(int poids, String couleur, int age) {
    	this.poids = poids ;
    	this.couleur = couleur ;
    	this.age = age ;
    	System.out.println("Une nouvelle souris !");
    }
    public Souris(int poid, String couleur) {
    	this.poids = poid ;
    	this.couleur = couleur ;
    	System.out.println("Une nouvelle souris !");
    }
    
    public Souris(Souris farE5er) {
    	this.poids = farE5er.poids ;
    	this.couleur = farE5er.couleur ;
    	this.age = farE5er.age ;
    	this.esperanceVie = (farE5er.esperanceVie/5)*4 ;
    	this.clonee = true ;
    	System.out.println(" Clonage d'une souris ! ");
    }
    
    public String toString() {
    	String clon = "";
    	if(this.clonee) {
    		clon = ", clonee,";
    	}
    	return "Une souris "+ this.couleur + clon + " de " + this.age + " mois et pesant " + this.poids + " grammes" ;
    }
    
    
    
    public void vieillir() {
    	if(this.age <= this.esperanceVie) {
    		this.age = this.age + 1 ;
    	}
    	if(this.clonee && this.age > (this.esperanceVie/2)  ) {
    		this.couleur = "verte";
    	}	
    }
    
    public void evolue() {
    	vieillir();
    }

}


public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
